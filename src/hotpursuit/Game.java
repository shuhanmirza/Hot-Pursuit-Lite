package hotpursuit;

import hotpursuit.constants.Numbers;
import hotpursuit.constants.Strings;
import hotpursuit.gfx.Assets;
import hotpursuit.state.MenuState;
import hotpursuit.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private Display display;
    private Thread thread;
    private final int width;
    private final int height;
    private final String title;

    private final KeyManager keyManager;

    boolean running = false;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        State menuState = new MenuState(this);
        State.setState(menuState);
    }

    private void tick() {
        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        BufferStrategy bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        //clearing screen
        graphics.clearRect(0, 0, width, height);

        //drawing start
        if (State.getState() != null) {
            State.getState().render(graphics);
        }

        //drawing end
        bufferStrategy.show();
        graphics.dispose();

    }

    public void run() {
        init();

        int fps = Numbers.GAME_FPS;
        double timePerTick = 1000000000.00 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }

        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this, Strings.GAME_THREAD_NAME);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }

        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

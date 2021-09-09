package hotpursuit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private final boolean[] keys;

    public boolean up, down, left, right, enter;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        right = keys[KeyEvent.VK_RIGHT];
        left = keys[KeyEvent.VK_LEFT];
        enter = keys[KeyEvent.VK_ENTER];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

}

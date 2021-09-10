package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.constants.Dimensions;
import hotpursuit.gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    Game game;
    State gameState;

    public MenuState(Game game) {
        super(game);
        this.game = game;
        gameState = new GameState(Dimensions.WINDOW_WIDTH, Dimensions.WINDOW_HEIGHT, game);
    }

    public void tick() {
        if (game.getKeyManager().enter) { // if 'enter' pressed
            State.setState(gameState);
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(Assets.imgMenu, 0, 0, null);
    }

}

package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.constants.Dimensions;
import hotpursuit.gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    Game game;

    public MenuState(Game game) {
        super(game);
        this.game = game;
    }

    public void tick() {
        if (game.getKeyManager().enter) {
            State gameState = new GameState(Dimensions.WINDOW_WIDTH, Dimensions.WINDOW_HEIGHT, game);
            State.setState(gameState);
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.menu, 0, 0, null);
    }

}

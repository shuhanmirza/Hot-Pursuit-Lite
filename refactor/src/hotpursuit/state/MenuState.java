package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.gfx.*;

import java.awt.Graphics;

public class MenuState extends State
{

    private State gameState;
    Game game;

    public MenuState(Game game)
    {
        super(game);
        this.game = game;
    }

    public void tick()
    {

        if (game.getKeyManager().enter == true) {
            gameState = new GameState(481, 546, game);
            State.setState(gameState);
        }
    }

    public void render(Graphics g)
    {
        g.drawImage(Assets.menu, 0, 0, null);
    }

}

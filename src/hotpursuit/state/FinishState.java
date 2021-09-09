package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.gfx.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class FinishState extends State
{

    String points;
    GameState gameState;

    public FinishState(Game game, String points)
    {
        super(game);
        this.points = points;
    }

    public void tick()
    {
        if (super.game.getKeyManager().enter == true) {
            gameState = new GameState(481, 546, super.game);
            State.setState(gameState);
        }
    }

    public void render(Graphics g)
    {
        g.drawImage(Assets.finish, 0, 0, null);

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("POINTS =", 150, 300);

        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString(points, 280, 300);
        
        g.setColor(Color.orange);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("press enter to try again", 100, 400);

    }

}

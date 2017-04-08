package retrorunner.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import retrorunner.Game;
import retrorunnner.gfx.Assets;

public class FinishState extends State
{

    String points;

    public FinishState(Game game, String points)
    {
        super(game);
        this.points = points;
    }

    public void tick()
    {

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

    }

}

package hotpursuit.entity;

import hotpursuit.Game;
import hotpursuit.gfx.*;
import java.awt.*;

public class Player extends Entity{
    private Game game;

    float x, y;

    public Player(float x, float y, Game game)
    {
        super(x, y);
        this.x = x;
        this.y = y;
        this.game = game;
    }

    public void tick()
    {
        if (game.getKeyManager().left == true && x >= 123) {
            x -= 3;
        }
        if (game.getKeyManager().right == true && x <= 297) {
            x += 3;
        }
    }

    public void render(Graphics g)
    {
        g.drawImage(Assets.imgPlayerCar, (int) x, (int) y, null);
        //System.out.println(x);
    }

    public int getX()
    {
        return (int)x;
    }

    public int getY()
    {
        return (int)y;
    }

}

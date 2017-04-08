package retrorunner.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import retrorunner.Game;
import retrorunner.entity.Player;
import retrorunner.entity.PublicCar;
import retrorunnner.gfx.Assets;

public class GameState extends State
{

    public int width, height;
    int x;
    int r;

    private State finishState;

    int random;
    Random rand;

    float playerPosX;
    float playerPosY;

    int speed;

    Player player;
    PublicCar publicCar;

    public GameState(int width, int height, Game game)
    {
        super(game);
        this.width = width;
        this.height = height;

        playerPosY = 400;
        playerPosX = 150;

        player = new Player(playerPosX, playerPosY, game);
        rand = new Random();
        random = rand.nextInt(10);

        publicCar = new PublicCar(random);

        r = -450;
        speed = 0;

    }

    @Override
    public void tick()
    {
        player.tick();
        publicCar.tick();

        if (game.getKeyManager().up == true && speed <= 200) {
            speed += 1;
        }
        if (game.getKeyManager().down == true && speed >= 0) {
            speed -= 1;
        }

        r += 10;
        if (r >= -10) {
            r = -450;
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.Road, 0, r, null);
        player.render(g);
        publicCar.render(g);

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
        g.drawString("POINTS", 10, 40);

        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(Integer.toString(publicCar.getCount()), 35, 60);

        checkCollision(player.getX(), player.getY(), publicCar.getX(), publicCar.getY());
    }

    public void checkCollision(int x1, int y1, int x2, int y2)
    {
        Rectangle r1 = new Rectangle(x1, y1, 64, 125);
        Rectangle r2 = new Rectangle(x2, y2, 75, 125);

        if (r1.intersects(r2)) {
            String points = Integer.toString(publicCar.getCount());
            finishState = new FinishState(game, points);
            State.setState(finishState);
        }
    }

}

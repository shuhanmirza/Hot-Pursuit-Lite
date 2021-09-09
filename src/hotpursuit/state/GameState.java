package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.constants.Positions;
import hotpursuit.constants.Strings;
import hotpursuit.entity.Player;
import hotpursuit.entity.PublicCar;
import hotpursuit.gfx.Assets;

import java.awt.*;
import java.util.Random;


public class GameState extends State {

    public int width, height;
    int roadPosY;

    int random;
    Random rand;

    float playerPosX;
    float playerPosY;

    Player player;
    PublicCar publicCar;

    public GameState(int width, int height, Game game) {
        super(game);
        this.width = width;
        this.height = height;

        playerPosY = Positions.PLAYER_STARTING_POS_Y;
        playerPosX = Positions.PLAYER_STARTING_POS_X;

        player = new Player(playerPosX, playerPosY, game);
        rand = new Random();
        random = rand.nextInt(10);

        publicCar = new PublicCar(random);

        roadPosY = Positions.ROAD_STARTING_POS_Y;
    }

    @Override
    public void tick() {
        player.tick();
        publicCar.tick();

        roadPosY += Positions.ROAD_POS_INCREMENT_Y;
        if (roadPosY >= Positions.ROAD_POS_MAX_Y) {
            roadPosY = Positions.ROAD_STARTING_POS_Y;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Road, Positions.ROAD_STARTING_POS_X, roadPosY, null);
        player.render(g);
        publicCar.render(g);

        g.setColor(Color.white);
        g.setFont(new Font(Strings.GAME_FONT_NAME, Font.PLAIN, 23));
        g.drawString("POINTS", 10, 40);

        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(Integer.toString(publicCar.getCount()), 35, 60);

        checkCollision(player.getX(), player.getY(), publicCar.getX(), publicCar.getY());
    }

    public void checkCollision(int x1, int y1, int x2, int y2) {
        Rectangle r1 = new Rectangle(x1, y1, 64, 125);
        Rectangle r2 = new Rectangle(x2, y2, 75, 125);

        if (r1.intersects(r2)) {
            String points = Integer.toString(publicCar.getCount());
            State finishState = new FinishState(game, points);
            State.setState(finishState);
        }
    }

}

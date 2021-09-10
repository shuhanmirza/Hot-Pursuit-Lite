package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.constants.Dimensions;
import hotpursuit.constants.Positions;
import hotpursuit.constants.Strings;
import hotpursuit.entity.Player;
import hotpursuit.entity.PublicCar;
import hotpursuit.entity.PublicCarGenerationListener;
import hotpursuit.gfx.Assets;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameState extends State implements PublicCarGenerationListener {

    public int width, height;
    int roadPosY;

    int playerPosX;
    int playerPosY;

    Player player;
    PublicCar publicCar;

    int totalScore;

    public GameState(int width, int height, Game game) {
        super(game);
        this.width = width;
        this.height = height;

        playerPosY = Positions.PLAYER_STARTING_POS_Y;
        playerPosX = Positions.PLAYER_STARTING_POS_X;

        player = new Player(playerPosX, playerPosY, game);
        publicCar = new PublicCar(this);

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
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.imgRoad, Positions.ROAD_STARTING_POS_X, roadPosY, null);
        player.render(graphics);
        publicCar.render(graphics);

        graphics.setColor(Color.white);
        graphics.setFont(new Font(Strings.GAME_FONT_NAME, Font.PLAIN, Dimensions.GAME_SCORE_TEXT_SIZE));
        graphics.drawString(Strings.GAME_SCORE_TEXT, Positions.GAME_SCORE_TEXT_POS_X, Positions.GAME_SCORE_TEXT_POS_Y);

        graphics.setColor(Color.red);
        graphics.setFont(new Font(Strings.GAME_FONT_NAME, Font.PLAIN, Dimensions.GAME_SCORE_SIZE));
        graphics.drawString(String.valueOf(totalScore), Positions.GAME_SCORE_POS_X, Positions.GAME_SCORE_POS_Y);

        checkCollision(player.getPosX(), player.getPosY(), publicCar.getX(), publicCar.getY());
    }

    private void checkCollision(int playerPosX, int playerPosY, int publicPosX, int publicPosY) {
        Rectangle playerCarRectangle = new Rectangle(playerPosX, playerPosY, Dimensions.PLAYER_CAR_WIDTH, Dimensions.PLAYER_CAR_HEIGHT);
        Rectangle publicCarRectangle = new Rectangle(publicPosX, publicPosY, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);

        if (playerCarRectangle.intersects(publicCarRectangle)) {
            State finishState = new FinishState(game, Integer.toString(totalScore));
            State.setState(finishState);
        }
    }

    @Override
    public void newCarGenerated(int carId) {
        totalScore++;
        Logger.getLogger(Game.class.getName()).log(Level.INFO, "total score -> " + totalScore);
    }
}

package hotpursuit.entity;

import hotpursuit.Game;
import hotpursuit.constants.Positions;
import hotpursuit.gfx.Assets;

import java.awt.*;

public class Player extends Entity {
    private final Game game;

    public Player(int posX, int posY, Game game) {
        super(posX, posY);
        this.game = game;
    }

    public void tick() {
        if (game.getKeyManager().left && posX >= Positions.PLAYER_CAR_POS_MIN_X) {
            posX -= Positions.PLAYER_CAR_POS_CHANGE_X;
        } else if (game.getKeyManager().right && posX <= Positions.PLAYER_CAR_POS_MAX_X) {
            posX += Positions.PLAYER_CAR_POS_CHANGE_X;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(Assets.imgPlayerCar, posX, posY, null);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}

package hotpursuit.entity;

import hotpursuit.constants.Numbers;
import hotpursuit.constants.Positions;
import hotpursuit.gfx.Assets;

import java.awt.*;
import java.util.Objects;

import static hotpursuit.utils.Functions.getRandomInt;

public class PublicCar {

    int carId;
    int posX;
    int posY;
    PublicCarGenerationListener publicCarGenerationListener;

    public PublicCar(PublicCarGenerationListener publicCarGenerationListener) {
        this.publicCarGenerationListener = publicCarGenerationListener;
        generateCar(null, Positions.PUBLIC_CAR_INIT_POS_Y, getRandomInt(5));
    }

    private void generateCar(Integer X, Integer Y, Integer CAR_ID) {
        carId = Objects.requireNonNullElseGet(CAR_ID, ()-> getRandomInt(Numbers.GAME_TOTAL_PUBLIC_CAR_NUMBERS));
        posX = Objects.requireNonNullElseGet(X, () -> isCarDirectionUp(carId) ? Positions.PUBLIC_CAR_UP_STARTING_POS_X : Positions.PUBLIC_CAR_DOWN_STARTING_POS_X);
        posY = Objects.requireNonNullElseGet(Y, () -> Positions.PUBLIC_CAR_STARTING_POS_Y);

        publicCarGenerationListener.newCarGenerated(carId);
    }

    public void tick() {
        posY += isCarDirectionUp(carId) ? Positions.PUBLIC_CAR_UP_INCREMENT_Y : Positions.PUBLIC_CAR_DOWN_INCREMENT_Y;

        if (posY > Positions.PUBLIC_CAR_POS_MAX_Y) {
            generateCar(null, null, null);
        }

    }

    private boolean isCarDirectionUp(int carId) {
        return carId < Numbers.GAME_TOTAL_PUBLIC_CAR_NUMBERS / 2;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(Assets.imgPublicCar[carId], posX, posY, null);
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }
}

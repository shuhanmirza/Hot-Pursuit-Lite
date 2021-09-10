package hotpursuit.gfx;

import hotpursuit.constants.Dimensions;
import hotpursuit.constants.Numbers;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage imgPlayerCar;
    public static BufferedImage[] imgPublicCar;
    public static BufferedImage imgRoad;
    public static BufferedImage imgFinish;
    public static BufferedImage imgMenu;

    private static final String pathImgPublicCarUp = "resources/public_car_up.png";
    private static final String pathImgPublicCarDown = "resources/public_car_down.png";
    private static final String pathImgPlayerCar = "resources/player_car.png";
    private static final String pathImgRoad = "resources/road.png";
    private static final String pathImgMenu = "resources/menu.png";
    private static final String pathImgFinish = "resources/finish.png";

    public static void init() {
        imgPlayerCar = ImageLoader.LoadImage(pathImgPlayerCar);
        imgRoad = ImageLoader.LoadImage(pathImgRoad);
        imgFinish = ImageLoader.LoadImage(pathImgFinish);
        imgMenu = ImageLoader.LoadImage(pathImgMenu);

        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage(pathImgPublicCarUp));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage(pathImgPublicCarDown));

        imgPublicCar = new BufferedImage[Numbers.GAME_TOTAL_PUBLIC_CAR_NUMBERS]; //10

        imgPublicCar[0] = sheet1.Crop(0, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[1] = sheet1.Crop(80, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[2] = sheet1.Crop(155, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[3] = sheet1.Crop(230, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[4] = sheet1.Crop(308, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);

        imgPublicCar[5] = sheet2.Crop(0, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[6] = sheet2.Crop(80, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[7] = sheet2.Crop(155, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[8] = sheet2.Crop(230, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);
        imgPublicCar[9] = sheet2.Crop(308, 0, Dimensions.PUBLIC_CAR_WIDTH, Dimensions.PUBLIC_CAR_HEIGHT);

    }
}

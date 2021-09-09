package hotpursuit.gfx;
import java.awt.image.BufferedImage;

public class Assets
{

    public static BufferedImage imgPlayerCar, imgPublicCar[], Road , finish , menu;

    public static void init()
    {
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("resources/PublicCar.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("resources/PublicCar2.png"));

        imgPublicCar = new BufferedImage[10];

        imgPublicCar[0] = sheet1.Crop(0, 0, 75, 125);
        imgPublicCar[1] = sheet1.Crop(80, 0, 75, 125);
        imgPublicCar[2] = sheet1.Crop(155, 0, 75, 125);
        imgPublicCar[3] = sheet1.Crop(230, 0, 75, 125);
        imgPublicCar[4] = sheet1.Crop(308, 0, 75, 125);

        imgPublicCar[5] = sheet2.Crop(0, 0, 75, 125);
        imgPublicCar[6] = sheet2.Crop(80, 0, 75, 125);
        imgPublicCar[7] = sheet2.Crop(155, 0, 75, 125);
        imgPublicCar[8] = sheet2.Crop(230, 0, 75, 125);
        imgPublicCar[9] = sheet2.Crop(308, 0, 75, 125);

        imgPlayerCar = ImageLoader.LoadImage("resources/playerCar3.png");

        Road = ImageLoader.LoadImage("resources/road1.png");
        finish = ImageLoader.LoadImage("resources/finish.png");
        menu = ImageLoader.LoadImage("resources/menu.png");

    }
}

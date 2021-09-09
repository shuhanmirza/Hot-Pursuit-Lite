package hotpursuit.entity;

import java.awt.*;
import java.util.Random;
import hotpursuit.gfx.*;

public class PublicCar {
    int n;
    int posX;
    int posY;

    Random rand;
    int count;

    public PublicCar(int n)
    {
        this.n = n;

        if (n < 5) {
            posX = 150;
            posY = -500;
        } else {
            posX = 250;
            posY = -500;
        }
        count = 0;
    }

    public void tick()
    {
        if (n < 5) {
            posY += 3;
        } else {
            posY += 13;
        }

        if (posY > 600) {
            rand = new Random();
            n = rand.nextInt(10);

            if (n < 5) {
                posX = 150;
                posY = -150;
            } else {
                posX = 250;
                posY = -150;
            }
            count++;
        }

    }

    public void render(Graphics g)
    {
        g.drawImage(Assets.imgPublicCar[n], posX, posY, null);
    }

    public int getX()
    {
        return posX;
    }

    public int getY()
    {
        return posY;
    }
    public int getCount()
    {
        return count;
    }

}

package hotpursuit.entity;

import java.awt.*;

public abstract class Entity {
    protected int posX, posY;

    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}

package bomberman.entities.characters;

import bomberman.entities.Entity;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public abstract class Character extends Entity {
    protected Rectangle bound;
    protected boolean alive = true;
    public boolean removed = false;

    public Character(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    public abstract void update();

    public abstract void render(GraphicsContext g);

    public abstract void calculateMove();

    public abstract void move();

    public abstract void kill();

    public void remove() {
        removed = true;
    }
}

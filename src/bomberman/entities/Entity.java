package bomberman.entities;

import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class Entity {
    protected int x, y;
    protected Sprite sprite;

    public Entity(int x, int y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public abstract void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException;

    public abstract void render(GraphicsContext g);

    public abstract boolean collide(Entity e);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

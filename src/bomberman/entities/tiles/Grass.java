package bomberman.entities.tiles;

import bomberman.entities.Entity;
import bomberman.graphics.Sprite;
import com.sun.prism.Graphics;
import javafx.scene.canvas.GraphicsContext;

public class Grass extends Tile{
    public Grass(int x, int y) {
        super(x, y, Sprite.grass);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }

    @Override
    public boolean collide(Entity e) {
        return true;
    }
}

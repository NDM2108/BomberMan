package bomberman.entities.tiles;

import bomberman.entities.Entity;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Brick extends Tile {
    public Brick(int x, int y) {
        super(x, y, Sprite.brick);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }
}

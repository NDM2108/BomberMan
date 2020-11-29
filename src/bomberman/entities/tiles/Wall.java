package bomberman.entities.tiles;

import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Wall extends Tile{
    public Wall(int x, int y) {
        super(x, y, Sprite.wall);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }
}

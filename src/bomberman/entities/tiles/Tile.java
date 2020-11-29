package bomberman.entities.tiles;

import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public abstract class Tile extends Entity {
    public Tile(int x, int y, Sprite sprite) {
        super(x * Game.TILE_SIZE, y * Game.TILE_SIZE, sprite);
    }

    @Override
    public abstract void update();

    @Override
    public abstract void render(GraphicsContext g);

    public boolean collide(Entity e) {
        return false;
    }
}

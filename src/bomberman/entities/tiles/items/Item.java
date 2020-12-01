package bomberman.entities.tiles.items;

import bomberman.entities.Entity;
import bomberman.entities.bombs.Flame;
import bomberman.entities.tiles.Grass;
import bomberman.entities.tiles.Tile;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Item extends Tile {
    public boolean destroyed = false;
    private final Tile tileUnder;
    public Item(int tileX, int tileY, Sprite sprite) {
        super(tileX, tileY, sprite);
        this.tileUnder = new Grass(tileX, tileY);
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
        return false;
    }

    public Tile getTileUnder() {
        return tileUnder;
    }
}

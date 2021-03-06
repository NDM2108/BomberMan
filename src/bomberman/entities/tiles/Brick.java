package bomberman.entities.tiles;

import bomberman.Board;
import bomberman.entities.Entity;
import bomberman.entities.bombs.Flame;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Brick extends Tile {
    public boolean destroyed = false;
    private Tile tileUnder;
    public Brick(int tileX, int tileY, Tile tileUnder) {
        super(tileX, tileY, Sprite.brick);
        this.tileUnder = tileUnder;
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
        if(e instanceof Flame) {
            destroyed = true;
        }
        return false;
    }

    public Tile getTileUnder() {
        return tileUnder;
    }
}

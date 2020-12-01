package bomberman.entities.tiles.items;

import bomberman.entities.Entity;
import bomberman.entities.characters.Bomber;
import bomberman.graphics.Sprite;

public class BombItem extends Item{
    public BombItem(int tileX, int tileY) {
        super(tileX, tileY, Sprite.powerup_bombs);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Bomber) {
            Bomber.numberOfBombs++;
            destroyed = true;
        }
        return false;
    }
}

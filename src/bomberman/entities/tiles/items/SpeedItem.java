package bomberman.entities.tiles.items;

import bomberman.entities.Entity;
import bomberman.entities.bombs.Bomb;
import bomberman.entities.characters.Bomber;
import bomberman.graphics.Sprite;

public class SpeedItem extends Item{
    public SpeedItem(int tileX, int tileY) {
        super(tileX, tileY, Sprite.powerup_speed);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Bomber) {
            Bomber.speed++;
            destroyed = true;
        }
        return false;
    }
}

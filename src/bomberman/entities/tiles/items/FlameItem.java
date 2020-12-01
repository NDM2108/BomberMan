package bomberman.entities.tiles.items;

import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.characters.Bomber;
import bomberman.graphics.Sprite;

public class FlameItem extends Item{
    public FlameItem(int tileX, int tileY) {
        super(tileX, tileY, Sprite.powerup_flames);
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

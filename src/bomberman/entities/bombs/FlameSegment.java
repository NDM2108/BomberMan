package bomberman.entities.bombs;

import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.characters.Character;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class FlameSegment extends Entity {
    protected boolean last;

    public FlameSegment(int tileX, int tileY, int direction, boolean last) {
        super(tileX * Game.TILE_SIZE, tileY * Game.TILE_SIZE, Sprite.bomb_exploded);
        switch (direction) {
            case 0:
                if(!last) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_top_last2;
                }
                break;
            case 1:
                if(!last) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_right_last2;
                }
                break;
            case 2:
                if(!last) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_down_last2;
                }
                break;
            case 3:
                if(!last) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_left_last2;
                }
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }

    public boolean collide(Entity e) {
        if(e instanceof Character) {
            ((Character)e).kill();
        }
        return true;
    }
}

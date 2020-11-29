package bomberman.entities.bombs;

import bomberman.Board;
import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Bomb extends Entity {
    protected Board board;
    protected int timeToExplode = 200;
    protected int timeAfter = 20;
    protected int animate = 0;
    protected boolean exploded = false;
    public boolean removed = false;
    protected Flame[] flames = new Flame[4];
    protected int radius = 3;

    public Bomb(Board board, int tileX, int tileY) {
        super(tileX * Game.TILE_SIZE, tileY * Game.TILE_SIZE, Sprite.bomb);
        this.board = board;
    }

    @Override
    public void update() {
        if(timeToExplode > 0) {
            timeToExplode--;
        } else {
            if(!exploded)
                explode();
            else
                updateFlames();
            if(timeAfter > 0)
                timeAfter--;
            else
                remove();
        }
    }

    @Override
    public void render(GraphicsContext g) {
        if (exploded) {
            sprite = Sprite.bomb_exploded2;
            renderFlames(g);
        } else {
            sprite = Sprite.movingSprite(Sprite.bombs, animate, 20);
            animate();
        }
        g.drawImage(sprite.image, x, y);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Flame) {
            explode();
            return true;
        }
        return false;
    }

    public void explode() {
        timeToExplode = 0;

//        Character a = board.getMobAt(_x, _y);
//        if(a != null)  {
//            a.kill();
//        }
        for (int i = 0; i < 4; i++) {
            flames[i] = new Flame(board, x / Game.TILE_SIZE, y / Game.TILE_SIZE, i, radius);
        }
        exploded = true;
    }

    public void updateFlames() {
        for (int i = 0; i < 4; i++) {
            if(flames[i] != null) {
                flames[i].update();
            }
        }
    }

    public void renderFlames(GraphicsContext g) {
        for (int i = 0; i < 4; i++) {
            if(flames[i] != null) {
                flames[i].render(g);
            }
        }
    }

    public FlameSegment getFlameSegmentAt(int tileX, int tileY) {
        if(!exploded) return null;

        for (int i = 0; i < flames.length; i++) {
            if(flames[i] == null) return null;
            FlameSegment flameSegment = flames[i].flameSegmentAt(tileX, tileY);
            if(flameSegment != null) {
                return flameSegment;
            }
        }

        return null;
    }

    protected void remove() {
        removed = true;
    }

    public void animate() {
        animate++;
        if (animate > 59) animate = animate % 59;
    }
}
package bomberman.entities.bombs;

import bomberman.Board;
import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.characters.Character;
import bomberman.entities.tiles.Brick;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Flame extends Entity {
    protected Board board;
    protected int direction;
    protected int radius;
    protected int tileX, tileY;
    protected FlameSegment[] flameSegments;

    public Flame(Board board, int tileX, int tileY, int direction, int radius) {
        super(tileX * Game.TILE_SIZE, tileY * Game.TILE_SIZE, Sprite.bomb_exploded);
        this.board = board;
        this.tileX = tileX;
        this.tileY = tileY;
        this.radius = radius;
        this.direction = direction;
        flameSegments = new FlameSegment[calculatePermittedDistance()];
        createFlameSegment();
    }

    private void createFlameSegment() {
        boolean last = false;
        int tileX1 = tileX;
        int tileY1 = tileY;
        for (int i = 0; i < flameSegments.length; i++) {
            last = (i == flameSegments.length - 1);
            switch (direction) {
                case 0 -> tileY1--;
                case 1 -> tileX1++;
                case 2 -> tileY1++;
                case 3 -> tileX1--;
            }
            flameSegments[i] = new FlameSegment(tileX1, tileY1, direction, last);
        }
    }

    private int calculatePermittedDistance() {
        int radius1 = 0;
        int tileX1 = tileX;
        int tileY1 = tileY;
        while (radius1 < this.radius) {
            if (direction == 0) tileY1--;
            if (direction == 1) tileX1++;
            if (direction == 2) tileY1++;
            if (direction == 3) tileX1--;
            if (tileX1 < 0 || tileY1 < 0 || tileX1 > 31 || tileY1 >13) {
                return radius1;
            } else {
                Entity e = board.getEntityAt(tileX1, tileY1);
                Character c = board.getCharacterAt(tileX1, tileY1);
                if(c != null) c.collide(this);
                if (e instanceof Brick || e instanceof Bomb) {
                    e.collide(this);
                    radius1++;
                    return radius1;
                }
                else if (!e.collide(this)) {
                    return radius1;
                }
                else {
                    radius1++;
                }
            }
        }
        return radius1;
    }

    protected FlameSegment flameSegmentAt(int tileX, int tileY) {
        for(FlameSegment flameSegment : flameSegments) {
            if(flameSegment.getX() == tileX * Game.TILE_SIZE
            && flameSegment.getY() == tileY * Game.TILE_SIZE) {
                return flameSegment;
            }
        }
        return null;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(GraphicsContext g) {
        for (int i = 0; i < flameSegments.length; i++) {
            flameSegments[i].render(g);
        }
    }

    @Override
    public boolean collide(Entity e) {
        //TODO
        return false;
    }
}

package bomberman.entities.bombs;

import bomberman.Board;
import bomberman.Game;
import bomberman.Sound;
import bomberman.entities.Entity;
import bomberman.entities.characters.Bomber;
import bomberman.entities.characters.Character;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class Bomb extends Entity {
    protected Board board;
    protected int timeToExplode = 200;
    protected int timeAfter = 20;
    protected int animate = 0;
    protected boolean exploded = false;
    public boolean removed = false;
    protected Flame[] flames = new Flame[4];
    public static int radius = 1;
    protected boolean allowToPass = true;

    public Bomb(Board board, int tileX, int tileY) {
        super(tileX * Game.TILE_SIZE, tileY * Game.TILE_SIZE, Sprite.bomb);
        this.board = board;
    }

    @Override
    public void update() {
        if (timeToExplode > 0) {
            timeToExplode--;
        } else {
            if (!exploded)
                 explode();
            else
                updateFlames();
            if (timeAfter > 0)
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
//        if(e instanceof Flame) {
//            explode();
//        }
        if (e instanceof Bomber) {
            int diffX = e.getX() - this.x;
            int diffY = e.getY() - this.y;
            System.out.println("bb " + e.getY() + " " + y + " " + diffY);

            if ((diffX < -16 || diffX >= 16) || (diffY >= 32 || diffY < -10)) {
                allowToPass = false;
            }
            return allowToPass;
        }
        return false;
    }

    public void explode() {
        timeToExplode = 0;
        
        Character a = board.getCharacterAt(x / Game.TILE_SIZE, y / Game.TILE_SIZE);
        if (a != null) {
            a.kill();
        }
        for (int i = 0; i < 4; i++) {
            flames[i] = new Flame(board, x / Game.TILE_SIZE, y / Game.TILE_SIZE, i, radius);
        }
        exploded = true;
    }

    public void updateFlames() {
        for (int i = 0; i < 4; i++) {
            if (flames[i] != null) {
                flames[i].update();
            }
        }
    }

    public void renderFlames(GraphicsContext g) {
        for (int i = 0; i < 4; i++) {
            if (flames[i] != null) {
                flames[i].render(g);
            }
        }
    }

    public FlameSegment getFlameSegmentAt(int tileX, int tileY) {
        if (!exploded) return null;

        for (int i = 0; i < flames.length; i++) {
            if (flames[i] == null) return null;
            FlameSegment flameSegment = flames[i].flameSegmentAt(tileX, tileY);
            if (flameSegment != null) {
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

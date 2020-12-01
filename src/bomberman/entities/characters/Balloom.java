package bomberman.entities.characters;

import bomberman.Board;
import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.bombs.Flame;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Balloom extends Character{
    protected Board board;
    protected int animate = 0;
    protected int xMove, yMove;
    protected int direction;
    protected int timeAfter = 20;

    public Balloom(Board board, int tileX, int tileY) {
        super(tileX * Game.TILE_SIZE, tileY * Game.TILE_SIZE, Sprite.balloom_left1);
        this.board = board;
    }

    public Balloom(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {
        if(alive) {
            calculateMove();
            chooseSprite();
        } else {
            sprite = Sprite.balloom_dead;
            afterKill();
        }
    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Flame) kill();
        if(e instanceof Bomber) ((Bomber) e).kill();
        return false;
    }

    @Override
    public void calculateMove() {
        xMove = x / Game.TILE_SIZE;
        yMove = y / Game.TILE_SIZE;
        if(x % Game.TILE_SIZE == 0 && y % Game.TILE_SIZE == 0) {
            Random random = new Random();
            direction = random.nextInt(4);
            if (direction == 0) yMove--;
            if (direction == 1) xMove++;
            if (direction == 2) yMove++;
            if (direction == 3) xMove--;
            if (canMove()) {
                move();
            }
        } else {
            move();
        }
    }

    public boolean canMove() {
        Entity e = board.getEntityAt(xMove, yMove);
        return e.collide(this);
    }

    @Override
    public void move() {
        if(direction == 0) y -= 1;
        if(direction == 1) x += 1;
        if(direction == 2) y += 1;
        if(direction == 3) x -= 1;
    }

    @Override
    public void kill() {
        alive = false;
    }

    protected void chooseSprite() {
        if(direction == 1) {
            sprite = Sprite.movingSprite(Sprite.balloom_rights, animate, 20);
            animate();
        }
        if(direction == 3) {
            sprite = Sprite.movingSprite(Sprite.balloom_lefts, animate, 20);
            animate();
        }
    }

    protected void animate() {
        animate++;
        if(animate > 59) animate = animate % 59;
    }

    protected void afterKill() {
        if(timeAfter > 0) timeAfter--;
        else {
            remove();
        }
    }
}

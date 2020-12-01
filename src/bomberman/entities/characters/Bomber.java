package bomberman.entities.characters;

import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.bombs.Bomb;
import bomberman.entities.bombs.Flame;
import bomberman.entities.bombs.FlameSegment;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends Character {
    private final Game game;
    public static int speed = 1;
    public static int lives = 3;
    public static int numberOfBombs = 1;
    protected int animate = 0;
    protected List<Bomb> bombs = new ArrayList<>();
    private int timeAfter = 120;
    private int getNumberOfBombsLeft = 1;
    private boolean isSafe = false;
    private int safeTime = 40;


    public Bomber(Game game, int x, int y) {
        super(x * Game.TILE_SIZE, y * Game.TILE_SIZE, Sprite.player_right);
        this.game = game;
        bound = new Rectangle(this.x, this.y, 22, 32);
    }

    @Override
    public void update() {
        if (alive) {
            boolean temp = collide(game.getBoard().getEntityAt(x / Game.TILE_SIZE, y / Game.TILE_SIZE));
            chooseSprite();
            calculateMove();
            detectPlaceBomb();
            safe();
            getNumberOfBombsLeft = numberOfBombs - game.getBoard().getBombs().size();
            Entity e = game.getBoard().getCharacterAt((x + 16) / Game.TILE_SIZE, (y + 16) / Game.TILE_SIZE);
            if (e != null) {
                e.collide(this);
            }
        } else {
            afterKill();
        }
    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }

    @Override
    public boolean collide(Entity e) {
        if (e instanceof Flame) {
            kill();
        }
        return false;
    }

    @Override
    public void calculateMove() {
        move();
    }

    @Override
    public void move() {
        if (game.isGoRight()) {
            int tileX = (int) (x + bound.getWidth() + Game.PLAYER_SPEED - 1) / Game.TILE_SIZE;
            int tileY1 = (int) (y + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY2 = (int) (y + bound.getHeight() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX, tileY1).collide(this)
                    && game.getBoard().getEntityAt(tileX, tileY2).collide(this)) {
                x += speed;
            }
        }
        if (game.isGoLeft()) {
            int tileX = (int) (x - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY1 = (int) (y + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY2 = (int) (y + bound.getHeight() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX, tileY1).collide(this)
                    && game.getBoard().getEntityAt(tileX, tileY2).collide(this)) {
                x -= speed;
            }
        }
        if (game.isGoUp()) {
            int tileX1 = (int) (x + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileX2 = (int) (x + bound.getWidth() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY = (int) (y - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX1, tileY).collide(this)
                    && game.getBoard().getEntityAt(tileX2, tileY).collide(this)) {
                y -= speed;
            }
        }
        if (game.isGoDown()) {
            int tileX1 = (int) (x + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileX2 = (int) (x + bound.getWidth() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY = (int) (y + bound.getHeight() + Game.PLAYER_SPEED - 1) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX1, tileY).collide(this)
                    && game.getBoard().getEntityAt(tileX2, tileY).collide(this)) {
                y += speed;
            }
        }
    }

    @Override
    public void kill() {
        if (!isSafe) {
            if (lives > 0) {
                lives--;
                isSafe = true;
            }
            if (lives == 0) {
                System.out.println("bomber killed");
                alive = false;
            }
        }
    }

    private void safe() {
        if (isSafe) {
            safeTime--;
            if (safeTime == 0) {
                isSafe = false;
                safeTime = 40;
            }
        }
    }

    private void detectPlaceBomb() {
        if (game.isPlaceBomb()) {
            int tileX = (x + 11) / Game.TILE_SIZE;
            int tileY = (y + 16) / Game.TILE_SIZE;
            if (game.getBoard().getBombAt(tileX, tileY) == null && getNumberOfBombsLeft > 0) {
                game.getBoard().addBombs(new Bomb(game.getBoard(), tileX, tileY));
                System.out.println("placeBomb " + tileX + " " + tileY);
            }
        }
    }

    public boolean collide() {
        return false;
    }

    public void afterKill() {
        if (timeAfter > 0) {
            timeAfter--;
            sprite = Sprite.movingSprite(Sprite.player_deads, 119 - timeAfter, 40);
        } else {
            System.out.println("lose");
        }
    }

    public void chooseSprite() {
        if (game.isGoRight()) {
            sprite = Sprite.movingSprite(Sprite.player_rights, animate, 20);
            animate();
        }
        if (game.isGoLeft()) {
            sprite = Sprite.movingSprite(Sprite.player_lefts, animate, 20);
            animate();
        }
        if (game.isGoUp()) {
            sprite = Sprite.movingSprite(Sprite.player_ups, animate, 20);
            animate();
        }
        if (game.isGoDown()) {
            sprite = Sprite.movingSprite(Sprite.player_downs, animate, 20);
            animate();
        }
    }

    public void animate() {
        animate++;
        if (animate > 59) animate = animate % 59;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }
}
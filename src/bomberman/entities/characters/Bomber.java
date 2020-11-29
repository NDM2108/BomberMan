package bomberman.entities.characters;

import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.bombs.Bomb;
import bomberman.entities.bombs.FlameSegment;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends Character {
    private int bombRate = 1;
    private final Game game;
    protected int animate = 0;
    protected List<Bomb> bombs = new ArrayList<>();

    public Bomber(Game game, int x, int y) {
        super(x * Game.TILE_SIZE, y * Game.TILE_SIZE, Sprite.player_right);
        this.game = game;
        bound = new Rectangle(this.x, this.y, 22, 32);
    }

    @Override
    public void update() {
        boolean temp = collide(game.getBoard().getEntityAt(x / Game.TILE_SIZE, y / Game.TILE_SIZE));
        chooseSprite();
        calculateMove();
        detectPlaceBomb();
    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof FlameSegment) {
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
                x += Game.PLAYER_SPEED;
            }
        }
        if (game.isGoLeft()) {
            int tileX = (int) (x - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY1 = (int) (y + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY2 = (int) (y + bound.getHeight() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX, tileY1).collide(this)
                    && game.getBoard().getEntityAt(tileX, tileY2).collide(this)) {
                x -= Game.PLAYER_SPEED;
            }
        }
        if (game.isGoUp()) {
            int tileX1 = (int) (x + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileX2 = (int) (x + bound.getWidth() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY = (int) (y - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX1, tileY).collide(this)
                    && game.getBoard().getEntityAt(tileX2, tileY).collide(this)) {
                y -= Game.PLAYER_SPEED;
            }
        }
        if (game.isGoDown()) {
            int tileX1 = (int) (x + Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileX2 = (int) (x + bound.getWidth() - Game.PLAYER_SPEED) / Game.TILE_SIZE;
            int tileY = (int) (y + bound.getHeight() + Game.PLAYER_SPEED - 1) / Game.TILE_SIZE;
            if (game.getBoard().getEntityAt(tileX1, tileY).collide(this)
                    && game.getBoard().getEntityAt(tileX2, tileY).collide(this)) {
                y += Game.PLAYER_SPEED;
            }
        }
    }

    @Override
    public void
    kill() {
        System.out.println("killed");
    }

    private void detectPlaceBomb() {
        if (game.isPlaceBomb()) {
            int tileX = (x + 11) / Game.TILE_SIZE;
            int tileY = (y + 16) / Game.TILE_SIZE;
            if (game.getBoard().getBombAt(tileX, tileY) == null) {
                game.getBoard().addBombs(new Bomb(game.getBoard(), tileX, tileY));

                System.out.println("placeBomb " + tileX + " " + tileY);
            }
        }
    }

    public boolean collide() {
        return false;
    }

    public void chooseSprite() {
        if (game.isGoRight()) {
            sprite = Sprite.movingSprite(Sprite.player_rights, animate, 10);
            animate();
        }
        if (game.isGoLeft()) {
            sprite = Sprite.movingSprite(Sprite.player_lefts, animate, 10);
            animate();
        }
        if (game.isGoUp()) {
            sprite = Sprite.movingSprite(Sprite.player_ups, animate, 10);
            animate();
        }
        if (game.isGoDown()) {
            sprite = Sprite.movingSprite(Sprite.player_downs, animate, 10);
            animate();
        }
    }

    public void animate() {
        animate++;
        if (animate > 29) animate = animate % 29;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }
}
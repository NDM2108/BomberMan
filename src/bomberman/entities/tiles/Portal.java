package bomberman.entities.tiles;

import bomberman.Board;
import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.characters.Bomber;
import bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Portal extends Tile{
    private Board board;
    private boolean open = false;
    public Portal(Board board, int tileX, int tileY) {
        super(tileX, tileY, Sprite.portal);
        this.board = board;
    }

    @Override
    public void update() {
        if(board.detectNoEnemies()) open = true;
    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(sprite.image, x, y);
    }

    public boolean collide(Entity e) {
        if(e instanceof Bomber && open) {
            System.out.println("win");
            Board.win = true;
        }
        return false;
    }
}

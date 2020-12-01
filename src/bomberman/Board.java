package bomberman;

import bomberman.entities.Entity;
import bomberman.entities.bombs.Bomb;
import bomberman.entities.bombs.FlameSegment;
import bomberman.entities.characters.Balloom;
import bomberman.entities.characters.Bomber;
import bomberman.entities.characters.Character;
import bomberman.entities.characters.Oneal;
import bomberman.entities.tiles.*;
import bomberman.entities.tiles.items.BombItem;
import bomberman.entities.tiles.items.FlameItem;
import javafx.scene.canvas.GraphicsContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    protected Game game;
    protected Bomber bomber;
    protected LevelLoader levelLoader;
    protected int level;
    public char[][] board;
    private Tile[][] tiles;
    protected List<Bomb> bombs = new ArrayList<>();
    public List<Character> characters = new ArrayList<>();

    public Board(Game game, int level) throws FileNotFoundException {
        this.game = game;
        loadBoard();
    }

    protected void loadBoard() throws FileNotFoundException {
        levelLoader = new LevelLoader(level);
        board = levelLoader.getBoard();
        tiles = new Tile[levelLoader.getHeight()][levelLoader.getWidth()];
        for(int i = 0; i < levelLoader.getHeight(); i++) {
            for(int j = 0; j < levelLoader.getWidth(); j++) {
                if(board[i][j] == '#') tiles[i][j] = new Wall(j, i);
                else if(board[i][j] == '*') tiles[i][j] = new Brick(j, i, new Grass(j, i));
                else if(board[i][j] == 'x') tiles[i][j] = new Brick(j, i, new Portal(this,j, i));
                else if(board[i][j] == 'b') tiles[i][j] = new Brick(j, i, new BombItem(j, i));
                else if(board[i][j] == 'f') tiles[i][j] = new Brick(j, i, new FlameItem(j, i));
                else if(board[i][j] == ' ') tiles[i][j] = new Grass(j, i);
                else if(board[i][j] == 'p') {
                    tiles[i][j] = new Grass(j, i);
                    characters.add(new Bomber(game, j, i));
                }
                else if(board[i][j] == '1') {
                    tiles[i][j] = new Grass(j, i);
                    characters.add(new Balloom(this, j, i));
                }
                else if(board[i][j] == '2') {
                    tiles[i][j] = new Grass(j, i);
                    characters.add(new Oneal(this, j, i));
                }
                else tiles[i][j] = new Grass(j, i);
            }
        }
    }

    protected void update() {
        updateTiles();
        updateBombs();
        updateCharacter();
    }

    public void render(GraphicsContext g) {
        renderTiles(g);
        renderBombs(g);
        renderCharacter(g);
    }

    public boolean detectNoEnemies() {
        return characters.size() == 1 && characters.get(0) instanceof Bomber;
    }

    public Bomber getBomber() {
        for(Character character : characters) {
            if(character instanceof Bomber) return (Bomber) character;
        }
        return null;
    }

    public Tile getTileAt(int tileX, int tileY) {
        return tiles[tileY][tileX];
    }

    public void addBombs(Bomb bomb) {
        bombs.add(bomb);
    }

    public Bomb getBombAt(int tileX, int tileY) {
        for (Bomb bomb : bombs) {
            if (bomb.getX() == tileX * Game.TILE_SIZE
                    && bomb.getY() == tileY * Game.TILE_SIZE) return bomb;
        }
        return null;
    }

    public FlameSegment getFlameSegmentAt(int tileX, int tileY) {
        for (Bomb bomb : bombs) {
            FlameSegment flameSegment = bomb.getFlameSegmentAt(tileX, tileY);
            if(flameSegment != null) {
                return flameSegment;
            }
        }
        return null;
    }

    public Character getCharacterAt(int tileX, int tileY){
        for(Character character : characters) {
            if((character.getX() + 16)/ Game.TILE_SIZE == tileX
                    && (character.getY() + 16) / Game.TILE_SIZE == tileY) {
                return character;
            }
        }
        return null;
    }

    public Entity getEntityAt(int tileX, int tileY) {
        Entity temp = null;

        temp = getFlameSegmentAt(tileX, tileY);
        if( temp != null) {
            return temp;
        }

        temp = getBombAt(tileX, tileY);
        if( temp != null) return temp;

        temp = getTileAt(tileX, tileY);

        return temp;
    }

    protected void updateTiles() {
        for(int i = 0; i < levelLoader.getHeight(); i++) {
            for(int j = 0; j < levelLoader.getWidth(); j++) {
                if(tiles[i][j] instanceof Brick) {
                    if(((Brick) tiles[i][j]).destroyed) {
                        tiles[i][j] = ((Brick) tiles[i][j]).getTileUnder();
                    }
                }
                if(tiles[i][j] instanceof BombItem) {
                    if(((BombItem) tiles[i][j]).destroyed) {
                        tiles[i][j] = ((BombItem) tiles[i][j]).getTileUnder();
                    }
                }
                if(tiles[i][j] instanceof FlameItem) {
                    if(((FlameItem) tiles[i][j]).destroyed) {
                        tiles[i][j] = ((FlameItem) tiles[i][j]).getTileUnder();
                    }
                }
                tiles[i][j].update();
            }
        }
    }

    protected void updateBombs() {
        for(int i = 0; i < bombs.size(); i++) {
            bombs.get(i).update();
            if(bombs.get(i).removed) bombs.remove(i);
        }
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    protected void updateCharacter() {
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).update();
            if(characters.get(i).removed) characters.remove(i);
        }
    }

    protected void renderBombs(GraphicsContext g) {
        for (Bomb bomb : bombs) {
            bomb.render(g);
        }
    }

    protected void renderTiles(GraphicsContext g) {
        for(int i = 0; i < levelLoader.getHeight(); i++) {
            for(int j = 0; j < levelLoader.getWidth(); j++) {
                tiles[i][j].render(g);
            }
        }
    }

    protected void renderCharacter(GraphicsContext g) {
        for (Character character : characters) {
            character.render(g);
        }
    }
}

package bomberman.graphics;

import bomberman.Game;
import javafx.scene.image.Image;

public class Sprite {
    public Image image;
    private final int size = Game.TILE_SIZE;

    public static Sprite grass = new Sprite("sprites/grass.png");
    public static Sprite brick = new Sprite("sprites/brick.png");
    public static Sprite wall = new Sprite("sprites/wall.png");
    public static Sprite portal = new Sprite("sprites/portal.png");

    /*
    |--------------------------------------------------------------------------
    | Bomber Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite("sprites/player_up.png");
    public static Sprite player_down = new Sprite("sprites/player_down.png");
    public static Sprite player_left = new Sprite("sprites/player_left.png");
    public static Sprite player_right = new Sprite("sprites/player_right.png");

    public static Sprite player_up_1 = new Sprite("sprites/player_up_1.png");
    public static Sprite player_up_2 = new Sprite("sprites/player_up_2.png");

    public static Sprite player_down_1 = new Sprite("sprites/player_down_1.png");
    public static Sprite player_down_2 = new Sprite("sprites/player_down_2.png");

    public static Sprite player_left_1 = new Sprite("sprites/player_left_1.png");
    public static Sprite player_left_2 = new Sprite("sprites/player_left_2.png");

    public static Sprite player_right_1 = new Sprite("sprites/player_right_1.png");
    public static Sprite player_right_2 = new Sprite("sprites/player_right_2.png");

    public static Sprite player_dead1 = new Sprite("sprites/player_dead1.png");
    public static Sprite player_dead2 = new Sprite("sprites/player_dead2.png");
    public static Sprite player_dead3 = new Sprite("sprites/player_dead2.png");

    public static Sprite[] player_rights = {Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2};
    public static Sprite[] player_lefts = {Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2};
    public static Sprite[] player_ups = {Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2};
    public static Sprite[] player_downs = {Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2};

    /*
    |--------------------------------------------------------------------------
    | Character
    |--------------------------------------------------------------------------
     */
    //BALLOM
    public static Sprite balloom_left1 = new Sprite("sprites/balloom_left1.png");
    public static Sprite balloom_left2 = new Sprite("sprites/balloom_left2.png");
    public static Sprite balloom_left3 = new Sprite("sprites/balloom_left3.png");

    public static Sprite balloom_right1 = new Sprite("sprites/balloom_right1.png");
    public static Sprite balloom_right2 = new Sprite("sprites/balloom_right2.png");
    public static Sprite balloom_right3 = new Sprite("sprites/balloom_right3.png");

    public static Sprite balloom_dead = new Sprite("sprites/balloom_dead.png");

//    //ONEAL
//    public static Sprite oneal_left1 = new Sprite(16, 11, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_left2 = new Sprite(16, 11, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_left3 = new Sprite(16, 11, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite oneal_right1 = new Sprite(16, 12, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_right2 = new Sprite(16, 12, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_right3 = new Sprite(16, 12, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite oneal_dead = new Sprite(16, 11, 3, SpriteSheet.tiles, 16, 16);
//
//    //Doll
//    public static Sprite doll_left1 = new Sprite(16, 13, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_left2 = new Sprite(16, 13, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_left3 = new Sprite(16, 13, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite doll_right1 = new Sprite(16, 14, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_right2 = new Sprite(16, 14, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_right3 = new Sprite(16, 14, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite doll_dead = new Sprite(16, 13, 3, SpriteSheet.tiles, 16, 16);
//
//    //Minvo
//    public static Sprite minvo_left1 = new Sprite(16, 8, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_left2 = new Sprite(16, 8, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_left3 = new Sprite(16, 8, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite minvo_right1 = new Sprite(16, 9, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_right2 = new Sprite(16, 9, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_right3 = new Sprite(16, 9, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite minvo_dead = new Sprite(16, 8, 8, SpriteSheet.tiles, 16, 16);
//
//    //Kondoria
//    public static Sprite kondoria_left1 = new Sprite(16, 10, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_left2 = new Sprite(16, 10, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_left3 = new Sprite(16, 10, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite kondoria_right1 = new Sprite(16, 11, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_right2 = new Sprite(16, 11, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_right3 = new Sprite(16, 11, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite kondoria_dead = new Sprite(16, 10, 8, SpriteSheet.tiles, 16, 16);
//
//    //ALL
//    public static Sprite mob_dead1 = new Sprite(16, 15, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite mob_dead2 = new Sprite(16, 15, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite mob_dead3 = new Sprite(16, 15, 2, SpriteSheet.tiles, 16, 16);
//
//    /*
//    |--------------------------------------------------------------------------
//    | Bomb Sprites
//    |--------------------------------------------------------------------------
//     */
    public static Sprite bomb = new Sprite("sprites/bomb.png");
    public static Sprite bomb_1 = new Sprite("sprites/bomb_1.png");
    public static Sprite bomb_2 = new Sprite("sprites/bomb_2.png");

    public static Sprite[] bombs = {Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2};
//    /*
//    |--------------------------------------------------------------------------
//    | FlameSegment Sprites
//    |--------------------------------------------------------------------------
//     */
    public static Sprite bomb_exploded = new Sprite("sprites/bomb_exploded.png");
    public static Sprite bomb_exploded1 = new Sprite("sprites/bomb_exploded1.png");
    public static Sprite bomb_exploded2 = new Sprite("sprites/bomb_exploded2.png");

    public static Sprite explosion_vertical = new Sprite("sprites/explosion_vertical.png");
    public static Sprite explosion_vertical1 = new Sprite("sprites/explosion_vertical1.png");
    public static Sprite explosion_vertical2 = new Sprite("sprites/explosion_vertical2.png");

    public static Sprite explosion_horizontal = new Sprite("sprites/explosion_horizontal.png");
    public static Sprite explosion_horizontal1 = new Sprite("sprites/explosion_horizontal1.png");
    public static Sprite explosion_horizontal2 = new Sprite("sprites/explosion_horizontal2.png");

    public static Sprite explosion_horizontal_left_last = new Sprite("sprites/explosion_horizontal_left_last.png");
    public static Sprite explosion_horizontal_left_last1 = new Sprite("sprites/explosion_horizontal_left_last1.png");
    public static Sprite explosion_horizontal_left_last2 = new Sprite("sprites/explosion_horizontal_left_last2.png");

    public static Sprite explosion_horizontal_right_last = new Sprite("sprites/explosion_horizontal_right_last.png");
    public static Sprite explosion_horizontal_right_last1 = new Sprite("sprites/explosion_horizontal_right_last1.png");
    public static Sprite explosion_horizontal_right_last2 = new Sprite("sprites/explosion_horizontal_right_last2.png");

    public static Sprite explosion_vertical_top_last = new Sprite("sprites/explosion_vertical_top_last.png");
    public static Sprite explosion_vertical_top_last1 = new Sprite("sprites/explosion_vertical_top_last1.png");
    public static Sprite explosion_vertical_top_last2 = new Sprite("sprites/explosion_vertical_top_last2.png");

    public static Sprite explosion_vertical_down_last = new Sprite("sprites/explosion_vertical_down_last.png");
    public static Sprite explosion_vertical_down_last1 = new Sprite("sprites/explosion_vertical_down_last1.png");
    public static Sprite explosion_vertical_down_last2 = new Sprite("sprites/explosion_vertical_down_last2.png");
//
//    /*
//    |--------------------------------------------------------------------------
//    | Brick FlameSegment
//    |--------------------------------------------------------------------------
//     */
//    public static Sprite brick_exploded = new Sprite(16, 7, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite brick_exploded1 = new Sprite(16, 7, 2, SpriteSheet.tiles, 16, 16);
//    public static Sprite brick_exploded2 = new Sprite(16, 7, 3, SpriteSheet.tiles, 16, 16);
//
//    /*
//    |--------------------------------------------------------------------------
//    | Powerups
//    |--------------------------------------------------------------------------
//     */
//    public static Sprite powerup_bombs = new Sprite(16, 0, 10, SpriteSheet.tiles, 16, 16);
//    public static Sprite powerup_flames = new Sprite(16, 1, 10, SpriteSheet.tiles, 16, 16);
//    public static Sprite powerup_speed = new Sprite(16, 2, 10, SpriteSheet.tiles, 16, 16);
//    public static Sprite powerup_wallpass = new Sprite(16, 3, 10, SpriteSheet.tiles, 16, 16);
//    public static Sprite powerup_detonator = new Sprite(16, 4, 10, SpriteSheet.tiles, 16, 16);
//    public static Sprite powerup_bombpass = new Sprite(16, 5, 10, SpriteSheet.tiles, 16, 16);
//    public static Sprite powerup_flamepass = new Sprite(16, 6, 10, SpriteSheet.tiles, 16, 16);

    public Sprite(String path) {
        this.image = new Image(path, size, size, false, false);
    }

    public static Sprite movingSprite(Sprite[] sprites, int animate, int time) {
        int animate1 = (int) animate / time;
        return sprites[animate1];
    }
}

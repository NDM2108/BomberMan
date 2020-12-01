package bomberman;

import bomberman.entities.characters.Bomber;
import bomberman.graphics.Sprite;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class Game {
    public static final int WIDTH = 32*31;
    public static final int HEIGHT = 32*13;
    public static final int TILE_SIZE = 32;
    public static int PLAYER_SPEED = 1;
    private Scene scene;
    private Board board;
    private Group root;
    private Pane pane, info;
    private BorderPane borderPane;
    protected boolean goUp, goDown, goLeft, goRight, placeBomb;

    public Game() throws FileNotFoundException {
        pane = new Pane();
        info = new Pane();
        borderPane = new BorderPane();
        board = new Board(this, 1);
    }

    public boolean isGoUp() {
        return goUp;
    }

    public void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }

    public boolean isGoDown() {
        return goDown;
    }

    public void setGoDown(boolean goDown) {
        this.goDown = goDown;
    }

    public boolean isGoLeft() {
        return goLeft;
    }

    public void setGoLeft(boolean goLeft) {
        this.goLeft = goLeft;
    }

    public boolean isGoRight() {
        return goRight;
    }

    public void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }

    public boolean isPlaceBomb() {
        return placeBomb;
    }

    public void setPlaceBomb(boolean placeBomb) {
        this.placeBomb = placeBomb;
    }

    public void createGame(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Label label = new Label("Lives: " + Bomber.lives);
        pane.getChildren().add(canvas);
        info.getChildren().add(label);
        borderPane.setBottom(pane);
        borderPane.setTop(info);
        scene = new Scene(borderPane, WIDTH, HEIGHT + 32);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP -> goUp = true;
                    case DOWN -> goDown = true;
                    case LEFT -> goLeft = true;
                    case RIGHT -> goRight = true;
                    case SPACE -> placeBomb = true;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP -> goUp = false;
                    case DOWN -> goDown = false;
                    case LEFT -> goLeft = false;
                    case RIGHT -> goRight = false;
                    case SPACE -> placeBomb = false;
                }
            }
        });

        final long startNanoTime = System.nanoTime();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            label.setText("Lives: " + Bomber.lives);
            graphicsContext.fillRect(0, 0, WIDTH, HEIGHT);
            board.update();
            board.render(graphicsContext);
        } ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        stage.setScene(scene);
        stage.show();
    }

    public Board getBoard() {
        return board;
    }
}

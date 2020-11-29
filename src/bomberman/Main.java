package bomberman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Bomber Man");
        Button button1 = new Button("Start");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(button1);
        Scene scene = new Scene(anchorPane, Game.WIDTH, Game.HEIGHT);
        stage.setScene(scene);
        stage.show();

        button1.setOnAction(event -> {
            Game game = null;
            try {
                game = new Game();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            game.createGame(stage);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}

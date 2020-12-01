package bomberman;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    public static void bombSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioInputStream audioInputStream =
                AudioSystem.getAudioInputStream(new File("sounds/bomb.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
}

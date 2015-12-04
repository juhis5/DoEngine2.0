package Motor;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 *  Handles playing, stopping, and looping of sounds for the game.
 *
 * Created by Juhis5 on 4.12.2015.
 */
public class Sound {
    private Clip clip;

    /**
     * Initializes the sound by loading it from res folder.
     * Needs a filename of the sound file as a parameter.
     *
     * @param nameOfSoundFile
     */
    public Sound(String nameOfSoundFile) {
        try {
            URL url = this.getClass().getClassLoader()
                    .getResource(nameOfSoundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Plays the clip from the start.
     */
    public void play(){
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }

    /**
     * Loops the clip.
     */
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stops the clip.
     */
    public void stop(){
        clip.stop();
    }
}

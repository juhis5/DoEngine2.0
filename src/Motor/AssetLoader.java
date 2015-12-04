package Motor;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Juhis5 on 27.11.2015.
 * Class is a utility class used to load assets.
 */
public class AssetLoader {

    /**
     * loadTexture method is used to load a texture
     * given as a parameter string "(name of the file)"
     * texture needs to be in res folder. Returns a BufferedImage
     *
     * @param nameOfImg Name of the texture that needs to be loaded
     *                  "name.png"
     * @return BufferedImage
     */
    public BufferedImage loadTexture(String nameOfImg) {
        BufferedImage texture = null;
        try {
            texture = ImageIO.read(getClass().getClassLoader().getResource
                    (nameOfImg));
        } catch (IOException e) {
            System.out.println("io ex");
        }
        return texture;
    }

    /**
     * loadAudio Method is used to retrieve sounds
     * from res folder. Method returns sounds in {@Link Clip} format.
     * Parameter needs the name of the file.
     * .au, .aif, and .wav files are supported.
     *
     * @param nameOfSoundFile name of the sound sile that is going to be loaded.
     *
     * @return Clip object.
     */
    public Clip loadAudio(String nameOfSoundFile){
        Clip clip = null;



        return clip;
    }
}

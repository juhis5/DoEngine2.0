package Motor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Juhis5 on 27.11.2015.
 * Class is a utility class used to load assets.
 */
public class AssetLoader {

    /**
     * loadTexture method is used to load a texture
     * given as a parameter string "res/(name of the file)"
     * tesxture needs to be in res folder. Returns a BufferedImage
     *
     * @param nameOfImg Name of the texture that needs to be loaded
     *                  "res/name.png"
     * @return BufferedImage
     */
    public BufferedImage loadTexture(String nameOfImg) {
        BufferedImage texture = null;
        try {
            texture = ImageIO.read(getClass().getResourceAsStream
                    (nameOfImg));
        } catch (IOException e) {
            System.out.println("io ex");
        }
        return texture;
    }
}

package Motor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class is a utility class used to load assets.
 */
public class AssetLoader {

    /**
     * Loads a texture.
     *
     * Gets as a parameter string "(name of the file)".
     * Texture needs to be in res folder. Returns a BufferedImage.
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
}

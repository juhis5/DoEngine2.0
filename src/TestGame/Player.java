package TestGame;

import Motor.AssetLoader;
import Motor.Drawable;
import Motor.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Juhis5 on 27.11.2015.
 */
public class Player extends Sprite implements Drawable {
    private BufferedImage texture;

    public Player() {
        super(100, 100, 100, 100);
        setMaxSpeed(5);
        setSpeedX(0);
        setSpeedY(5);
        texture = loadTexture("ball.png");
    }

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

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y, null);
    }
}

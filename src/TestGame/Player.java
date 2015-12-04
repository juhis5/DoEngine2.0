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
        setMaxSpeed(10);
        setSpeedX(0);
        setSpeedY(0);
        AssetLoader loader = new AssetLoader();
        texture = loader.loadTexture("ball.png");
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

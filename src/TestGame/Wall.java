package TestGame;

import Motor.Drawable;
import Motor.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Juhis5 on 27.11.2015.
 */
public class Wall extends GameObject implements Drawable {
    private BufferedImage texture;

    public Wall(double x, double y, BufferedImage texture) {
        this.texture = texture;
        setRect(x, y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics bbg) {
        bbg.drawImage(texture, x, y, null);
    }
}

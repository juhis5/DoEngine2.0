package TestGame;

import Motor.Drawable;
import Motor.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Deals with the ball movement and initialization.
 */
public class Ball extends Sprite implements Drawable {

    /**
     * Texture of the ball.
     */
    private BufferedImage texture;

    /**
     * Host.
     */
    private Test host;

    /**
     * Initializes the ball.
     *
     * Sets up the needed variables to operate the ball.
     *
     * @param x Position x of the ball
     * @param y Position y of the ball
     * @param texture Texture of the ball
     * @param host Host game
     */
    public Ball(double x, double y, BufferedImage texture, Test host) {
        super(x, y, texture.getWidth(), texture.getHeight());
        this.host = host;
        this.texture = texture;
        setMaxSpeed(10);
        setSpeedY(random(3, 8));
        setSpeedX(random(3, 8));
    }

    /**
     * Randomizes values between min and max value.
     *
     * Gets min and max as a parameter and randomizes a value between those
     * to variables.
     *
     * @param min minimal value of the returnable
     * @param max maximal value of the returnable
     * @return int random value between min and max.
     */
    public int random(int min, int max) {
        int returnable = min + (int)(Math.random() * ((max - min) + 1));
        return returnable;
    }

    /**
     * Updates the position of the ball and checksBoundaries and collisions.
     *
     * Is called in a loop.
     */
    @Override
    public void update() {
        super.update();
        checkBounds();

        if (checkCollision(host.getPlayer())) {
            setSpeedY(-getSpeedY());
            y = y - 5;
        }
    }

    /**
     * Checks that the ball is between the walls.
     *
     * Makes sure ball can't go over the walls. Checks also if ball has
     * fallen under the board meaning that you loose.
     */
    public void checkBounds() {
        if (x+texture.getWidth() > host.getWindowWidth()) {
            setSpeedX(-getSpeedX());
            x = host.getWindowWidth()-texture.getWidth()-5;
        } else if (x < 0) {
            setSpeedX(-getSpeedX());
            x = 5;
        }

        if (y < 0) {
            setSpeedY(-getSpeedY());
            y = +5;
        }

        if (y > host.getWindowHeight()) {
            youLost();
        }
    }

    /**
     * Prints "Lost".
     */
    public void youLost() {
        System.out.println("Lost");
    }

    /**
     * Draws the ball.
     *
     * @param bbg Graphics variable.
     */
    @Override
    public void draw(Graphics bbg) {
        bbg.drawImage(texture, x, y, null);
    }
}

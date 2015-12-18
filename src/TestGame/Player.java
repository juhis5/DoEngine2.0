package TestGame;

import Motor.AssetLoader;
import Motor.Drawable;
import Motor.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Player class deals with creating and updating the player board.
 *
 * Does everything related to the player.
 */
public class Player extends Sprite implements Drawable {

    /**
     * Texture of the player.
     */
    private BufferedImage texture;

    /**
     * Host.
     */
    private Test host;

    /**
     * Sets up the player.
     *
     * Gets the host game as a parameter.
     *
     * @param host the actual game
     */
    public Player(Test host) {
        super(150, 500, 100, 100);
        this.host = host;
        setMaxSpeed(10);
        setSpeedX(0);
        setSpeedY(0);
        AssetLoader loader = new AssetLoader();
        texture = loader.loadTexture("Plank.png");
    }

    /**
     * Updates the position of the player and checksBoundaries.
     *
     * Is called in a loop.
     */
    @Override
    public void update() {
        super.update();
        checkBounds();
    }

    /**
     * Checks that the player is between the walls.
     *
     * Makes sure player can't go over the walls.
     */
    private void checkBounds() {
        if (x+texture.getWidth() > host.getWindowWidth()) {
            setSpeedX(0);
            x = host.getWindowWidth()-texture.getWidth()-5;
        } else if (x < 0) {
            setSpeedX(0);
            x = 5;
        }
    }

    /**
     * Draws the player.
     *
     * @param g Graphics variable.
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y, null);
    }
}

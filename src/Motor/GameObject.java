package Motor;

import java.awt.*;

/**
 * Abstract class that extends Rectangle.
 *
 * All objects in the game should inherit this class.
 */
public abstract class GameObject extends Rectangle {

    /**
     * Is called every time game loops.
     *
     * Deals with updating the position of the object etc.
     */
    public abstract void update();

    /**
     * Checks collision between 2 GameObjects rectangles.
     *
     * Returns boolean value. True if collision has occurred false
     * if there is no collision.
     *
     * @param e Another GameObject
     * @return boolean value.
     */
    public boolean checkCollision(GameObject e) {
        boolean returnable = false;

        if (this.intersects(e)) {
            returnable = true;
        }

        return returnable;
    }
}

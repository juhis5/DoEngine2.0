package Motor;

import java.awt.*;

/**
 * Created by Juhis5 on 27.11.2015.
 * GameObject is a abstract class that extends Rectangle
 * All objects in the game should inherit this class.
 */
public abstract class GameObject extends Rectangle {

    /**
     * Abstract method that is called every time game loops.
     */
    public abstract void update();

    /**
     * Checks collision between 2 GameObjects rectangles.
     * returns boolean value. True if collision has occurred false
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

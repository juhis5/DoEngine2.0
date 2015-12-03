package Motor;

/**
 * Created by Juhis5 on 27.11.2015.
 * Sprite is a class inherited from {@link GameObject}
 * that holds all the variables needed for a sprite.
 */
public abstract class Sprite extends GameObject {
    private double speedX;
    private double speedY;
    private int maxSpeed;
    private boolean moving;

    /**
     * Constructor sets up the rectangle by the given parameters
     *
     * @param x      Position x of the sprite
     * @param y      Position y of the sprite
     * @param width  width of the sprite
     * @param height height of the sprite
     */
    public Sprite(double x, double y, double width, double height) {
        setRect(x, y, width, height);
    }

    /**
     * Override of the {@link GameObject} update method.
     * updates the position of the sprite according to the
     * speed variables when called.
     */
    @Override
    public void update() {
        x = (int) (x + getSpeedX());
        y = (int) (y + getSpeedY());
    }

    /**
     * Gets maxSpeed variable.
     *
     * @return maxSpeed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the maxSpeed variable
     *
     * @param maxSpeed
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Gets speedX
     *
     * @return speedX
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * Sets speedX
     *
     * @param speedX
     */
    public void setSpeedX(double speedX) {
        if (speedX > maxSpeed) {
            setSpeedX(maxSpeed);
        } else if (speedX < -maxSpeed) {
            setSpeedX(-maxSpeed);
        } else {
            this.speedX = speedX;
        }
    }

    /**
     * Gets speedY
     *
     * @return speedY
     */
    public double getSpeedY() {
        return speedY;
    }

    /**
     * Sets SpeedY
     *
     * @param speedY
     */
    public void setSpeedY(double speedY) {
        if (speedY > maxSpeed) {
            setSpeedY(maxSpeed);
        } else if (speedY < -maxSpeed) {
            setSpeedY(-maxSpeed);
        } else {
            this.speedY = speedY;
        }
    }
}

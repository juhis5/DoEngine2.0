package Motor;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Game class is the main class of the engine.
 *
 * Holds the default canvas
 * and all the gameObjects and loops the game.
 */
public class Game {

    /**
     * Boolean value to check if game is running.
     */
    private boolean isRunning;

    /**
     * Int variable that determines the fps of the game.
     */
    private int fps;

    /**
     * Width of the window.
     */
    private int windowWidth;

    /**
     * Height of the window.
     */
    private int windowHeight;

    /**
     * The JFrame of the game.
     */
    private JFrame frame;

    /**
     * List of all the gameObjects.
     */
    private ArrayList<GameObject> allGameObjects;

    /**
     * The default canvas of the game.
     */
    private GameCanvas canvas;

    /**
     * Constructor.
     *
     * Initializes the game by calling the {@link #initialize()}
     * method.
     *
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     */
    public Game(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        initialize();
    }

    /**
     * Starts the game and runs it in a loop.
     *
     * Method is designed to cap fps into given fps.
     */
    public void run() {
        while (isRunning) {
            long time = System.currentTimeMillis();
            update();
            time = (1000 / fps) - (System.currentTimeMillis() - time);

            if (time > 0) {
                try {
                    Thread.sleep(time);
                } catch (Exception e) {
                    System.out.println("Thread exception");
                }
            }
        }

        frame.setVisible(false);
    }

    /**
     * Updates all the {@link GameObject}by calling their update method.
     *
     * Method is called repeatedly while game is running.
     */
    public void update() {
        for (GameObject e : allGameObjects) {
            e.update();
        }
    }

    /**
     * Sets up everything needed for the game to run.
     */
    public void initialize() {
        allGameObjects = new ArrayList<GameObject>();
        frame = new JFrame();
        isRunning = true;
        fps = 30;
        frame.setTitle("DoEngine");
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        canvas = new GameCanvas(this);
        frame.add(canvas);
    }

    /**
     * Adds a {@link GameObject} into arraylist.
     *
     * @param e method adds this into arraylist.
     */
    public void addGameObject(GameObject e) {
        allGameObjects.add(e);
    }

    /**
     * Gets frame.
     *
     * @return frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Sets frame that is given as a parameter.
     *
     * @param frame sets this as a frame.
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Gets allGameObjects as a Arraylist.
     *
     * @return allGameObjects Arraylist.
     */
    public ArrayList<GameObject> getAllGameObjects() {
        return allGameObjects;
    }

    /**
     * Gets the GameCanvas.
     *
     * @return canvas
     */
    public GameCanvas getCanvas() {
        return canvas;
    }

    /**
     * Sets the canvas (GameCanvas).
     *
     * @param canvas GameCanvas variable
     */
    public void setCanvas(GameCanvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Gets isRunning.
     *
     * @return isRunning
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Sets isRunning.
     *
     * @param isRunning Boolean value
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Gets fps.
     *
     * @return fps
     */
    public int getFps() {
        return fps;
    }

    /**
     * Sets fps.
     *
     * @param fps Int variable the desired fps
     */
    public void setFps(int fps) {
        this.fps = fps;
    }

    /**
     * Gets WindowWidth.
     *
     * @return windowWidth
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    /**
     * Sets windowWidth.
     *
     * @param windowWidth int variable
     */
    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    /**
     * Gets windowHeight.
     *
     * @return windowHeight
     */
    public int getWindowHeight() {
        return windowHeight;
    }

    /**
     * Sets windowHeight.
     *
     * @param windowHeight int variable
     */
    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }
}

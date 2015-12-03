package Motor;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Juhis5 on 27.11.2015.
 * Game class is the main class of the engine. It holds the default canvas
 * and all the gameObjects and loops the game.
 */
public class Game {
    private boolean isRunning;
    private int fps;
    private int windowWidth;
    private int windowHeight;
    private JFrame frame;
    private ArrayList<GameObject> allGameObjects;
    private GameCanvas canvas;

    /**
     * Constructor. Initializes the game by calling the {@link #initialize()}
     * method.
     */
    public Game() {
        initialize();
    }

    /**
     * This method starts the game and runs it in a loop.
     * Method is designed to cap fps into give fps.
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
                }
            }
        }
        frame.setVisible(false);
    }

    /**
     * This method updates all the {@link GameObject}by calling their
     * update method.
     * Method is called repeatedly while game is running.
     */
    public void update() {
        for (GameObject e : allGameObjects) {
            e.update();
        }
    }

    /**
     * This method will set up everything needed for the game to run
     */
    public void initialize() {
        allGameObjects = new ArrayList<GameObject>();
        frame = new JFrame();
        isRunning = true;
        fps = 30;
        windowWidth = 800;
        windowHeight = 800;
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
     * gets frame
     *
     * @return frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Sets frame that is given as a parameter
     *
     * @param frame sets this as a frame.
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Method gets allGameObjects as a Arraylist.
     *
     * @return allGameObjects Arraylist.
     */
    public ArrayList<GameObject> getAllGameObjects() {
        return allGameObjects;
    }

    /**
     * Gets the GameCanvas
     *
     * @return canvas
     */
    public GameCanvas getCanvas() {
        return canvas;
    }

    /**
     * Sets the canvas (GameCanvas)
     *
     * @param canvas
     */
    public void setCanvas(GameCanvas canvas) {
        this.canvas = canvas;
    }

    /**
     * gets isRunning
     *
     * @return isRunning
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Sets isRunning
     *
     * @param isRunning
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Gets fps
     *
     * @return fps
     */
    public int getFps() {
        return fps;
    }

    /**
     * Sets fps
     *
     * @param fps
     */
    public void setFps(int fps) {
        this.fps = fps;
    }

    /**
     * gets WindowWidth
     *
     * @return windowWidth
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    /**
     * Sets windowWidth
     *
     * @param windowWidth
     */
    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    /**
     * Gets windowHeight
     *
     * @return windowHeight
     */
    public int getWindowHeight() {
        return windowHeight;
    }

    /**
     * Sets windowHeight
     *
     * @param windowHeight
     */
    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

}

package TestGame;

import Motor.AssetLoader;
import Motor.Game;
import Motor.Sound;

/**
 * Actual core of the game.
 *
 * Runs the game loop and sets up everything.
 */
public class Test extends Game {

    /**
     * Player object.
     */
    private Player player;

    /**
     * The ball object.
     */
    private Ball ball;

    /**
     * Sound when ball hits the player.
     */
    private Sound crashSound;

    /**
     * Initializes the game.
     *
     * Creates window and one default canvas.
     *
     * @param windowWidth width of the desired window
     * @param windowHeight height of the desired window
     */
    public Test(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        GetInput input = new GetInput(this);
        getCanvas().addMouseListener(input);
        getCanvas().addKeyListener(input);
        player = new Player(this);
        getCanvas().addDrawable(player);
        addGameObject(player);
        AssetLoader loader = new AssetLoader();
        ball = new Ball(200, 200, loader.loadTexture("ball.png"), this);
        crashSound = new Sound("Pat.wav");
        addGameObject(ball);
        getCanvas().addDrawable(ball);
    }

    /**
     * Returns the player.
     *
     * @return Player variable
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Updates the game.
     *
     * Is called all the time in a loop.
     */
    @Override
    public void update() {
        super.update();

        if (player.checkCollision(ball)) {
            crashSound.play();
        }
    }
}

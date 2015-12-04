package TestGame;

import Motor.AssetLoader;
import Motor.Game;
import Motor.Sound;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Juhis5 on 27.11.2015.
 */
public class Test extends Game {
    private Player player;
    private Wall wall;
    private Sound crashSound;

    public Test() {
        super();
        GetInput input = new GetInput(this);
        getCanvas().addMouseListener(input);
        getCanvas().addKeyListener(input);
        player = new Player();
        getCanvas().addDrawable(player);
        addGameObject(player);
        AssetLoader loader = new AssetLoader();
        wall = new Wall(200, 200, loader.loadTexture("wall.png"));
        crashSound = new Sound("Pat.wav");
        addGameObject(wall);
        getCanvas().addDrawable(wall);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void update() {
        super.update();
        if (player.checkCollision(wall)) {
            crashSound.play();
        }
    }
}

package TestGame;

import Motor.AssetLoader;
import Motor.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Juhis5 on 27.11.2015.
 */
public class Test extends Game {
    private Player player;
    private Wall wall;

    public Test() {
        super();
        GetInput input = new GetInput(this);
        getCanvas().addMouseListener(input);
        getCanvas().addKeyListener(input);
        player = new Player();
        getCanvas().addDrawable(player);
        addGameObject(player);
        wall = new Wall(200, 200, loadTexture("wall.png"));
        addGameObject(wall);
        getCanvas().addDrawable(wall);
    }

    public BufferedImage loadTexture(String nameOfImg) {
        BufferedImage texture = null;
        try {
            texture = ImageIO.read(getClass().getClassLoader().getResource
                    (nameOfImg));
        } catch (IOException e) {
            System.out.println("io ex");
        }
        return texture;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void update() {
        super.update();
        if (player.checkCollision(wall)) {
            System.out.println("COLLISION");
        }
    }
}

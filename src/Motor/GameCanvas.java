package Motor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Juhis5 on 27.11.2015.
 * GameCanvas class extends JPanel and is responsible for calling
 * the draw method off all the drawables in drawables Arraylist.
 */
public class GameCanvas extends JPanel {
    Game host;
    private ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    public GameCanvas(Game host) {
        this.host = host;
    }

    /**
     * Adds a new Drawable object into the Arraylist drawables.
     * Gets the drawable as a parameter.
     *
     * @param d is a drawable object that is added into arraylist.
     */
    public void addDrawable(Drawable d) {
        drawables.add(d);
    }

    /**
     * Removes the drawable given as a parameter
     * from the drawables arraylist.
     *
     * @param d removes this drawable from the
     *          arraylist.
     */
    public void removeDrawable(Drawable d) {
        drawables.remove(d);
    }

    /**
     * Draws the objects in Drawables arraylist
     * into JPanel.
     *
     * @param g Graphics object.
     * @see JPanel
     */
    @Override
    public void paintComponent(Graphics g) {
        long time = System.currentTimeMillis();
        super.paintComponent(g);

        BufferedImage backBuffer = new BufferedImage(host.getWindowWidth(),
                host.getWindowHeight(),
                BufferedImage.TYPE_INT_RGB);

        Graphics bbg = backBuffer.getGraphics();

        for (Drawable e : drawables) {
            e.draw(bbg);
        }

        g.drawImage(backBuffer, 0, 0, this);
        repaint();
        time = (1000 / host.getFps()) - (System.currentTimeMillis() - time);
        if (time > 0) {
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        }
    }
}


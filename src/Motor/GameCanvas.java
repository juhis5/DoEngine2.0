package Motor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * GameCanvas class extends JPanel.
 *
 * Is responsible for calling
 * the draw method off all the drawables in drawables ArrayList.
 */
public class GameCanvas extends JPanel {

    /**
     * The host.
     */
    Game host;

    /**
     * Arraylist of all the drawables to be drawn.
     */
    private ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    /**
     * Initializes the canvas.
     *
     * Sets the host variable.
     *
     * @param host the game
     */
    public GameCanvas(Game host) {
        this.host = host;
    }

    /**
     * Adds a new Drawable object into the ArrayList drawables.
     *
     * Gets the drawable as a parameter.
     *
     * @param d is a drawable object that is added into arrayList
     */
    public void addDrawable(Drawable d) {
        drawables.add(d);
    }

    /**
     * Removes the drawable given as a parameter.
     *
     * From the drawables arrayList.
     *
     * @param d removes this drawable
     */
    public void removeDrawable(Drawable d) {
        drawables.remove(d);
    }

    /**
     * Draws the objects in Drawables arrayList.
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
                e.printStackTrace();
            }
        }
    }
}

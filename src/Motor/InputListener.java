package Motor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Juhis5 on 26.11.2015.
 * InputListener inherits {@link MouseAdapter}
 * and implements {@link KeyListener}
 * And so can be used as a key or mouse listener in game.
 */
public class InputListener extends MouseAdapter implements KeyListener {

    /**
     * @param e
     * @see MouseAdapter
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * @param e
     * @see MouseAdapter
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * @param e
     * @see MouseAdapter
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * @param e
     * @see MouseAdapter
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * @param e
     * @see MouseAdapter
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

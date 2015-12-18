package TestGame;

import Motor.InputListener;

import java.awt.event.KeyEvent;

/**
 * Class extends InputListener.
 *
 * Used to handle movement and user input.
 */
public class GetInput extends InputListener {

    /**
     * Host.
     */
    private Test host;

    /**
     * Initializes the listener.
     *
     * @param host host game
     */
    public GetInput(Test host) {
        this.host = host;
        host.getCanvas().requestFocus();
    }

    /**
     * Overrides keypressed method of Inputlistener.
     *
     * Activates if key is pressed.
     *
     * @param e Is a KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Player player = host.getPlayer();

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setSpeedX(player.getSpeedX() - 2);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setSpeedX(player.getSpeedX() + 2);
        }
    }
}

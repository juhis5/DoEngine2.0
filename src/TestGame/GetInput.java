package TestGame;

import Motor.InputListener;

import java.awt.event.KeyEvent;

/**
 * Created by Juhis5 on 27.11.2015.
 */
public class GetInput extends InputListener {
    private Test host;

    public GetInput(Test host) {
        this.host = host;
        host.getCanvas().requestFocus();
    }



    @Override
    public void keyPressed(KeyEvent e) {
        Player player = host.getPlayer();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setSpeedX(player.getSpeedX() - 2);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setSpeedX(player.getSpeedX() + 2);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setSpeedY(player.getSpeedY() - 2);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setSpeedY(player.getSpeedY() + 2);
        }
    }
}

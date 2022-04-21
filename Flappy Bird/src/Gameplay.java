import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private int x = 150;
    private int y = 300;

    private int VelY = -20;

    private boolean isPlaying = false;

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        int delay = 8;
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        g.setColor(new Color(0, 126, 97));
        g.fillRect(0, 0, 400, 700);
        g.setColor(Color.cyan);
        g.fillRect(x, y, 20, 20);


        if(!isPlaying){
            g.setColor(Color.red);
            g.fillRect(x=100, y=100, 200, 200);
            g.setColor(Color.black);
            g.drawString("Press 'Space' to play", 130, 180);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isPlaying) {
            VelY += 1;
            if(VelY > 15){
                VelY = 15;
            }
            y += VelY;
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){

            if(!isPlaying){
                isPlaying = true;
            }else {
                VelY = -20;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

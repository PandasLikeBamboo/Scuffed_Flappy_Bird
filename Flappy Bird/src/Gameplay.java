import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private Bird bird = new Bird(150,300);
    private Pipe pipe = new Pipe(600,300);

    private boolean isPlaying = false;

    private LinkedList<Pipe> pipeList = new LinkedList<>();

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        int delay = 8;
        Timer timer = new Timer(delay, this);
        timer.start();

        pipeList.add(new Pipe(300, 300));
        pipeList.add(new Pipe(500, 250));
        pipeList.add(new Pipe(700, 200));
    }

    public void paint(Graphics g){
        g.setColor(new Color(0, 126, 97));
        g.fillRect(0, 0, 400, 700);


        if(!isPlaying){
            g.setColor(Color.red);
            g.fillRect(100,100, 200, 200);
            g.setColor(Color.black);
            g.drawString("Press 'Space' to play", 130, 180);

        }
        bird.draw(g);

        for (Pipe pipe : pipeList){
            pipe.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isPlaying) {
           bird.move();
           for(Pipe pipe : pipeList){
               pipe.move();
           }

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
                bird.jump();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

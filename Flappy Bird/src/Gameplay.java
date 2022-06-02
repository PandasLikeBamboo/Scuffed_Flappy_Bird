import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private Bird bird;
    private StopWatch pipeDelayer;
    private int delayer;

    private boolean isPlaying = false;

    private LinkedList<Pipe> pipeList;

    Random random;

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        random = new Random();

        int delay = 8;
        Timer timer = new Timer(delay, this);
        timer.start();

        bird = new Bird(150,300);
        isPlaying = false;
        pipeList = new LinkedList<>();

        pipeDelayer = new StopWatch();
        delayer = 2;



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

           if((int)pipeDelayer.getElapsedTimeSeconds() >= delayer){

               int randomHeight = random.nextInt(300);

               pipeList.add(new Pipe(500, randomHeight + 250));
               pipeList.add(new Pipe(500, randomHeight - 250));

               pipeDelayer.start();

           }
           for(Pipe pipe : pipeList){
               pipe.move();
               if(bird.getRect().intersects(pipe.getRect2())){
                   bird = new Bird(150,300);
                   isPlaying = false;
                   pipeList = new LinkedList<>();

                   pipeDelayer = new StopWatch();
                   delayer = 2;


               }
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

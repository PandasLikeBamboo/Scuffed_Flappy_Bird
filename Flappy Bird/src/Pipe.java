import java.awt.*;

public class Pipe {
    private int x;
    private int y;

    private int velY;

    public Pipe(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(){
        x -= 2;
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 100, 500);


    }

}

import java.awt.*;

public class Pipe {
    private int x;
    private int y;

    private int velY;

    private Rectangle rect2;

    public Pipe(int x, int y){
        this.x = x;
        this.y = y;

        rect2 = new Rectangle(this.x, this.y , 50, 300);
    }

    public Rectangle getRect2(){
        return rect2;
    }

    public void move(){
        x -= 2;

        rect2 = new Rectangle(x, y, 50, 300);
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 50, 300);


    }

}

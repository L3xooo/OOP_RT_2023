package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Kruh extends MyShape{

    public Kruh(int x, int y, int radius) {
        super(x, y, radius);
    }
    public Kruh(){}

    public void draw(Graphics g){
        g.fillOval(this.getX(),this.getY(),this.getRadius()*2,this.getRadius()*2);
    }
}

package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Square extends MyShape{

    public Square(int x, int y, int radius) {
        super(x, y, radius);
    }
    public Square(){}
    public void draw(Graphics g){
        g.fillRect(this.getX(),this.getY(),this.getRadius()*2,this.getRadius()*2);
    }
}

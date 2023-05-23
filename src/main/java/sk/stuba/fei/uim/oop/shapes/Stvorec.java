package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Stvorec extends MyShape{

    public Stvorec(int x, int y, int radius) {
        super(x, y, radius);
    }
    public Stvorec(){}
    public void draw(Graphics g){
        g.fillRect(this.getX(),this.getY(),this.getRadius()*2,this.getRadius()*2);
    }
}

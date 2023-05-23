package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class HourGlass extends MyShape{
    public HourGlass(int x, int y, int radius) {
        super(x, y, radius);
    }
    public HourGlass(){}
    @Override
    public void draw(Graphics g){
        int[] xPoints = {this.getX(),this.getX()+getRadius(),this.getX(),this.getX()+getRadius()*2,this.getX()+this.getRadius(),
        this.getX()+this.getRadius()*2,this.getX()};
        int[] yPoints = {this.getY(),this.getY()+this.getRadius(),this.getY()+this.getRadius()*2,this.getY()+this.getRadius()*2,
        this.getY()+this.getRadius(),this.getY(),this.getY()};
        g.fillPolygon(xPoints,yPoints,7);
    }
}

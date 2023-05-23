package sk.stuba.fei.uim.oop.shapes;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
public class MyShape {
    private int x;
    private int y;
    private int radius;
    MyShape(){}
    public MyShape(int x,int y,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(Graphics g){}
}

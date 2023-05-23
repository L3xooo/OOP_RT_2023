package sk.stuba.fei.uim.oop.shapes;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;


@Getter
@Setter
public class Line {
    int x;
    int y;
    int endX;
    int endY;

    public Line(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g){
        g.drawLine(x,y,endX,endY);
    }
}

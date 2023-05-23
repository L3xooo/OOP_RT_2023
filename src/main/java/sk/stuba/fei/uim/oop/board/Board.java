package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.shapes.Line;
import sk.stuba.fei.uim.oop.shapes.MyShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board extends JPanel {
    private List<Line> lines;
    private List<MyShape> myShapes;
    private int spacing;
    private int length;
    private Line line;
    public Board(){
        this.setBackground(Color.cyan);
        this.lines = new ArrayList<>();
        this.myShapes = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for(int a = 0; a < this.getMyShapes().size(); a++) {
            if (a % spacing == 0) {
                myShapes.get(a).draw(g);
            }
        }
    }
}

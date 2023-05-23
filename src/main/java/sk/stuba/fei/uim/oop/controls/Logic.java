package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.shapes.Circle;
import sk.stuba.fei.uim.oop.shapes.MyShape;
import sk.stuba.fei.uim.oop.shapes.HourGlass;
import sk.stuba.fei.uim.oop.shapes.Square;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

@Getter
@Setter
public class Logic extends UniversalAdapter{
    private Board board;
    private int actualLength;
    private int actualRadius;
    private int actualSpacing;
    private MyShape activeShape;
    private JSlider lengthSlider;
    private JSlider radiusSlider;
    private JSlider spacingSlider;

    public Logic(){
        this.activeShape = new Circle();
        lengthSlider = initSlider(10,20,200,20);
        radiusSlider = initSlider(1,1,20,1);
        spacingSlider = initSlider(1,1,20,1);
        initBoard();
    }

    private JSlider initSlider(int choice,int min,int max,int value){
        JSlider slider = new JSlider(JSlider.VERTICAL,min,max,value);
        slider.setFocusable(false);
        slider.setMinorTickSpacing(choice);
        slider.setMajorTickSpacing(choice);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        return slider;
    }

    private void initBoard(){
        this.board = new Board();
        this.actualLength = 20;
        this.actualRadius = 1;
        this.actualSpacing = 1;
        this.getBoard().setSpacing(this.getActualSpacing());
        board.addMouseMotionListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();
        if (source instanceof JSlider) {
            if (source == this.getLengthSlider()) {
                this.setActualLength(((JSlider) source).getValue());
            }
            if (source == this.getRadiusSlider()) {
                this.setActualRadius(((JSlider) source).getValue());
            }
            if (source == this.getSpacingSlider()) {
                this.setActualSpacing(((JSlider) source).getValue());
                this.getBoard().setSpacing(this.getActualSpacing());
            }
        }
    }

    private void drawShapeLine(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        if (this.getBoard().getMyShapes().size() > this.getActualLength()) {
            while(this.getBoard().getMyShapes().size() > this.getActualLength()) {
                this.getBoard().getMyShapes().remove(0);
            }
        }
        if (this.getActiveShape() instanceof Circle) {
            this.getBoard().getMyShapes().add(new Circle(x,y,actualRadius));
        }
        if (this.getActiveShape() instanceof HourGlass) {
            this.getBoard().getMyShapes().add(new HourGlass(x,y,actualRadius));
        }
        if (this.getActiveShape() instanceof Square) {
            this.getBoard().getMyShapes().add(new Square(x,y,actualRadius));
        }
        this.getBoard().revalidate();
        this.getBoard().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        drawShapeLine(e);
       }

    @Override
    public void mouseMoved(MouseEvent e) {
        drawShapeLine(e);
       }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JComboBox) {
            String name = ((JComboBox<String>) source).getItemAt(((JComboBox<String>) source).getSelectedIndex());
            if (name.equals("Kruh")) {
                this.setActiveShape(new Circle());
            }
            if (name.equals("Stvorec")) {
                this.setActiveShape(new Square());
            }
            if (name.equals("Presipacie hodiny")) {
                this.setActiveShape(new HourGlass());
            }
        }
    }
}

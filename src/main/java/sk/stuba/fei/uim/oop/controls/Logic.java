package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.shapes.Kruh;
import sk.stuba.fei.uim.oop.shapes.MyShape;
import sk.stuba.fei.uim.oop.shapes.PresipacieHodiny;
import sk.stuba.fei.uim.oop.shapes.Stvorec;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

@Getter
@Setter
public class Logic extends UniversalAdapter{
    Board board;
    JFrame frame;
    int actualLength;
    int actualRadius;
    int actualSpacing;
    MyShape activeShape;
    public Logic(){
        this.activeShape = new Kruh();
        initBoard();
    }

    private void initBoard(){

        this.board = new Board();
        this.actualLength = 200;
        this.actualRadius = 4;
        this.actualSpacing = 1;
        this.getBoard().setSpacing(actualSpacing);
        board.addMouseMotionListener(this);
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();
        if (source instanceof JSlider) {
            System.out.println(((JSlider) source).getValue());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (this.getBoard().getMyShapes().size() > this.getActualLength()) {
            this.getBoard().getMyShapes().remove(0);
        }
        if (this.getActiveShape() instanceof Kruh) {
            this.getBoard().getMyShapes().add(new Kruh(x,y,actualRadius));
        }
        if (this.getActiveShape() instanceof PresipacieHodiny) {
            this.getBoard().getMyShapes().add(new PresipacieHodiny(x,y,actualRadius));
        }
        if (this.getActiveShape() instanceof Stvorec) {
            this.getBoard().getMyShapes().add(new Stvorec(x,y,actualRadius));
        }
        this.getBoard().revalidate();
        this.getBoard().repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (this.getBoard().getMyShapes().size() > this.getActualLength()) {
            this.getBoard().getMyShapes().remove(0);
        }
        if (this.getActiveShape() instanceof Kruh) {
            this.getBoard().getMyShapes().add(new Kruh(x,y,actualRadius));
        }
        if (this.getActiveShape() instanceof PresipacieHodiny) {
            this.getBoard().getMyShapes().add(new PresipacieHodiny(x,y,actualRadius));
        }
        if (this.getActiveShape() instanceof Stvorec) {
            this.getBoard().getMyShapes().add(new Stvorec(x,y,actualRadius));
        }
        this.getBoard().revalidate();
        this.getBoard().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JComboBox) {
            String name = ((JComboBox<String>) source).getItemAt(((JComboBox<String>) source).getSelectedIndex());
            if (name.equals("Kruh")) {
                this.setActiveShape(new Kruh());
            }
            if (name.equals("Stvorec")) {
                this.setActiveShape(new Stvorec());
            }
            if (name.equals("Presipacie hodiny")) {
                this.setActiveShape(new PresipacieHodiny());
            }
        }
    }
}

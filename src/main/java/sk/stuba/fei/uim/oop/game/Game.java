package sk.stuba.fei.uim.oop.game;

import lombok.Getter;
import sk.stuba.fei.uim.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

@Getter
public class Game {
    public Game(){
        JFrame frame = new JFrame("ExamRT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setFocusable(true);

        Logic logic = new Logic();

        JPanel sideMenu = new JPanel();
        sideMenu.setBackground(Color.lightGray);
        sideMenu.setLayout(new BorderLayout());

        JLabel lengthLabel = new JLabel("Length");
        JLabel radiusLabel = new JLabel("Radius");
        JLabel spacingLabel = new JLabel("Spacing");

        JPanel upperMenu = new JPanel();
        upperMenu.setBackground(Color.lightGray);
        upperMenu.setLayout(new GridLayout(2,3));
        upperMenu.add(lengthLabel);
        upperMenu.add(radiusLabel);
        upperMenu.add(spacingLabel);
        upperMenu.add(logic.getLengthSlider());
        upperMenu.add(logic.getRadiusSlider());
        upperMenu.add(logic.getSpacingSlider());

        String[] cbList = {"Kruh","Stvorec","Presipacie hodiny"};
        JComboBox<String> cb = new JComboBox<>(cbList);
        cb.setBounds(50,50,90,20);
        cb.addActionListener(logic);

        frame.add(sideMenu,BorderLayout.WEST);
        frame.add(logic.getBoard());
        sideMenu.add(upperMenu);
        sideMenu.add(cb,BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

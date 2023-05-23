package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

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

        JSlider lengthSlider = new JSlider(JSlider.VERTICAL,20,200,20);
        lengthSlider.setFocusable(false);
        lengthSlider.setMinorTickSpacing(10);
        lengthSlider.setMajorTickSpacing(10);
        lengthSlider.setSnapToTicks(true);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthSlider.addChangeListener(logic);
        JSlider radiusSlider = new JSlider(JSlider.VERTICAL,1,20,1);
        radiusSlider.setFocusable(false);
        radiusSlider.setMinorTickSpacing(1);
        radiusSlider.setMajorTickSpacing(1);
        radiusSlider.setSnapToTicks(true);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        radiusSlider.addChangeListener(logic);
        JSlider spacingSlider = new JSlider(JSlider.VERTICAL,1,20,1);
        spacingSlider.setFocusable(false);
        spacingSlider.setMinorTickSpacing(1);
        spacingSlider.setMajorTickSpacing(1);
        spacingSlider.setSnapToTicks(true);
        spacingSlider.setPaintTicks(true);
        spacingSlider.setPaintLabels(true);
        spacingSlider.addChangeListener(logic);

        upperMenu.add(lengthLabel);
        upperMenu.add(radiusLabel);
        upperMenu.add(spacingLabel);
        upperMenu.add(lengthSlider);
        upperMenu.add(radiusSlider);
        upperMenu.add(spacingSlider);

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

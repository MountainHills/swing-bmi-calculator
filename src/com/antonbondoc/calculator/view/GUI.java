package com.antonbondoc.calculator.view;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JPanel mainPanel;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;

    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN);
        this.add(mainPanel);

//        this.pack();
        this.setVisible(true);
    }
}

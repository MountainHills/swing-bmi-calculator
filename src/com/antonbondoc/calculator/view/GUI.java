package com.antonbondoc.calculator.view;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    // Main components
    private JPanel mainPanel;
    private JPanel firstPanel, secondPanel, thirdPanel;

    // First Layer Components
    private JPanel titlePanel, measurementPanel, btnMeasurementPanel;
    private JLabel titleLabel;
    private JButton metricBtn, imperialBtn;

    // Third Layer Components
    private JPanel btnCalculatePanel;
    private JButton calculateBtn;

    // Constants
    private final int FRAME_WIDTH = 275;
    private final int FRAME_HEIGHT = 500;

    public GUI() {
        this.setTitle("BMI Calculator in Java Swing");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        // Set frame to center.
        this.setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());

        // First Panel Layer
        firstPanel = new JPanel(new GridLayout(2, 1));

        titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(Color.MAGENTA);
        titleLabel = new JLabel("BMI Calculator");
        titleLabel.setFont(new Font("Fira Sans Bold", Font.BOLD, 36));
        titlePanel.add(titleLabel);

        measurementPanel = new JPanel(new GridBagLayout());
        measurementPanel.setBackground(Color.CYAN);
        btnMeasurementPanel = new JPanel();

        metricBtn = new JButton("Metric");
        imperialBtn = new JButton("Imperial");

        btnMeasurementPanel.add(metricBtn);
        btnMeasurementPanel.add(imperialBtn);

        measurementPanel.add(btnMeasurementPanel);

        firstPanel.add(titlePanel);
        firstPanel.add(measurementPanel);

        // Second Panel Layer - Inputs
        secondPanel = new JPanel();
        secondPanel.setBackground(Color.GREEN);

        // Third Panel Layer - Calculate
        thirdPanel = new JPanel(new GridBagLayout());
        thirdPanel.setBackground(Color.BLUE);
        thirdPanel.setPreferredSize(new Dimension(FRAME_WIDTH,50));

        btnCalculatePanel = new JPanel(new GridBagLayout());
        calculateBtn = new JButton("Calculate BMI");

        btnCalculatePanel.add(calculateBtn);

        thirdPanel.add(btnCalculatePanel);

        // Adding panels to main frame.
        mainPanel.add(firstPanel, BorderLayout.NORTH);
        mainPanel.add(secondPanel, BorderLayout.CENTER);
        mainPanel.add(thirdPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }
}

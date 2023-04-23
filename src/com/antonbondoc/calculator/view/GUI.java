package com.antonbondoc.calculator.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame {

    // Main components
    private JPanel mainPanel;
    private JPanel firstPanel, secondPanel, thirdPanel;

    // First Layer Components
    private JPanel titlePanel, measurementPanel, btnMeasurementPanel;
    private JLabel titleLabel;
    private JButton metricBtn, imperialBtn;

    // Second Layer Components
    private JPanel heightTextPanel, weightTextPanel, weightFieldPanel, heightFieldPanel;
    private JLabel weightLabel, heightLabel, heightFtLabel, heightInLabel;
    private JTextField weightTextField, heightTextField, heightFtTextField, heightInTextField;

    // Third Layer Components
    private JPanel btnCalculatePanel;
    private JButton calculateBtn;

    // Constants
    private final int FRAME_WIDTH = 275;
    private final int FRAME_HEIGHT = 300;

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
//        titlePanel.setBackground(Color.MAGENTA);
        titleLabel = new JLabel("BMI Calculator");
        titleLabel.setFont(new Font("Fira Sans Bold", Font.BOLD, 36));
        titlePanel.add(titleLabel);

        measurementPanel = new JPanel(new GridBagLayout());
//        measurementPanel.setBackground(Color.CYAN);
        btnMeasurementPanel = new JPanel();

        metricBtn = new JButton("Metric");
        metricBtn.setEnabled(false);
        metricBtn.addActionListener(e -> activateMetric());

        imperialBtn = new JButton("Imperial");
        imperialBtn.addActionListener(e -> activateImperial());

        btnMeasurementPanel.add(metricBtn);
        btnMeasurementPanel.add(imperialBtn);

        measurementPanel.add(btnMeasurementPanel);

        firstPanel.add(titlePanel);
        firstPanel.add(measurementPanel);

        // Second Panel Layer - Inputs
        secondPanel = new JPanel(new GridLayout(2,2, 10, 10));
//        secondPanel = new JPanel(new FlowLayout());
//        secondPanel.setBackground(Color.GREEN);

        // Weight Input
        weightTextPanel = new JPanel(new GridBagLayout());
        weightLabel = new JLabel("Weight: ");
        weightLabel.setFont(new Font("Fira Sans Bold", Font.BOLD, 16));
        weightTextPanel.add(weightLabel);

        weightFieldPanel = new JPanel(new GridBagLayout());
        weightTextField = new JTextField("Enter weight");
        weightTextField.setHorizontalAlignment(SwingConstants.CENTER);
        weightFieldPanel.add(weightTextField);

        // Height Input
        heightTextPanel = new JPanel(new GridBagLayout());
        heightLabel = new JLabel("Height: ");
        heightLabel.setFont(new Font("Fira Sans Bold", Font.BOLD, 16));
//        heightTextPanel.setBackground(Color.DARK_GRAY);
        heightTextPanel.add(heightLabel);

        heightFieldPanel = new JPanel(new GridBagLayout());
//        heightFieldPanel.setBackground(Color.DARK_GRAY);
        heightTextField = new JTextField("Enter height");
        heightTextField.setHorizontalAlignment(SwingConstants.CENTER);
//        heightFieldPanel.setBackground(Color.ORANGE);
        heightFieldPanel.add(heightTextField);

        secondPanel.add(weightTextPanel);
        secondPanel.add(weightTextField);
        secondPanel.add(heightTextPanel);
        secondPanel.add(heightTextField);

        // Third Panel Layer - Calculate
        thirdPanel = new JPanel(new GridBagLayout());
//        thirdPanel.setBackground(Color.BLUE);
        thirdPanel.setPreferredSize(new Dimension(FRAME_WIDTH,50));

        btnCalculatePanel = new JPanel(new GridBagLayout());
        calculateBtn = new JButton("Calculate BMI");
        calculateBtn.addActionListener(e -> calculateBMI());

        btnCalculatePanel.add(calculateBtn);

        thirdPanel.add(btnCalculatePanel);

        // Adding panels to main frame.
        mainPanel.add(firstPanel, BorderLayout.NORTH);
        mainPanel.add(secondPanel, BorderLayout.CENTER);
        mainPanel.add(thirdPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private void calculateBMI() {
        System.out.println("Calculating the BMI.");
    }

    private void activateImperial() {
        imperialBtn.setEnabled(false);
        metricBtn.setEnabled(true);
        System.out.println("I clicked the Imperial Button");
    }

    private void activateMetric() {
        metricBtn.setEnabled(false);
        imperialBtn.setEnabled(true);
        System.out.println("I clicked the Metric Button");
    }
}

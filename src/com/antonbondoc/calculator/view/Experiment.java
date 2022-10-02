package com.antonbondoc.calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Component.CENTER_ALIGNMENT;

public class Experiment implements ActionListener {
    private final JPanel panel;
    private final JButton button;

    private final JLabel label;
    private int count = 0;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;

    public Experiment() {
        JFrame frame = new JFrame();
        frame.setTitle("Our GUI");

        panel = new JPanel();
        panel.setBackground(Color.GREEN);

        button = new JButton("Click me!");
        button.addActionListener(this);

        label = new JLabel("Number of clicks: 0");
        label.setAlignmentX(CENTER_ALIGNMENT);

        panel.setBorder(
                BorderFactory.createEmptyBorder(100, 100, 100, 100)
        );
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("# of clicks: " + count);
    }
}

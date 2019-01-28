package com.istic.ila.aoc.ui;

import javax.swing.*;
import java.awt.*;

public class Afficheur extends JPanel {

    private String value;

    private JLabel jLabel;

    private Color color;

    public Afficheur(Color color, String value) {
        super();
        this.value = value;
        this.color = color;
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        jLabel = new JLabel(value, SwingConstants.CENTER);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        this.add(jLabel, BorderLayout.CENTER);
    }

    public void update(String message) {
        this.value = message;
        updateUI();
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(color);
        jLabel.repaint();
        jLabel.setText(value);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 25));
    }

}


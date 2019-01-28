package com.istic.ila.aoc.ui;

import javax.swing.*;
import java.awt.*;

public class Afficheur extends JPanel {

    private String value;

    private JLabel jLabel;

    public Afficheur(Color color, String value) {
        super();
        this.value = value;
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        jLabel = new JLabel(value, SwingConstants.CENTER);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        this.add(jLabel, BorderLayout.CENTER);
    }

    public void update(String message) {
        this.value = message;
        this.jLabel.setText(value);
        this.jLabel.repaint();

    }

}


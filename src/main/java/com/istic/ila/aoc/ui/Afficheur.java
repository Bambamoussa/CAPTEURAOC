package com.istic.ila.aoc.ui;

import com.istic.ila.aoc.proxy.Canal;
import com.istic.ila.aoc.servant.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Future;

public class Afficheur extends JPanel implements Observer {

    private int value;

    private JLabel jLabel;

    public Afficheur(Color color) {
        super();
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        jLabel = new JLabel(String.valueOf(value), SwingConstants.CENTER);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        this.add(jLabel, BorderLayout.CENTER);

    }

    @Override
    public Future update(Object g) {
        if (g instanceof Canal) {
            this.value = ((Canal) g).getValue();
            repaint();
        }
        return null;
    }
}

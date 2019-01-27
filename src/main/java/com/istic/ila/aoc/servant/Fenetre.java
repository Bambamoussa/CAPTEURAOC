package com.istic.ila.aoc.servant;

import com.istic.ila.aoc.client.Generateur;
import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.proxy.Canal;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private String SEQUENTIELLE = "SEQUENTIELLE";
    private String ATOMIQUE = "ATOMIQUE";
    private String CAUSALE = "CAUSALE";

    private String strategieChoisie = SEQUENTIELLE;
    private JLabel jLabelStrategieChoisie;

    public static void main(String[] args) {
        new Fenetre();
    }

    private Fenetre() {

        this.setTitle("Projet AOC");
        this.setMinimumSize(new Dimension(300, 300));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));
        menuBar(this);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        IGenerateur generateur = new Generateur();


        JPanel afficheurContainer = new JPanel();
        afficheurContainer.setLayout(new GridLayout(2, 2));
        {
            Afficheur afficheur = new Afficheur(Color.CYAN);
            afficheurContainer.add(afficheur);
            final Canal canal = new Canal();
            canal.attach(afficheur);

            generateur.attach(canal);
        }
        {
            Afficheur afficheur = new Afficheur(Color.GREEN);
            afficheurContainer.add(afficheur);
            final Canal canal = new Canal();
            canal.attach(afficheur);

            generateur.attach(canal);
        }
        {
            Afficheur afficheur = new Afficheur(Color.ORANGE);
            afficheurContainer.add(afficheur);
            final Canal canal = new Canal();
            canal.attach(afficheur);

            generateur.attach(canal);
        }
        {
            Afficheur afficheur = new Afficheur(Color.GRAY);
            afficheurContainer.add(afficheur);
            final Canal canal = new Canal();
            canal.attach(afficheur);

            generateur.attach(canal);
        }

        container.add(afficheurContainer, BorderLayout.CENTER);
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void menuBar(JFrame jFrame) {
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Strategy");
        JMenuItem sequentielle = new JMenuItem("Séquentielle");
        sequentielle.addActionListener(event -> {
            strategieChoisie = SEQUENTIELLE;
            jLabelStrategieChoisie.setText(strategieChoisie);
            System.out.println("Stratégie SEQUENTIELLE activée.");
        });
        JMenuItem atomique = new JMenuItem("Atomique");
        atomique.addActionListener(event -> {
            strategieChoisie = ATOMIQUE;
            jLabelStrategieChoisie.setText(strategieChoisie);
            System.out.println("Stratégie ATOMIQUE activée.");
        });
        JMenuItem causale = new JMenuItem("Causale");
        causale.addActionListener(event -> {
            strategieChoisie = CAUSALE;
            jLabelStrategieChoisie.setText(strategieChoisie);
            System.out.println("Stratégie CAUSALE activée.");
        });
        menu.add(sequentielle);
        menu.add(causale);
        menu.add(atomique);
        menubar.add(menu);

        jLabelStrategieChoisie = new JLabel(strategieChoisie);
        menubar.add(jLabelStrategieChoisie);

        JMenu aPropos = new JMenu("Développé par");
        JMenuItem adrien = new JMenuItem("Adrien LEBLANC");
        JMenuItem erwan = new JMenuItem("Erwan IQUEL");
        aPropos.add(aPropos);
        aPropos.add(adrien);
        aPropos.add(erwan);
        menubar.add(aPropos);
        jFrame.setJMenuBar(menubar);
    }

}

package com.istic.ila.aoc.ui;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.activeobject.entity.Display;
import com.istic.ila.aoc.activeobject.entity.IntegerGenerator;
import com.istic.ila.aoc.activeobject.proxy.Canal;
import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Fenetre extends JFrame implements Observer<Display> {

    private String SEQUENTIELLE = "SEQUENTIELLE";
    private String ATOMIQUE = "ATOMIQUE";
    private String CAUSALE = "CAUSALE";

    private String strategieChoisie = SEQUENTIELLE;
    private JLabel jLabelStrategieChoisie;

    private Generator<Integer> generator;

    private Display display1;
    private Display display2;
    private Display display3;
    private Display display4;

    private Canal canal1;
    private Canal canal2;
    private Canal canal3;
    private Canal canal4;

    private static final String AFFICHEUR_1 = "Afficheur 1";
    private static final String AFFICHEUR_2 = "Afficheur 2";
    private static final String AFFICHEUR_3 = "Afficheur 3";
    private static final String AFFICHEUR_4 = "Afficheur 4";

    private Afficheur afficheur1;
    private Afficheur afficheur2;
    private Afficheur afficheur3;
    private Afficheur afficheur4;

    public static void main(String[] args) {
        new Fenetre();
    }

    /**
     * Constructor
     */
    private Fenetre() {

        this.setTitle("Projet AOC");
        this.setMinimumSize(new Dimension(300, 300));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));
        menuBar(this);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        this.initialize();


        JPanel afficheurContainer = new JPanel();
        afficheurContainer.setLayout(new GridLayout(2, 2));
        {
            afficheurContainer.add(this.afficheur1);
        }
        {
            afficheurContainer.add(this.afficheur2);
        }
        {
            afficheurContainer.add(this.afficheur3);
        }
        {
            afficheurContainer.add(this.afficheur4);
        }

        container.add(afficheurContainer, BorderLayout.CENTER);
        this.setContentPane(container);
        this.setVisible(true);
        this.generator.tick();
    }

    /**
     * Initialze some useful data and graphical components to print generated values
     */
    private void initialize() {
        this.generator = new IntegerGenerator(DiffusionType.SEQUENTIAL_DIFFUSION);

        this.display1 = new Display(AFFICHEUR_1);
        this.display2 = new Display(AFFICHEUR_2);
        this.display3 = new Display(AFFICHEUR_3);
        this.display4 = new Display(AFFICHEUR_4);

        ScheduledExecutorService udpateScheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledExecutorService getValueScheduledExecutorService = Executors.newScheduledThreadPool(2);

        this.canal1 = new Canal(this.display1, udpateScheduledExecutorService, getValueScheduledExecutorService);
        this.canal2 = new Canal(this.display2, udpateScheduledExecutorService, getValueScheduledExecutorService);
        this.canal3 = new Canal(this.display3, udpateScheduledExecutorService, getValueScheduledExecutorService);
        this.canal4 = new Canal(this.display4, udpateScheduledExecutorService, getValueScheduledExecutorService);

        this.generator.attach(this.canal1);
        this.generator.attach(this.canal2);
        this.generator.attach(this.canal3);
        this.generator.attach(this.canal4);

        this.display1.attach(this);
        this.display2.attach(this);
        this.display3.attach(this);
        this.display4.attach(this);

        this.afficheur1 = new Afficheur(Color.CYAN, "0");
        this.afficheur2 = new Afficheur(Color.GREEN, "0");
        this.afficheur3 = new Afficheur(Color.ORANGE, "0");
        this.afficheur4 = new Afficheur(Color.GRAY, "0");
    }

    private void menuBar(JFrame jFrame) {
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Strategy");
        JMenuItem sequentielle = new JMenuItem("Séquentielle");
        sequentielle.addActionListener(event -> {
            strategieChoisie = SEQUENTIELLE;
            jLabelStrategieChoisie.setText(strategieChoisie);
            System.out.println("Stratégie SEQUENTIELLE activée.");
            this.generator = new IntegerGenerator(DiffusionType.SEQUENTIAL_DIFFUSION);
            this.generator.attach(this.canal1);
            this.generator.attach(this.canal2);
            this.generator.attach(this.canal3);
            this.generator.attach(this.canal4);
        });
        JMenuItem atomique = new JMenuItem("Atomique");
        atomique.addActionListener(event -> {
            strategieChoisie = ATOMIQUE;
            jLabelStrategieChoisie.setText(strategieChoisie);
            System.out.println("Stratégie ATOMIQUE activée.");
            this.generator = new IntegerGenerator(DiffusionType.ATOMIC_DIFFUSION);
            this.generator.attach(this.canal1);
            this.generator.attach(this.canal2);
            this.generator.attach(this.canal3);
            this.generator.attach(this.canal4);
        });
        JMenuItem causale = new JMenuItem("Causale");
        causale.addActionListener(event -> {
            strategieChoisie = CAUSALE;
            jLabelStrategieChoisie.setText(strategieChoisie);
            System.out.println("Stratégie CAUSALE activée.");
            this.generator = new IntegerGenerator(DiffusionType.CAUSAL_DIFFUSION);
            this.generator.attach(this.canal1);
            this.generator.attach(this.canal2);
            this.generator.attach(this.canal3);
            this.generator.attach(this.canal4);
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

    @Override
    public void update(Display observable) {
        switch (observable.getName()) {
            case AFFICHEUR_1:
                this.afficheur1.update(observable.getValue());
                break;

            case AFFICHEUR_2:
                this.afficheur2.update(observable.getValue());
                break;

            case AFFICHEUR_3:
                this.afficheur3.update(observable.getValue());
                break;

            case AFFICHEUR_4:
                this.afficheur4.update(observable.getValue());
                break;

            default:

        }
    }
}

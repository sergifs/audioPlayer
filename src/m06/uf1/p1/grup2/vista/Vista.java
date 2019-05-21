package m06.uf1.p1.grup2.vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import m06.uf1.p1.grup2.controlador.Controlador;
import m06.uf1.p1.grup2.modelo.Cancion;

public class Vista {

    private JFrame finestra;
    private JPanel panell;

    private JButton play, stop, pausa, continuar;
    private final JButton anterior, siguiente;

    public Vista(Controlador controller) {
        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(400, 50);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setLocationRelativeTo(null);
        panell = new JPanel();
        panell.setLayout(new GridLayout(1, 0));

        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continue");
        anterior = new JButton("Anterior");
        siguiente = new JButton("Siguiente");

        panell.add(anterior);
        panell.add(play);
        panell.add(pausa);
        panell.add(continuar);
        panell.add(stop);
        panell.add(siguiente);

        JPanel panel2 = new JPanel();

        JComboBox<Cancion> comboBox = new JComboBox();

        panel2.add(comboBox);

        finestra.add(panel2);
        finestra.add(panell);

        //add listener
        pausa.addActionListener(controller);
        pausa.setActionCommand("pausa");

        play.addActionListener(controller);
        play.setActionCommand("play");

        stop.addActionListener(controller);
        stop.setActionCommand("stop");

        continuar.addActionListener(controller);
        continuar.setActionCommand("continuar");

        continuar.addActionListener(controller);
        continuar.setActionCommand("<<<<");

        continuar.addActionListener(controller);
        continuar.setActionCommand(">>>>");

        finestra.pack();
        finestra.setVisible(true);
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JPanel getPanell() {
        return panell;
    }

    public void setPanell(JPanel panell) {
        this.panell = panell;
    }

    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JButton getStop() {
        return stop;
    }

    public void setStop(JButton stop) {
        this.stop = stop;
    }

    public JButton getPausa() {
        return pausa;
    }

    public void setPausa(JButton pausa) {
        this.pausa = pausa;
    }

    public JButton getContinuar() {
        return continuar;
    }

    public void setContinuar(JButton continuar) {
        this.continuar = continuar;
    }
}

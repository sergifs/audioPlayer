package m06.uf1.audioplayer.controlador;

import m06.uf1.audioplayer.vista.Vista;
import m06.uf1.audioplayer.modelo.Audio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.audioplayer.vista.View;

public class Controlador implements ActionListener, ItemListener {

    private Audio audio;

    public Controlador() throws BasicPlayerException {
        new View(this).setVisible(true);
        audio = Audio.GetPlayer();
        audio.openSong(ReproductorAudio.buscarCancion(0));
    }

    //Dotem de funcionalitat als botons
    @Override
    public void actionPerformed(ActionEvent esdeveniment) {
        //Declarem el gestor d'esdeveniments
        String action = esdeveniment.getActionCommand();

        try {
            switch (action) {
                case "Play":
                    audio.play();
                    break;
                case "Stop":
                    audio.stop();
                    break;
                case "Pause":
                    JButton btn = (JButton) esdeveniment.getSource();
                    audio.pause();
                    break;
                case "Resume":
                    audio.resume();
                    break;
            }
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

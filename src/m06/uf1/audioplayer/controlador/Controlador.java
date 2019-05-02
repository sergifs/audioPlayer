package m06.uf1.audioplayer.controlador;

import m06.uf1.audioplayer.vista.Vista;
import m06.uf1.audioplayer.modelo.Audio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Controlador implements ActionListener {

    private Audio audio;

    public Controlador() throws BasicPlayerException {
        Vista vista = new Vista(this);
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
                case "play":
                    audio.play();
                    break;
                case "stop":
                    audio.stop();
                    break;
                case "pausa":
                    audio.pause();
                case "continuar":
                    audio.resume();
                    break;
            }
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }
}

package m06.uf1.audioplayer.controlador;

import m06.uf1.audioplayer.vista.Vista;
import m06.uf1.audioplayer.modelo.Audio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.audioplayer.modelo.ListaBibliotecaDOM;

public class Controlador implements ActionListener {

    private Vista vista;
    private Audio audio;
    private ListaBibliotecaDOM biblioteca;

    public Controlador(ListaBibliotecaDOM biblioteca) throws BasicPlayerException {
        this.biblioteca = biblioteca;
        audio = Audio.GetPlayer();
        audio.openSong(biblioteca.buscarCancion(0));
        vista = new Vista(this);
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

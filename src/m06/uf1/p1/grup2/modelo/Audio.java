package m06.uf1.p1.grup2.modelo;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.p1.grup2.controlador.Controlador;

// http://www.javazoom.net/jlgui/api.html
public class Audio extends BasicPlayer {

    public static Audio GetPlayer() {
        if (player == null) {
            player = new Audio();
        }
        return player;
    }

    private static Audio player;

    private Audio() {
        super();
        if (player != null) {
            throw new IllegalAccessError("No se puede hacer esto");
        }
    }

    private static Cancion currentSong;

    public static Cancion getCurrentCancion() {
        return currentSong;
    }

    public boolean openSong(Cancion c, int delay) {
        boolean resultado = false;
        currentSong = c;

        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            super.open(new File(c.getRutaCancion()));
            resultado = true;
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public void play() throws BasicPlayerException {
        super.play(); //To change body of generated methods, choose Tools | Templates.
    }

}

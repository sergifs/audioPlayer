package m06.uf1.audioplayer.modelo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

// http://www.javazoom.net/jlgui/api.html
public class Audio extends BasicPlayer {

    public static Audio GetPlayer() {
        if (player == null) {
            synchronized (Audio.class) {
                if (player == null) {
                    player = new Audio();
                }
            }
        }
        return player;
    }

    private static Audio player;

    private Audio() {
        super();
    }

    public boolean openSong(Cancion c) {
        boolean resultado = false;
        try {
            open(new File(c.getRutaCancion()));
            resultado = true;
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}

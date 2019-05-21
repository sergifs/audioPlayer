package m06.uf1.p1.grup2.controlador;

/**
 *
 * @author Juan
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import m06.uf1.p1.grup2.modelo.ListaBibliotecaDOM;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.p1.grup2.modelo.Cancion;
import m06.uf1.p1.grup2.modelo.Playlist;

public class ReproductorAudio {

    private static final String nombreArchivo = "biblioteca.xml";

    private static Map<Integer, Cancion> canciones = new HashMap();
    private static Map<Integer, Playlist> playlists = new HashMap();

    public static void main(String[] args) throws FileNotFoundException {

        /*Playlist playList = new Playlist("hola","buenas"); //Prueba playList
        playList.crearJSON();
        System.out.println(playList.toString());*/
        try {
            canciones = ListaBibliotecaDOM.cargarCanciones(nombreArchivo);
            playlists = ListaBibliotecaDOM.cargarPlaylists(nombreArchivo);
            ListaBibliotecaDOM.cargarPlaylistsJSON();
        } catch (IOException ex) {
            System.out.println("Error d'entrada/sortida");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error processant arxiu " + nombreArchivo);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Controlador controlador = new Controlador();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public static int numeroCanciones() {
        return canciones.size();
    }

    public static Cancion buscarCancion(int id) {
        return canciones.get(id);
    }

    public static Playlist buscarPlaylist(int id) {
        return playlists.get(id);
    }

    public static Map<Integer, Cancion> getCanciones() {
        return canciones;
    }

    public static Map<Integer, Playlist> getPlaylists() {
        return playlists;
    }

}

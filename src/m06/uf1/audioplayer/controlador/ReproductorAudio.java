/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer.controlador;
/**
 *
 * @author Juan
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import m06.uf1.audioplayer.modelo.ListaBibliotecaDOM;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.audioplayer.modelo.Cancion;
import m06.uf1.audioplayer.modelo.Playlist;

public class ReproductorAudio {

    private static String nombreArchivo = "biblioteca.xml";
    
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
        java.awt.EventQueue.invokeLater(() ->{
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

    public static String listarCanciones() {
        String retorn = "LISTA DE CANCIONES: \nHay un total de " + canciones.size() + " canciones.\n";
        for (Map.Entry<Integer, Cancion> cancion: canciones.entrySet()){
            retorn += cancion.toString() + "\n";
        }
        return retorn;
    }

}

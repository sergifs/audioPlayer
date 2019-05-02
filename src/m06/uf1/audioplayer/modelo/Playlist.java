package m06.uf1.audioplayer.modelo;

import java.util.ArrayList;

/**
 *
 * @author sergi.f.sellares
 */
public class Playlist {
    
    String nombre;
    String rutaJSON;

    public Playlist(String nombre, String rutaJSON) {
        rutaCanciones = new ArrayList<>();
        this.nombre = nombre;
        this.rutaJSON = rutaJSON;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getRutaJSON() {
        return rutaJSON;
    }
    
    String descripcion;
    String albumArt;
    ArrayList<String> rutaCanciones;
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }
    
    public void setRutaCanciones(ArrayList<String> rutaCanciones) {
        this.rutaCanciones = rutaCanciones;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getAlbumArt() {
        return albumArt;
    }
    
    public ArrayList<String> getRutaCanciones() {
        return rutaCanciones;
    }
}

package m06.uf1.audioplayer;

/**
 *
 * @author sergi.f.sellares
 */
public class Playlist {
    
    String nombre;
    String rutaJSON;

    public Playlist(String nombre, String rutaJSON) {
        this.nombre = nombre;
        this.rutaJSON = rutaJSON;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getRutaJSON() {
        return rutaJSON;
    }
}

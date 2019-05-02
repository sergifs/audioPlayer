package m06.uf1.audioplayer;

/**
 *
 * @author sergi.f.sellares
 */
public class Cancion {
    
    private final String nombre;
    private final String autor;
    private final String album;
    private final String duracion;
    private final String rutaCancion;

    public Cancion(String nombre, String autor, String album, String duracion, String rutaCancion) {
        this.nombre = nombre;
        this.autor = autor;
        this.album = album;
        this.duracion = duracion;
        this.rutaCancion = rutaCancion;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getAutor() {
        return autor;
    }
    public String getAlbum() {
        return album;
    }
    public String getDuracion() {
        return duracion;
    }
    public String getRutaCancion() {
        return rutaCancion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\n Autor: " + autor +
               "\n Album: " + album +
               "\n Duracion: " + duracion +
               "\n Ruta: " + rutaCancion +
               "\n ---------------------------------------------------";
    }
}

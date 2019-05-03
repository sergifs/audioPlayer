package m06.uf1.audioplayer.modelo;

import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        String listaCanciones = "";
        listaCanciones = rutaCanciones.stream().map((rutaCancion) -> rutaCancion + "\n").reduce(listaCanciones, String::concat);
        return "Nombre: " + nombre
                + "\n Descripcion: " + descripcion
                + "\n AlbumArt: " + albumArt
                + "\n Ruta canciones: " + listaCanciones
                + "\n ---------------------------------------------------";
    }

    public void crearJSON() {
        JSONObject playList_01 = new JSONObject();
        playList_01.put("nombre", "Rap Playlist");
        playList_01.put("descripcion", "Playlist de rap");
        playList_01.put("rutaImagen", "albumArt/Post Malone - Rockstar ft. 21 Savage.jpg");
        JSONArray rutaArchivos_01 = new JSONArray();
        rutaArchivos_01.add("audios/Post Malone - Rockstar ft. 21 Savage.mp3");
        rutaArchivos_01.add("audios/Childish Gambino - This Is America.mp3");
        rutaArchivos_01.add("audios/twenty one pilots Stressed Out.mp3");
        playList_01.put("rutasArchivos", rutaArchivos_01);

        JSONObject playList_02 = new JSONObject();
        playList_02.put("nombre", "Happy Playlist");
        playList_02.put("descripcion", "Playlist para cuando estás de buen humor");
        playList_02.put("rutaImagen", "albumArt/Sia - The Greatest.jpg");
        JSONArray rutaArchivos_02 = new JSONArray();
        rutaArchivos_02.add("audios/Neovaii - Heart Shaped Box.mp3");
        rutaArchivos_02.add("audios/Sia - The Greatest.mp3");
        rutaArchivos_02.add("audios/David Guetta - Titanium ft. Sia.mp3");
        playList_02.put("rutasArchivos", rutaArchivos_02);

        JSONObject playList_03 = new JSONObject();
        playList_03.put("nombre", "Chill Playlist");
        playList_03.put("descripcion", "Playlist para estar del chill");
        playList_03.put("rutaImagen", "albumArt/The Weeknd - Starboy ft. Daft Punk.jpg");
        JSONArray rutaArchivos_03 = new JSONArray();
        rutaArchivos_03.add("audios/The Weeknd - Starboy ft. Daft Punk.mp3");
        rutaArchivos_03.add("audios/Stephen - Crossfire.mp3");
        rutaArchivos_03.add("audios/Neovaii - Heart Shaped Box.mp3");
        playList_03.put("rutasArchivos", rutaArchivos_03);

        try {
            FileWriter fichero_01 = new FileWriter("rap.json");
            fichero_01.write(playList_02.toString());
            fichero_01.close();

            FileWriter fichero_02 = new FileWriter("happy.json");
            fichero_02.write(playList_02.toString());
            fichero_02.close();

            FileWriter fichero_03 = new FileWriter("chill.json");
            fichero_03.write(playList_03.toString());
            fichero_03.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

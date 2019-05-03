package m06.uf1.audioplayer.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    
    public void setNombre(String nombre){
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
        return "Nombre: " + nombre +
               "\n Descripcion: " + descripcion +
               "\n AlbumArt: " + albumArt +
               "\n Ruta canciones: " + listaCanciones +
               "\n ---------------------------------------------------";
    }
    
    public void leerJSON(){
        
        JSONParser parser = new JSONParser();

            try {
                JSONObject playList = (JSONObject)parser.parse(new FileReader("playList.json"));
                //Nombre
                setNombre(playList.get("nombre").toString());
                //Descripción
                setNombre(playList.get("descripcion").toString());
                //Ruta Imagen Álbum
                setAlbumArt(playList.get("rutaImagen").toString());
                //Array ruta Canciones
                JSONArray urlList = (JSONArray)playList.get("rutasArchivos");
                ArrayList rutaArchivos = new ArrayList();
                for(Object l: urlList){
                    rutaArchivos.add(l.toString());
                }
                setRutaCanciones(rutaArchivos);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Playlist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Playlist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void crearJSON(){
        
        JSONObject playList_01 = new JSONObject();
        playList_01.put("nombre" , "Rap Play List");
        playList_01.put("descripcion" , "Play List de rap");
        playList_01.put("rutaImagen" , "rutaiImagen");
        JSONArray rutaArchivos_01 = new JSONArray();
        rutaArchivos_01.add("audios/Post Malone - Rockstar ft. 21 Savage.mp3");
        rutaArchivos_01.add("audios/Childish Gambino - This Is America.mp3");
        rutaArchivos_01.add("audios/twenty one pilots Stressed Out.mp3");
        playList_01.put("rutasArchivos", rutaArchivos_01);
        
        JSONObject playList_02 = new JSONObject();
        playList_01.put("nombre" , "Rap Play List");
        playList_01.put("descripcion" , "Play List de rap");
        playList_01.put("rutaImagen" , "rutaiImagen");
        JSONArray rutaArchivos_02 = new JSONArray();
        rutaArchivos_02.add("audios/Post Malone - Rockstar ft. 21 Savage.mp3");
        rutaArchivos_02.add("audios/Childish Gambino - This Is America.mp3");
        rutaArchivos_02.add("audios/twenty one pilots Stressed Out.mp3");
        playList_01.put("rutasArchivos", rutaArchivos_02);
  
        try {
            FileWriter fichero_01 = new FileWriter("playList_01.json");
            fichero_01.write(playList_01.toString());
            fichero_01.close();
            
            FileWriter fichero_02 = new FileWriter("playList_02.json");
            fichero_02.write(playList_02.toString());
            fichero_02.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

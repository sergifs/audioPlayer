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
    
    /*public void leerJSON(){
        
        JSONParser parser = new JSONParser();

            try {
                JSONObject playList = (JSONObject)parser.parse(new FileReader("playList.json"));
                //Nombre
                setNombre(playList.get("nombre").toString());
                //Descripción
                setDescripcion(playList.get("descripcion").toString());
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
    }*/
    
    /*public void crearJSON(){
        
        JSONObject playList = new JSONObject();
        playList.put("nombre" , "playList_1");
        playList.put("descripcion" , "descripcion playList_1");
        playList.put("rutaImagen" , "rutaiImagen");
        JSONArray rutaArchivos = new JSONArray();
        rutaArchivos.add("rutaArchivo1");
        rutaArchivos.add("rutaArchivo2");
        rutaArchivos.add("rutaArchivo3");
        playList.put("rutasArchivos", rutaArchivos);
        
        try {
            FileWriter fichero = new FileWriter("playList.json");
            fichero.write(playList.toString());
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

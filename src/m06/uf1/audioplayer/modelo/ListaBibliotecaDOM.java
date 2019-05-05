package m06.uf1.audioplayer.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import m06.uf1.audioplayer.controlador.ReproductorAudio;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sergi.f.sellares
 */
public class ListaBibliotecaDOM {

    public static Map<Integer, Cancion> cargarCanciones(String nombreArchivo) throws FileNotFoundException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();

        Map<Integer, Cancion> canciones = new HashMap();

        try {

            document = builder.parse(new File(nombreArchivo));
            NodeList listaCanciones = document.getElementsByTagName("cancion");
            System.out.println("Numero de canciones en la biblioteca: " + listaCanciones.getLength());
            for (int i = 0; i < listaCanciones.getLength(); i++) {
                Node node = listaCanciones.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element cancion = (Element) node;
                    int id = Integer.parseInt(cancion.getAttribute("id"));
                    Element nombre = (Element) cancion.getElementsByTagName("nombre").item(0);
                    Element autor = (Element) cancion.getElementsByTagName("autor").item(0);
                    Element album = (Element) cancion.getElementsByTagName("album").item(0);
                    Element duracion = (Element) cancion.getElementsByTagName("duracion").item(0);
                    Element rutaCancion = (Element) cancion.getElementsByTagName("rutaCancion").item(0);

                    Cancion cancion1 = new Cancion(
                            nombre.getChildNodes().item(0).getNodeValue(),
                            autor.getChildNodes().item(0).getNodeValue(),
                            album.getChildNodes().item(0).getNodeValue(),
                            duracion.getChildNodes().item(0).getNodeValue(),
                            rutaCancion.getChildNodes().item(0).getNodeValue());
                    canciones.put(id, cancion1);
                    System.out.println(cancion1.toString());
                }
            }

        } catch (SAXException ex) {
            ex.printStackTrace();
        }
        return canciones;
    }

    public static Map<Integer, Playlist> cargarPlaylists(String nombreArchivo) throws FileNotFoundException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();

        Map<Integer, Playlist> playlists = new HashMap();

        try {

            document = builder.parse(new File(nombreArchivo));
            NodeList listaPlaylists = document.getElementsByTagName("playlist");
            System.out.println("Numero de playlists en la biblioteca: " + listaPlaylists.getLength());
            for (int i = 0; i < listaPlaylists.getLength(); i++) {
                Node node = listaPlaylists.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element playlist = (Element) node;
                    int id = Integer.parseInt(playlist.getAttribute("id"));
                    Element nombre = (Element) playlist.getElementsByTagName("nombre").item(0);
                    Element rutaJSON = (Element) playlist.getElementsByTagName("rutaJSON").item(0);

                    Playlist playlist1 = new Playlist(
                            nombre.getChildNodes().item(0).getNodeValue(),
                            rutaJSON.getChildNodes().item(0).getNodeValue());
                    playlists.put(id, playlist1);
                    System.out.println(playlist1.toString());
                }
            }

        } catch (SAXException ex) {
            ex.printStackTrace();
        }
        return playlists;
    }

    public static void cargarPlaylistsJSON() {

        JSONParser parser = new JSONParser();

        ReproductorAudio.getPlaylists().entrySet().forEach((entry) -> {
            try {
                //ID
                //Playlist playlist = ReproductorAudio.buscarPlaylist(Integer.parseInt(playlistJSON.get("id").toString()));
                Playlist playlist = entry.getValue();
                System.out.println("Playlist a leer: " + playlist.getRutaJSON());
                JSONObject playlistJSON = null;
                try {
                    playlistJSON = (JSONObject) parser.parse(new FileReader(playlist.getRutaJSON()));
                } catch (ParseException ex) {
                    Logger.getLogger(ListaBibliotecaDOM.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Descripción
                playlist.setDescripcion(playlistJSON.get("descripcion").toString());
                //Ruta Imagen Álbum
                playlist.setAlbumArt(playlistJSON.get("rutaImagen").toString());
                //Array ruta Canciones
                JSONArray urlList = (JSONArray) playlistJSON.get("rutasArchivos");
                ArrayList rutaArchivos = new ArrayList();
                urlList.forEach((l) -> {
                    rutaArchivos.add(l.toString());
                });
                playlist.setRutaCanciones(rutaArchivos);
                System.out.println(playlist.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Playlist.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import m06.uf1.audioplayer.modelo.Cancion;
import m06.uf1.audioplayer.modelo.Playlist;
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
    
    private Map<Integer, Cancion> canciones;
    private Map<Integer, Playlist> playlists;
    private String archivoCanciones;

    public ListaBibliotecaDOM(String nombreArchivo) throws IOException, ParserConfigurationException {
        canciones = new HashMap();
        playlists = new HashMap();
        this.archivoCanciones = nombreArchivo;
        cargarBiblioteca();
    }

    public void cargarBiblioteca() throws FileNotFoundException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {

            document = builder.parse(new File(archivoCanciones));
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
            
            System.out.println();
            
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
    }

    public int numeroCanciones() {
        return canciones.size();
    }

    public Cancion buscarCancion(int id) {
        return canciones.get(id);
    }

    public String listarCanciones() {
        String retorn = "LISTA DE CANCIONES: \nHay un total de " + canciones.size() + " canciones.\n";
        for (Entry<Integer, Cancion> cancion: canciones.entrySet()){
            retorn += cancion.toString() + "\n";
        }
        return retorn;
    }
}

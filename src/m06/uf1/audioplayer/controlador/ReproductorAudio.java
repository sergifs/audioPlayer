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
import javax.xml.parsers.ParserConfigurationException;
import m06.uf1.audioplayer.modelo.ListaBibliotecaDOM;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class ReproductorAudio {

    private static String nombreArchivo = "biblioteca.xml";
    private static ListaBibliotecaDOM biblioteca;

    public static void main(String[] args) throws FileNotFoundException {
        try {
            biblioteca = new ListaBibliotecaDOM(nombreArchivo);
            java.awt.EventQueue.invokeLater(() ->{
            try {
                Controlador controlador = new Controlador(biblioteca);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        } catch (IOException ex) {
            System.out.println("Error d'entrada/sortida");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error processant arxiu " + nombreArchivo);
        }
        
    }

}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class ReproductorAudio {
    public static void main(String[] args) throws FileNotFoundException {
        java.awt.EventQueue.invokeLater(() ->{
            try {
                Controlador controlador = new Controlador();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}

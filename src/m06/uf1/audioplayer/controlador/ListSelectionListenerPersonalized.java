/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.audioplayer.modelo.Audio;
import m06.uf1.audioplayer.modelo.TableModelPersonalized;
import m06.uf1.audioplayer.vista.View;

/**
 *
 * @author Antonio
 */
public class ListSelectionListenerPersonalized implements ListSelectionListener {

    private TableModelPersonalized tm;

    public ListSelectionListenerPersonalized(TableModelPersonalized tm) {
        this.tm = tm;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (lse.getSource() instanceof JTable) {
            JTable table = (JTable) lse.getSource();
            if (!lse.getValueIsAdjusting()) {
                Audio.GetPlayer().openSong(tm.getCancion(table.getSelectedRow()));
                try {
                    Audio.GetPlayer().play();
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}

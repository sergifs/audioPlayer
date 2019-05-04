/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer.controlador;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import m06.uf1.audioplayer.modelo.Audio;
import m06.uf1.audioplayer.modelo.TableModelPersonalized;

/**
 *
 * @author Antonio
 */
public class ListSelectionListenerPersonalized implements ListSelectionListener {

    private TableModelPersonalized tm;
    private JTable table;

    public ListSelectionListenerPersonalized(TableModelPersonalized tm, JTable table) {
        this.tm = tm;
        this.table = table;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (!lse.getValueIsAdjusting() && table.hasFocus()) {
            Audio.GetPlayer().openSong(tm.getCancion(table.getSelectedRow()));
        }
    }
}

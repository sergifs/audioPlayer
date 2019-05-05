package m06.uf1.audioplayer.controlador;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import m06.uf1.audioplayer.modelo.Audio;
import m06.uf1.audioplayer.modelo.Cancion;
import m06.uf1.audioplayer.modelo.TableModelPersonalized;

/**
 *
 * @author Antonio
 */
public class ListSelectionListenerPersonalized implements ListSelectionListener {

    private JTable table;

    public ListSelectionListenerPersonalized(JTable table) {
        this.table = table;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        System.out.println(System.currentTimeMillis() + " -- " + lse.getValueIsAdjusting() + " / " + lse.getSource().getClass().getSimpleName());
        if (!lse.getValueIsAdjusting()) {
            Cancion c = TableModelPersonalized.getCancion(table.getSelectedRow());
            if (c != null) {
                if (Audio.getCurrentCancion() != c) {
                    Audio.GetPlayer().openSong(c, 0);
                }
            }
        }
    }
}

package m06.uf1.p1.grup2.controlador;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import m06.uf1.p1.grup2.modelo.Audio;
import m06.uf1.p1.grup2.modelo.Cancion;
import m06.uf1.p1.grup2.modelo.TableModelPersonalized;

/**
 *
 * @author Antonio
 */
public class ListSelectionListenerPersonalized implements ListSelectionListener {

    private final JTable table;

    public ListSelectionListenerPersonalized(JTable table) {
        this.table = table;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {

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

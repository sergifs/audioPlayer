package m06.uf1.audioplayer.modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Antonio
 */
public class TableCellRendererPersonalized extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Component c = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        if (jtable.getSelectedRow() == i) {
            c.setBackground(Color.yellow);
            Audio.GetPlayer().openSong(TableModelPersonalized.getCancion(i));
        } else {
            c.setBackground(Color.white);
        }
        return c;
    }

}

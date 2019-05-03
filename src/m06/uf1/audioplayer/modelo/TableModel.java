package m06.uf1.audioplayer.modelo;

import java.util.Map;
import javax.swing.table.AbstractTableModel;
import m06.uf1.audioplayer.controlador.ReproductorAudio;

/**
 *
 * @author Antonio
 */
public class TableModel extends AbstractTableModel {

    private Map<Integer, Cancion> canciones;
    private String[] nombreColumna;

    public TableModel(String[] nombreColumna) {
        canciones = ReproductorAudio.getCanciones();
        this.nombreColumna = nombreColumna;
    }

    @Override
    public int getRowCount() {
        return canciones.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Object obj = null;
        Cancion c = canciones.get(i);
        switch (i1) {
            case 0:
                obj = c.getNombre();
                break;
            case 1:
                obj = c.getAutor();
                break;
            case 2:
                obj = c.getAlbum();
                break;
            case 3:
                obj = c.getDuracion();
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return obj;
    }

    @Override
    public String getColumnName(int i) {
        return nombreColumna[i];
    }

}

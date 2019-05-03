/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import m06.uf1.audioplayer.controlador.ReproductorAudio;

/**
 *
 * @author Antonio
 */
public class TableModelPersonalized extends AbstractTableModel {

    private ArrayList<Cancion> canciones;
    private String[] nombreColumna;

    public TableModelPersonalized(Playlist playlist, String[] nombreColumna) {
        canciones = new ArrayList<>();
        Iterator i = ReproductorAudio.getCanciones().entrySet().iterator();
        if (playlist == null) {
            while (i.hasNext()) {
                Map.Entry e = (Map.Entry) i.next();
                canciones.add((Cancion) e.getValue());
            }
        } else {
            ArrayList<String> rutas = playlist.getRutaCanciones();
            while (i.hasNext()) {
                Cancion c = (Cancion) ((Map.Entry) i.next()).getValue();
                for(String ruta : rutas){
                    System.out.println(ruta + " ---- " +  c.getRutaCancion());
                    if(ruta.equals(c.getRutaCancion())){
                        canciones.add(c);
                        break;
                    }
                }
            }
        }

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

    public Cancion getCancion(int row) {
        return canciones.get(row);
    }
}

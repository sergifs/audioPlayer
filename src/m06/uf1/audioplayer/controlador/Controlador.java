package m06.uf1.audioplayer.controlador;

import m06.uf1.audioplayer.modelo.Audio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import m06.uf1.audioplayer.modelo.Playlist;
import m06.uf1.audioplayer.modelo.TableModelPersonalized;
import m06.uf1.audioplayer.vista.View;

public class Controlador implements ActionListener, ItemListener, BasicPlayerListener, ChangeListener {

    private JSlider slider;
    private JTable table;
    private JLabel playlist_art;

    public Controlador() throws BasicPlayerException {
        Audio.GetPlayer();
        View v = new View(this);
        v.setVisible(true);
        Audio.GetPlayer().addBasicPlayerListener(this);
        Audio.GetPlayer().openSong(ReproductorAudio.buscarCancion(0));
    }

    //ActionListener
    //Dotem de funcionalitat als botons
    @Override
    public void actionPerformed(ActionEvent esdeveniment) {
        //Declarem el gestor d'esdeveniments
        String action = esdeveniment.getActionCommand();

        try {
            switch (action) {
                case "Play":
                    Audio.GetPlayer().play();
                    break;
                case "Stop":
                    Audio.GetPlayer().stop();
                    break;
                case "Pause":
                    Audio.GetPlayer().pause();
                    break;
                case "Resume":
                    Audio.GetPlayer().resume();
                    break;
                case "Before":
                    if (table.getSelectedRow() > 0) {
                        System.out.println(table.getSelectedRow());
                        table.setRowSelectionInterval(table.getSelectedRow() - 1, table.getSelectedRow() - 1);
                        System.out.println(table.getSelectedRow());
                    } else {
                        table.setRowSelectionInterval(table.getRowCount() - 1, table.getRowCount() - 1);
                    }
                    break;
                case "Next":
                    if (table.getSelectedRow() < table.getRowCount() - 1) {
                        System.out.println(table.getSelectedRow());
                        table.setRowSelectionInterval(table.getSelectedRow() + 1, table.getSelectedRow() + 1);
                        System.out.println(table.getSelectedRow());
                    } else {
                        table.setRowSelectionInterval(0, 0);
                    }
                    break;
            }
        } catch (BasicPlayerException e) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void SetSlider(JSlider slider) {
        this.slider = slider;
    }

    public void SetTable(JTable table) {
        this.table = table;
    }

    public void SetPlaylistArt(JLabel playlist_art) {
        this.playlist_art = playlist_art;
    }

    //ItemListener
    @Override
    public void itemStateChanged(ItemEvent ie) {
        JComboBox comboBox = (JComboBox) ie.getSource();
        int i = comboBox.getSelectedIndex() - 1;
        Playlist p = null;
        if (i > -1) {
            p = ReproductorAudio.getPlaylists().get(i);
            try {
                playlist_art.setIcon(new ImageIcon((new File(p.getAlbumArt())).toURI().toURL()));
            } catch (MalformedURLException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            playlist_art.setIcon(null);
        }
        TableModelPersonalized tmp = new TableModelPersonalized(p, View.NombreColumnas);
        table.setModel(tmp);
        table.setRowSelectionInterval(0, 0);
        Audio.GetPlayer().openSong(TableModelPersonalized.getCancion(0));

    }

    //BasicPlayerListener
    @Override
    public void opened(Object o, Map map) {
    }

    private boolean bol = true;

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        //System.out.println(l/1000000f);
        //System.out.println(map.entrySet());
        slider.setValue((int) ((Long) map.get("mp3.frame") / 10));
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        if (bpe.getCode() == BasicPlayerEvent.STOPPED) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow < table.getRowCount() - 1) {
                table.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
            }
        } else if (bpe.getCode() == BasicPlayerEvent.OPENED) {
            try {
                Audio.GetPlayer().play();
                System.out.println("A");
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void setController(BasicController bc) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //ChangeListener
    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider slider = (JSlider) ce.getSource();
        System.out.println(slider.getValue());
    }
}

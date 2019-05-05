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
    private JLabel min_time, max_time;
    private JLabel lbl_nombre;
    private final View view;

    public Controlador() throws BasicPlayerException {
        Audio.GetPlayer();
        view = new View(this);
        view.setVisible(true);
        Audio.GetPlayer().addBasicPlayerListener(this);
        Audio.GetPlayer().openSong(TableModelPersonalized.getCancion(0), 0);
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
                    min_time.setText("00:00");
                    break;
                case "Pause":
                    Audio.GetPlayer().pause();
                    break;
                case "Resume":
                    Audio.GetPlayer().resume();
                    break;
                case "Before":
                    if (table.getSelectedRow() > 0) {

                        table.setRowSelectionInterval(table.getSelectedRow() - 1, table.getSelectedRow() - 1);

                    } else {
                        table.setRowSelectionInterval(table.getRowCount() - 1, table.getRowCount() - 1);
                    }
                    break;
                case "Next":
                    if (table.getSelectedRow() < table.getRowCount() - 1) {

                        table.setRowSelectionInterval(table.getSelectedRow() + 1, table.getSelectedRow() + 1);

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
    
     public void SetLblNombre(JLabel lbl_nombre) {
        this.lbl_nombre = lbl_nombre;
    }

    public void SetTimers(JLabel min_time, JLabel max_time) {
        this.min_time = min_time;
        this.max_time = max_time;
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
        table.getSelectionModel().removeListSelectionListener(view.lsl);
        TableModelPersonalized tmp = new TableModelPersonalized(p, View.NombreColumnas);
        table.setModel(tmp);
        table.setRowSelectionInterval(0, 0);
        table.getSelectionModel().addListSelectionListener(view.lsl);
        Audio.GetPlayer().openSong(TableModelPersonalized.getCancion(0), 100);
    }

    //BasicPlayerListener
    @Override
    public void opened(Object o, Map map) {
        long duration = (long) map.get("duration");
        slider.setValue(0);
        slider.setMaximum((int) (duration / 100));
        min_time.setText("00:00");
        max_time.setText(secondsToString(Integer.parseInt(Integer.toString((int) duration).substring(0, 2))));
        lbl_nombre.setText(Audio.getCurrentCancion().getNombre() + " - " + Audio.getCurrentCancion().getAutor());
    }

    private String secondsToString(int pTime) {
        return String.format("%02d:%02d", pTime / 60, pTime % 60);
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        int duration = (int) ((long) map.get("mp3.position.microseconds") / 100);
        int microseconds = (int) ((long) map.get("mp3.position.microseconds") / 100);
        slider.setValue(microseconds);
        if ((Integer.toString((int) duration)).length() == 5) {
            min_time.setText(secondsToString(Integer.parseInt(Integer.toString((int) duration).substring(0, 1))));
        } else if ((Integer.toString((int) duration)).length() == 6) {
            min_time.setText(secondsToString(Integer.parseInt(Integer.toString((int) duration).substring(0, 2))));
        }
    }

    boolean control = false;

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        if (bpe.getCode() == BasicPlayerEvent.STOPPED) {
            slider.setValue(0);
            if (bpe.getPosition() == -1 && !control) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow < table.getRowCount() - 1) {
                    table.getSelectionModel().removeListSelectionListener(view.lsl);
                    table.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
                    Audio.GetPlayer().openSong(TableModelPersonalized.getCancion(selectedRow + 1), 0);
                    table.getSelectionModel().addListSelectionListener(view.lsl);
                }
            } else {
                control = bpe.getPosition() > -1;
            }
        } else if (bpe.getCode() == BasicPlayerEvent.OPENED) {
            try {
                Audio.GetPlayer().play();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //ChangeListener
    @Override
    public void stateChanged(ChangeEvent ce) {
        slider = (JSlider) ce.getSource();
    }

    @Override
    public void setController(BasicController bc) {
        
    }
}

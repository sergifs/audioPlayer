package m06.uf1.audioplayer.controlador;

import m06.uf1.audioplayer.modelo.Audio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import m06.uf1.audioplayer.vista.View;

public class Controlador implements ActionListener, ItemListener, BasicPlayerListener, ChangeListener {

    private Audio audio;
    private JSlider slider;

    public Controlador() throws BasicPlayerException {
        View v = new View(this);
        v.setVisible(true);
        audio = Audio.GetPlayer();
        audio.addBasicPlayerListener(this);
        audio.openSong(ReproductorAudio.buscarCancion(0));
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
                    audio.play();
                    break;
                case "Stop":
                    audio.stop();
                    break;
                case "Pause":
                    JButton btn = (JButton) esdeveniment.getSource();
                    audio.pause();
                    break;
                case "Resume":
                    audio.resume();
                    break;
            }
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void SetSlider(JSlider slider) {
        this.slider = slider;
    }

    //ItemListener
    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //BasicPlayerListener
    @Override
    public void opened(Object o, Map map) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

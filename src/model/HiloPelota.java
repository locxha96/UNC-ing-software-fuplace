package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static model.Jugador.getPuntaje;
import view.LaminaPelota;

public class HiloPelota extends Thread {
    //para actualizar la pelota

    private static LaminaPelota lamina;
    private static JLabel v;
    //AGREGUE EL JLABEL PERO no cambia el puntaje

    public HiloPelota(LaminaPelota lamina) {

        this.lamina = lamina;
        //this.v = v;

    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPelota.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
           // v.setText(getPuntaje());
        }

    }
}

package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.LaminaPelota;

public class HiloPelota extends Thread {
    //para actualizar la pelota

    private static LaminaPelota lamina;
 
    public HiloPelota(LaminaPelota lamina) {

        this.lamina = lamina;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPelota.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
     
        }

    }
}

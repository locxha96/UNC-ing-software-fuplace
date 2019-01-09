
package model;

import java.awt.event.*;


public class Teclado extends KeyAdapter{
    static boolean a, d;
    @Override
    //invocado cuando apreto una tecla
    public void keyPressed(KeyEvent e) {

        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_A) {
            a = true;
        }
        if (id == KeyEvent.VK_D) {
            d = true;
        }
   
    }
//invocado cuando se suelta una teclaa
    @Override
    public void keyReleased(KeyEvent e) {

        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_A) {
            a = false;
        }
        if (id == KeyEvent.VK_D) {
            d = false;
        }

    }
}

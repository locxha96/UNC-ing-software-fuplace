
package model;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

public class ObservadorGrafico implements Observer{

    @Override
    public void update(Observable observable, Object value) {
        JOptionPane.showMessageDialog(null,"Perdiste","Tus vidas son 0",JOptionPane.INFORMATION_MESSAGE);
    }
    
}

package model;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import static model.Jugador.getPuntaje;

public class ObservadorGrafico implements Observer {

    @Override
    public void update(Observable observable, Object value) {

        JOptionPane.showMessageDialog(null, "Perdiste todas las vidas", getPuntaje(), JOptionPane.INFORMATION_MESSAGE);
         System.exit(0);
    }

}

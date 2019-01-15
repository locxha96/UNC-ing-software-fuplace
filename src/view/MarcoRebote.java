package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.HiloPelota;
import javax.swing.JLabel;
import static model.Jugador.getPuntaje;
import model.Teclado;

public class MarcoRebote extends JFrame {

    int score = 0;
    private LaminaPelota lamina;
    private HiloPelota hilo;
   JLabel life = new JLabel("Vidas", JLabel.CENTER);
   JLabel ventana=new JLabel(getPuntaje(), JLabel.CENTER);

  
    
    public MarcoRebote() {
        setBounds(800, 200, 600, 800);
        setTitle("Break Bricks");
        addKeyListener(new Teclado());//creo una clase teclado 
        lamina = new LaminaPelota();
        this.add(lamina, BorderLayout.CENTER);
        lamina.add(life);
        lamina.add(ventana); //agreto el Text field
        add(lamina);
        hilo = new HiloPelota(lamina);
        hilo.start();
      

  
    }

}

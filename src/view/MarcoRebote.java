package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.HiloPelota;
import model.Teclado;

public class MarcoRebote extends JFrame {

  
    private LaminaPelota lamina;
    private HiloPelota hilo;

    public MarcoRebote() {
        setBounds(800, 200, 600, 800);
        setTitle("Break Bricks");
        addKeyListener(new Teclado());//creo una clase teclado 
        lamina = new LaminaPelota();
        this.add(lamina, BorderLayout.CENTER);
        add(lamina);
        hilo = new HiloPelota(lamina);
        hilo.start();

    }

}

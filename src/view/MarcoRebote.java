package view;

import controller.ControllerBrick;
import controller.ControllerInterface;
import controller.ControllerTetris;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.HiloPelota;
import model.Teclado;
import static view.Inicio.getT;

public class MarcoRebote extends JFrame {

    private LaminaPelota lamina;
    private HiloPelota hilo;
     ControllerInterface b;
 

    public MarcoRebote() {
        comprobar();
        b.Crear();
        setBounds(800, 200, 600, 800);
        addKeyListener(new Teclado());//creo una clase teclado 
        this.add(b.getPanel(), BorderLayout.CENTER);
        add(b.getPanel());
        hilo = new HiloPelota(b.getPanel());
        hilo.start();
    }
   
    public void comprobar(){
        if(getT()==true){
        b = new ControllerBrick();}
        else b= new ControllerTetris();
    }

}

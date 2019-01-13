package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import model.HiloPelota;
import controller.ControllerInterface;
import controller.NivelFacil;
import controller.NivelMedio;
import controller.NivelDificil;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static model.Jugador.getPuntaje;

import model.Pelota;
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
        hilo = new HiloPelota(lamina, ventana);
      

        //   Controller = new NivelFacil();
        //   Pelota pelota=new Pelota(new Color(Controller.getr(),Controller.getg(),Controller.getb()),Controller.getRadio());
  
    }

    //private ControllerInterface Controller;
//VER COMO SE SELECIONA EL NIVEL, LUGEO CAMBIAR ESTO !!!!
/*
public void comienza_el_juego ()
{
    
    //seleccion del nivel de dificultad
    int lvl =1;
//int lvl=Integer.parseInt(ventana.getText());
if(lvl==1){
   Controller = new NivelFacil();
}
if(lvl==2){
   Controller = new NivelMedio(); 
}else{Controller = new NivelDificil();}
Pelota pelota=new Pelota(new Color(Controller.getr(),Controller.getg(),Controller.getb()),Controller.getRadio());

}*/
}

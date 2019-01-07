package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.HiloPelota;
import controller.ControllerInterface;
import controller.NivelFacil;
import controller.NivelMedio;
import controller.NivelDificil;
import java.awt.Graphics;
import model.Barra;

import model.Pelota;

public class MarcoRebote extends JFrame {
int score=0;
    private LaminaPelota lamina;
    JTextField ventana = new JTextField(2);

    public MarcoRebote() {
        setBounds(900, 800, 800, 800);
        setTitle("Break Bricks");
        lamina = new LaminaPelota();
        this.add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        laminaBotones.add(ventana);
        ponerBoton(laminaBotones, "Empezar", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                lamina.eliminar();
                comienza_el_juego();
                
            }
        });
       // ponerBoton(laminaBotones, "score", new ActionListener() {
    //        public void actionPerformed(ActionEvent evento) {
      //         
      //      }
      //  });
        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        add(laminaBotones, BorderLayout.SOUTH);
    }

    public void ponerBoton(Container c, String titulo,
            ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }
//Añade pelota y la bota nuchas veces

private ControllerInterface Controller;
public void comienza_el_juego ()
{
int lvl=Integer.parseInt(ventana.getText());
if(lvl==1){
   Controller = new NivelFacil();
}
if(lvl==2){
   Controller = new NivelMedio(); 
}else{Controller = new NivelDificil();}
Pelota pelota=new Pelota(new Color(Controller.getr(),Controller.getg(),Controller.getb()),Controller.getRadio());

HiloPelota hilo=new HiloPelota(pelota,lamina);
hilo.start();
}
}

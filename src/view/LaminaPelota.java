package view;

import controller.ControllerInterface;
import controller.NivelDificil;
import controller.NivelFacil;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.geom.Rectangle2D;
import model.Barra;
import model.GeneradorBloques;
import model.Jugador;
import model.OberservadorDeConsola;
import model.ObservadorGrafico;
import model.Pelota;
import static view.Principal.nombre;

public class LaminaPelota extends JPanel {

    ControllerInterface controller;
    static Jugador jugadores;
    Pelota pelota = new Pelota();
    Barra ba;
    private ArrayList<GeneradorBloques> bloques = new ArrayList<GeneradorBloques>();// BORRO ????, usar sin una coleccion?

//    GeneradorBloques block= new GeneradorBloques(400,100);
    // private GeneradorBloques mapa;
    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
//Añadimos pelota a la lámina

    public LaminaPelota() {
        controller = new NivelDificil();
        ba = new Barra(5, 750);
        bloques.add(new GeneradorBloques(controller.getx(), controller.gety(),controller.getAnchoBloque(),controller.getAltoBloque()));
        jugadores = new Jugador(nombre);
        ObservadorGrafico o = new ObservadorGrafico();
        OberservadorDeConsola a= new OberservadorDeConsola();
        jugadores.addObserver(o);
        jugadores.addObserver(a);
    }

    public void add(Pelota b) {
        pelotas.add(b);
    }
//borrar esto

    public void eliminar() {
        if (!pelotas.isEmpty()) {
            pelotas.remove(pelotas.size() - 1);
        }
    }

    public int contar() {
        return (pelotas.size());
    }

    public void dibujar(Graphics2D g) {
        g.fill(pelota.getShape());
        g.fill(ba.getBarra());
        g.fill(bloques.get(0).getBloque());
    }

    public void actualizar() { //para mover la barra en la laminaa
        ba.MoverBarra(getBounds());
        pelota.mueve_pelota(getBounds(), colision(ba.getBarra()), colision(bloques.get(0).getBloque()));
        if (pelota.getValor() == true) {
            pelota.setValor();
            bloques.get(0).setTamaño();
            jugadores.setPuntaje();
            System.out.println(jugadores.getPuntaje());
        }
        if (pelota.getPierde() == true) {
            jugadores.setVidas();
            pelota.setRestaVidas();
            jugadores.notifyObservers();
        }

    }

    private boolean colision(Rectangle2D r) {
        return pelota.getPelota().intersects(r);
    }

//este metodo se llama automaticamente cuando se lo necesita para dibujar pelota y barra
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(245, 245, 220));
        g.fillRect(0, 0, getWidth(), getHeight());
        Graphics2D g2 = (Graphics2D) g; //lo convierto
        g2.setColor(Color.BLACK);
        dibujar(g2);
       
        actualizar();//ACA SE PODRIA USAR OBSERVER PARA la barra y buscar EL METODO Q MUEVE actu la pelota!!!

        try {
            for (int i = 0; i < pelotas.size(); i++) {
                if (pelotas.size() >= 2) {
                    for (int j = i + 1; j < pelotas.size(); j++) {
                        pelotas.get(i).pintar_bola(g);
                    }
                } else {
                    pelotas.get(i).pintar_bola(g);
                }
            }
            Thread.sleep(3);//velocidad
        } catch (InterruptedException e) {
//System.out.println("Error al intentar pintar la 
//bola"+e);
        }
        repaint();
    }
}

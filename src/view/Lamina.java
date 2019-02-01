package view;

import controller.ControllerInterface;
import controller.NivelDificil;
import controller.NivelFacil;
import controller.NivelMedio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.Barra;
import model.GeneradorBloques;
import model.Jugador;
import static model.Jugador.getPuntaje;
import model.JugadorDAO;
import model.ObservadorGrafico;
import model.Singleton;
import static view.MenuJuego.lvl;

public class Lamina extends JPanel {

    private ControllerInterface controller;
    private List<Jugador> jugadores = JugadorDAO.getInstancia().getAll();
    private Singleton singleton;
    private Barra ba;
    private boolean DibujarBrick = false;
    private GeneradorBloques bloques;
    JLabel puntaje = new JLabel(getPuntaje(), JLabel.CENTER);
    JLabel life = new JLabel("Vidas", JLabel.CENTER);

    public Lamina() {

        MenuJuego.init(); // porque init()es un metodo static, osea es de la clase entonces se lo aplico a la clase
        //Mostramos todos los alumnos
        for (Jugador a : jugadores) {
            System.out.println(a);
        }
        add(puntaje);
        add(life);
        // CrearSingleton();
        elegirNivel(lvl);

        // bloques = new GeneradorBloques(controller.getx(), controller.gety(), controller.getAnchoBloque(), controller.getAltoBloque(), controller.getCantidad());
        ObservadorGrafico o = new ObservadorGrafico();
        jugadores.get(0).addObserver(o);

    }

    public void agregarObservers() {
        singleton.getPelota().agregarObservadores(bloques); //AGREGO al observador
        singleton.getPelota().agregarObservadores(jugadores.get(0)); //Por ahora uso siempre el primero porque no lo hice para guardara a todos los jugadores
    }

    public void crearFigura() {
        ba = new Barra(10, 70, 10, 40);
    }

    public void crearBloqueBarra() {
        ba = new Barra(5, 750, controller.getAnchoBarra(), controller.getAltoBarra());
        bloques = new GeneradorBloques(controller.getx(), controller.gety(), controller.getAnchoBloque(), controller.getAltoBloque(), controller.getCantidad());
        DibujarBrick = true;
    }

    public void CrearSingleton() {
        singleton = Singleton.getInstance();
    }

    public void dibujar(Graphics2D g) {
        g.fill(ba.getBarra());
        if (DibujarBrick == true) {
            g.fill(bloques.getBloque());
            g.fill(singleton.getPelota().getShape());
        }
    }

    public void actualizar() { //para mover la barra en la laminaa
        ba.moverBarra(getBounds());
        puntaje.setText(getPuntaje());
        life.setText(jugadores.get(0).getVida());
        if (DibujarBrick == true) {
            singleton.getPelota().mueve_pelota(getBounds(), colision(ba.getBarra()), colision(bloques.getBloque()));//reviso la colisión
            /* if (singleton.getPelota().getValor() == true) { //ya no lo uso por usar el patron observer
            singleton.getPelota().setValor();
            bloques.hitBlock();
            jugadores.setPuntaje();
        }*/
            if (singleton.getPelota().getPierde() == true) {
                jugadores.get(0).setVidas();
                singleton.getPelota().setRestaVidas();
                jugadores.get(0).notifyObservers(); //avisa que la pelota toco al bloque para que cambie de posicion y se sumen puntos
            }
        } else {
            ba.bajaBarra();
        }
    }

    public void elegirNivel(int lvl) {
        if (lvl == 1) {
            controller = new NivelFacil();
        }
        if (lvl == 2) {
            controller = new NivelMedio();
        }
        if (lvl == 3) {
            controller = new NivelDificil();
        }
    }

    public ControllerInterface getController() {
        return controller;
    }

    private boolean colision(Rectangle2D r) {
        return singleton.getPelota().getPelota().intersects(r);
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

        actualizar();
        try {
            Thread.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lamina.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }
}

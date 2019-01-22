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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.Barra;
import model.GeneradorBloques;
import model.Jugador;
import static model.Jugador.getPuntaje;
import model.ObservadorGrafico;
import model.Singleton;
import static view.Principal.lvl;
import static view.Principal.nombre;

public class LaminaPelota extends JPanel {

    ControllerInterface controller;
    public static Jugador jugadores; // LO CREE EN EL ARRAY DEL DAO?? o es uno solo, porque nunca uso a la lista para obtener el jguador
    Singleton singleton;
    Barra ba;
    private GeneradorBloques bloques;
    JLabel puntaje = new JLabel(getPuntaje(), JLabel.CENTER);
    JLabel life = new JLabel("Vidas", JLabel.CENTER);

    public LaminaPelota() {
        add(puntaje);
        add(life);
        CrearSingleton();
        elegirNivel(lvl);
        ba = new Barra(5, 750, controller.getAnchoBarra(), controller.getAltoBarra());
        bloques = new GeneradorBloques(controller.getx(), controller.gety(), controller.getAnchoBloque(), controller.getAltoBloque(), controller.getCantidad());
        jugadores = new Jugador(nombre);
        ObservadorGrafico o = new ObservadorGrafico();
        jugadores.addObserver(o);
        singleton.getPelota().agregarObservadores(bloques); //AGREGO al observador
        singleton.getPelota().agregarObservadores(jugadores);
    }

    public void CrearSingleton() {
        singleton = Singleton.getInstance();
    }

    public void dibujar(Graphics2D g) {
        g.fill(singleton.getPelota().getShape());
        g.fill(ba.getBarra());
        g.fill(bloques.getBloque());
    }

    public void actualizar() { //para mover la barra en la laminaa
        ba.MoverBarra(getBounds());
        puntaje.setText(getPuntaje());
        life.setText(jugadores.getVida());

        singleton.getPelota().mueve_pelota(getBounds(), colision(ba.getBarra()), colision(bloques.getBloque()));//reviso la colisión
        /* if (singleton.getPelota().getValor() == true) { //ya no lo uso por usar el patron observer
            singleton.getPelota().setValor();
            bloques.hitBlock();
            jugadores.setPuntaje();
        }*/
        if (singleton.getPelota().getPierde() == true) {
            jugadores.setVidas();
            singleton.getPelota().setRestaVidas();
            jugadores.notifyObservers();
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
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(LaminaPelota.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }
}

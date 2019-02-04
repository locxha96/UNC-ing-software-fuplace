
import controller.ControllerInterface;
import controller.NivelFacil;
import controller.NivelDificil;
import controller.NivelMedio;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.List;
import model.GeneradorBloques;
import model.Jugador;
import model.JugadorDAO;
import model.Pelota;
import model.Singleton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import view.Lamina;
import view.MenuJuego;

/**
 *
 * @author Cristian Velazquez
 */
public class TestGame {

    private TestGame test;
    List<Jugador> jugadores = JugadorDAO.getInstancia().getAll();
    private Singleton singleton;
    private javax.swing.JTextField txtd;

    @Before
    public void before() { //Se usa para ejectuar algo antes que lo demas metodos
        JugadorDAO dao = JugadorDAO.getInstancia();
        dao.add(new Jugador("Pedro"));
        dao.add(new Jugador("Juan"));

    }

    @Test
    public void testCreacionNivelFacil() {
        MenuJuego p = new MenuJuego();
        p.lvl = 1;
        Lamina l = new Lamina();
        ControllerInterface facil = new NivelFacil();
        assertEquals(facil.getAnchoBarra(), l.getController().getAnchoBarra());
    }

    @Test
    public void testCreacionNivelMedio() {
        MenuJuego p = new MenuJuego();
        p.lvl = 2;
        Lamina l = new Lamina();
        ControllerInterface medio = new NivelMedio();
        assertEquals(medio.getAnchoBarra(), l.getController().getAnchoBarra());
    }

    @Test
    public void testCreacionNivelDificil() {
        MenuJuego p = new MenuJuego();
        p.lvl = 3;
        Lamina l = new Lamina();
        ControllerInterface dificil = new NivelDificil();
        assertEquals(dificil.getAnchoBarra(), l.getController().getAnchoBarra());
    }

    @Test
    public void testCreacionJugadores() {
        Jugador p = new Jugador("Pedro");
        Jugador j = new Jugador("Juan");
        assertEquals(p.getNombre(), jugadores.get(0).getNombre());
        assertEquals(j.getNombre(), jugadores.get(1).getNombre());
    }

    @Test
    public void testGanaPuntos() {
        GeneradorBloques g = new GeneradorBloques(20, 20, 30, 10, 4);
        Pelota p = new Pelota();
        p.agregarObservadores(g);
        p.agregarObservadores(jugadores.get(0));
        p.notificar();
        p.notificar();
        assertEquals(20, jugadores.get(0).Puntaje());//Impacta dos bloques
    }

    @Test
    public void testGanaJuego() {
        GeneradorBloques g = new GeneradorBloques(20, 20, 30, 10, 4);
        Pelota p = new Pelota();
        Rectangle r = new Rectangle();
        p.mueve_pelota(r, false, true);
        p.mueve_pelota(r, false, true);
        p.mueve_pelota(r, false, true);
        p.mueve_pelota(r, false, true);
        assertEquals(20, jugadores.get(0).Puntaje());
    }

  
}

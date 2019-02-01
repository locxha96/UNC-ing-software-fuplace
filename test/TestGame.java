/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controller.ControllerInterface;
import controller.NivelFacil;
import controller.NivelDificil;
import controller.NivelMedio;
import model.Pelota;
import model.Singleton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    //private LaminaPelota l;
    //Singleton single;
    
    @Before
    public void before(){ //Se usa para ejectuar algo antes que lo demas metodos
        // l = new LaminaPelota();
    }
    @Test
        public void testCreacionNivelFacil(){ // xq falla?
        MenuJuego p = new MenuJuego();
        p.lvl = 1;
        Lamina l = new Lamina();
        ControllerInterface facil = new NivelFacil();
        assertEquals(facil.getAnchoBarra(),l.getController().getAnchoBarra());
         }
    
   @Test
    public void testCreacionNivelMedio(){ // xq falla?
        MenuJuego p = new MenuJuego();
        p.lvl = 2;
        Lamina l = new Lamina();
        ControllerInterface medio = new NivelMedio();
        assertEquals(medio.getAnchoBarra(),l.getController().getAnchoBarra());
         }
    @Test
    public void testCreacionNivelDificil(){ // xq falla?
        MenuJuego p = new MenuJuego();
        p.lvl = 3;
        Lamina l = new Lamina();
        ControllerInterface dificil = new NivelDificil();
        assertEquals(dificil.getAnchoBarra(),l.getController().getAnchoBarra());
         }
    
    /*public void testCreacionNivelRandom(){ // xq falla?
        MenuJuego p = new MenuJuego();
        p.lvl = ;
        Lamina l = new Lamina();
        ControllerInterface dificil = new NivelDificil();
        assertEquals(dificil.getAnchoBarra(),l.getController().getAnchoBarra());
         }*/
  
    @Test
    public void testSingleton() { //porque se crean dos instancias??
      Singleton single1 = Singleton.getInstance();
      Singleton single2 = Singleton.getInstance();
      assertEquals(single1,single2);
        }
    
    /*@Test
    public void testNombre(){
       MenuJuego p = new MenuJuego();
        p.nombre = "Juan";
        Lamina l = new Lamina();        
        assertEquals("Juan", l.jugadores.get(0).getNombre());
    }*/
    
    /*@Test
    public void testSingleton(){
      l.CrearSingleton();
      Singleton.getInstance();
      l.CrearSingleton();
    }*/
    
    }

   
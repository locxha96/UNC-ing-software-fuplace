/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controller.ControllerInterface;
import controller.NivelFacil;
import controller.NivelMedio;
import model.Pelota;
import model.Singleton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.LaminaPelota;
import view.Principal;

/**
 *
 * @author Cristian Velazquez
 */
public class TestGame {
    private TestGame test;
    private LaminaPelota l;
    Singleton single;
    
    @Before
    public void before(){ //Se usa para ejectuar algo antes que lo demas metodos
         l = new LaminaPelota();
    }
  /*@Test
    public void testCreacionNivel(){ // xq falla?
       
        l.elegirNivel(2);
        ControllerInterface facil = new NivelMedio();
        assertEquals(facil,l.getController());
         }*/
  
    /* @Test
    public void testSingleton() { //porque se crean dos instancias??
      Singleton single1 = Singleton.getInstance();
      Singleton single2= Singleton.getInstance();
      assertEquals(single1,single2);
        }
    */
    /*@Test
    public void testSingleton(){
      l.CrearSingleton();
      Singleton.getInstance();
      l.CrearSingleton();
    }*/
    
    }

   
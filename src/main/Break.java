
package main;


import java.util.List;
import model.InicializaDB;
import model.Jugador;
import model.JugadorDAO;
import model.ObservadorGrafico;

import view.Principal;

public class Break {
public static void main(String[] args) 
{
  Principal.init(); // porque init()es un metodo static, osea es de la clase entonces se lo aplico a la clase
        
        List<Jugador> jugadores=JugadorDAO.getInstancia().getAll();
        //Mostramos todos los alumnos
        for (Jugador a: jugadores) {
            System.out.println(a);
            }
        
Jugador j= new Jugador("Pedro");
ObservadorGrafico o= new ObservadorGrafico();
j.addObserver(o);

Principal v = new Principal();
v.setLocationRelativeTo(null);
v.setVisible(true);
j.setVidas(0);
j.notifyObservers();

}
}
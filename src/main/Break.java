
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


Principal v = new Principal();
v.setLocationRelativeTo(null);
v.setVisible(true);


}
}
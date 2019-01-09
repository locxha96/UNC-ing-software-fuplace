
package main;


import model.Jugador;
import model.ObservadorGrafico;

import view.Principal;

public class Break {
public static void main(String[] args) 
{
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
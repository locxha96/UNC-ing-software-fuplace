
package model;

import java.util.Observable;


public class Jugador extends Observable {
    private String Nombre;
    private int Puntaje;
    private int Vidas;

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }

    public void setVidas(int Vidas) {
        this.Vidas = Vidas;
        if(Vidas==0){
        setChanged();}
    }

    public Jugador(String Nombre) {
        this.Nombre = Nombre;
    }
    
}

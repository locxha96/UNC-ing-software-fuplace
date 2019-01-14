
package model;

import java.util.Observable;


public class Jugador extends Observable {
    private String nombre;
    private static int puntaje=0;
    private int vidas=2;

    public void setPuntaje(int Puntaje) {
        this.puntaje = puntaje;
    }

    public void setVidas() {
        vidas=vidas-1;
        if(vidas==0){//llama solo si perdio
       // setChanged();
        }
    }

    public Jugador(String Nombre) {
        this.nombre = Nombre;
    }
public void setPuntaje() {
    puntaje=puntaje+10;
    //setChanged();
}
    @Override
    public String toString() {
        return "Jugador{" + "Nombre=" + nombre + ", Puntaje=" + puntaje + '}';
        
    }
    public static String getPuntaje(){
        return "Tu puntaje espuntaje: " + puntaje;
    }
    
}

package model;

import java.util.Observable;

public class Jugador extends Observable implements Observador {

    private String nombre;
    private static int puntaje = 0;
    private int vidas = 2;

    public void setVidas() {
        vidas = vidas - 1;
        if (vidas == 0) {//llama solo si perdio
            setChanged();
        }
    }

    public Jugador(String Nombre) {
        this.nombre = Nombre;
    }

    public void setPuntaje() {
        puntaje = puntaje + 10;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" + "Nombre=" + nombre + ", Puntaje=" + puntaje + '}';

    }

    public String getVida() {
        return "Vidas:" + vidas;
    }

    public static String getPuntaje() {
        return "Tu puntaje es puntaje: " + puntaje;
    }

    @Override
    public void update() {
        setPuntaje();
    }

}

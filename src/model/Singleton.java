package model;

public class Singleton {

    private static Pelota pelota; // porque es unica de la clase
    private static Singleton instancia;

    private Singleton() {
        pelota = new Pelota();
    }

    public static Singleton getInstance() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    public static Pelota getPelota() {
        return pelota;
    }
}

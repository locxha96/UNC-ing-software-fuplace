package model;

import java.util.ArrayList;

public class JugadorDAO {
    //Instancia unica de la clase.

    private static final JugadorDAO instancia = new JugadorDAO();
    private ArrayList<Jugador> jugadores;

    //constructor privado para que no se puedan crear objetos de esta clase.
    private JugadorDAO() {
        //La unica vez que se llame al constructor inicializo el arraylist
        jugadores = new ArrayList<>();
    }

    //metodo para obtener la referencia a la instancia unica de la clase.
    public static JugadorDAO getInstancia() {
        return instancia;
    }

    public boolean add(Jugador a) {
        return jugadores.add(a);
    }

    public boolean delete(Jugador a) {
        return jugadores.remove(a);
    }

    public ArrayList<Jugador> getAll() {
        return jugadores;
    }
}

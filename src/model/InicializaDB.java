
package model;

// BORRAR ESTA CLASE
public class InicializaDB {
    public static void init(){
        JugadorDAO dao=JugadorDAO.getInstancia();
        
        dao.add(new Jugador("Pedro"));
        dao.add(new Jugador("Marta"));
        dao.add(new Jugador("Andres"));
        dao.add(new Jugador("Pedro"));
 
        
    }
}
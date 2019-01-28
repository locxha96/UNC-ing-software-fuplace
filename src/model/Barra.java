package model;

import java.awt.Rectangle;

public class Barra extends Figura {

    public Barra(int x, int y, int ANCHO, int ALTO) {
        super(x, y, ANCHO, ALTO);

    }
     //desplazamineto de la barra horizontal

    public void MoverBarra(Rectangle limites) {
        if (Teclado.a && getX() > limites.getMinX()) {
            setX(getX() - 1);
        }
        if (Teclado.d && getX() < limites.getMaxX() - getAncho()) {
            setX(getX() + 1);;
        }

    }
    
    public void bajaBarra(){
        setY(getY()+1);
    }

}

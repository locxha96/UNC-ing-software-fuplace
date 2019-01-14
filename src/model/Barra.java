
package model;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Barra extends Figura{

    
    public Barra(int x, int y, int ANCHO, int ALTO) {
        super(x, y, ANCHO, ALTO);
    
}
   public Rectangle2D getBarra() {
        return new Rectangle2D.Double(getX(), getY(), getAncho(), getAlto());
} //desplazamineto de la barra horizontal
   public void MoverBarra (Rectangle limites) {
        if (Teclado.a && getX() > limites.getMinX()) {
            setX(getX()-1);
        }
        if (Teclado.d && getX() < limites.getMaxX()-getAncho()) {
            setX(getX()+1);;
        }
        
    }

    }


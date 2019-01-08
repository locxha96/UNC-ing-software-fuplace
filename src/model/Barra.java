
package model;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Barra {
    private int x,y;
   static final int ANCHO = 80, ALTO = 10;
    
    public Barra(int x, int y){
        this.x=x;
        this.y=y;
    
}
   public Rectangle2D getBarra() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
} //desplazamineto de la barra
   public void MoverBarra (Rectangle limites) {
        if (Teclado.a && x > limites.getMinY()) {
            x--;
        }
        if (Teclado.d && x < limites.getMaxY()-ALTO) {
            x++;
        }
    }

    }


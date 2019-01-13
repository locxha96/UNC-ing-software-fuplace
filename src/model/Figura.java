
package model;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Figura {
    private int x,y;
    private int ANCHO, ALTO;
    
    public Figura(int x, int y, int ANCHO,int ALTO){
        this.x=x;
        this.y=y;
        this.ANCHO=ANCHO;
        this.ALTO=ALTO;
        
    
}
   public Rectangle2D getBarra() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
} //desplazamineto de la barra horizontal
   public void MoverBarra (Rectangle limites) {
        if (Teclado.a && x > limites.getMinX()) {
            x--;
        }
        if (Teclado.d && x < limites.getMaxX()-ANCHO) {
            x++;
        }
        
    }

    }

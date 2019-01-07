
package model;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Barra {
    private int x,y;
   static final int ANCHO = 10, ALTO = 40;
    
    public Barra(int x, int y){
        this.x=x;
        this.y=y;
    
}
   public Rectangle2D getBarra() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
}
}

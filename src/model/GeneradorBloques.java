package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class GeneradorBloques extends Figura{
        private int x,y;
    int ANCHO = 100, ALTO =30;
    
    public GeneradorBloques(int x, int y, int ANCHO,int ALTO){
        super(x,y,ANCHO, ALTO);
    
}
   public Rectangle2D getBloque() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
}
   public void setTamaño(){
       x=0;
       y=0;
       ANCHO=0;
       ALTO=0;
   }
    
   /* public int mapa[][];
    public int anchoBloque;
    public int altoBloque;
    public GeneradorBloques(int fila, int col){
    mapa = new int[fila][col];
        for(int i=0; i < mapa.length; i++){
            for(int j=0; j<mapa[0].length ; j++){
                mapa[i][j] = 1;
        }
        }
    anchoBloque = 540/col;
    altoBloque = 150/fila;
    }
    public void dibujar(Graphics2D g){
        for(int i=0; i < mapa.length; i++){
            for(int j=0; j<mapa[0].length ; j++){
                if(mapa[i][j]>0){
                g.setColor(Color.white);
                g.fillRect(j*anchoBloque+25, i*altoBloque+25, anchoBloque, altoBloque);
                g.setStroke(new BasicStroke(3));
                g.setColor(Color.black);
                g.drawRect(j*anchoBloque+25, i*altoBloque+25, anchoBloque, altoBloque);
                }
        }
        }
    }
//darle valor a los bloques para la posible colision
   public void setValorBloque(int valor, int fila, int col){
 mapa[fila][col]= valor;   
}    */

}


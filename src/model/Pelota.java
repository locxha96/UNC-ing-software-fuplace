package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {

    boolean borrar = false;
    boolean restaVidas = false;
    private float TAMX = 15;//eje x elipse (en el circulo si son 

    private float masa;
    private float TAMY = 15;//eje y elipse
    private double x = 0;
    private double y = 0;
    private double dx = 1;// desplazamiento en x (velocidad)
    private double dy = 1;// desplazamiento en y (velocidad)
    Color color = Color.GREEN;
    Rectangle2D limites;
    private GeneradorBloques mapa;
    private int bloquesTotal = 21;

// Lo podemos usar para la seleccion de nivel, pero no es necesario darle un color, solo el diametro para el nivel
/* 
public Pelota(Color color,int diametro)
{
TAMX=diametro;
TAMY=diametro;
masa=diametro*10;
this.color=color;
x=(int)(Math.random()*200);
y=(int)(Math.random()*200);
}*/
    public Pelota() {
        x = 900;
        y = 400;
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x, y, TAMX, TAMY);
    }
// Mueve la pelota invirtiendo posición si choca con límites

    public void mueve_pelota(Rectangle2D limites, boolean colisionBarra, boolean colisionBlock) {
        this.limites = limites;
        x = dx + x;
        y = dy + y;

        if (colisionBarra) {
            dy = -dy;
            y = 730;
        }
        if (colisionBlock) {
            dy = -dy;
            y = 200;
            borrarBlock();
        }//extremno derecho
        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }//parte inferior
        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
            restaVidas = true;
        }//extremo izquierdo
        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }//parte superior
        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
    }

    public void borrarBlock() {
        borrar = true;

    }

    public boolean getPierde() {
        return restaVidas;
    }

    public void setRestaVidas() {
        restaVidas = false;
    }

    public boolean getValor() {
        return borrar;
    }

    public void setValor() {
        borrar = false;
    }
//Forma de la pelota en su posición inicial

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    public Color getColor() {
        return color;
    }

    public void pintar_bola(Graphics g) {
        g.setColor(color);

        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x, y, TAMX, TAMY));
        mueve_pelota(limites, true, true);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public float getRadio() {
        return TAMX / 2;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public float getMasa() {
        return masa;
    }

    public void setDx(double desplazamientox) {
        dx = desplazamientox;
    }

    public void setDy(double desplazamientoy) {
        dy = desplazamientoy;
    }

}

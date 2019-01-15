package model;

import java.awt.geom.Rectangle2D;

public class Figura {

    private int x, y;
    private int ANCHO, ALTO;

    public Figura(int x, int y, int ANCHO, int ALTO) {
        this.x = x;
        this.y = y;
        this.ANCHO = ANCHO;
        this.ALTO = ALTO;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ANCHO;
    }

    public int getAlto() {
        return ALTO;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setANCHO(int ANCHO) {
        this.ANCHO = ANCHO;
    }

    public void setALTO(int ALTO) {
        this.ALTO = ALTO;
    }

    public Rectangle2D getBloque() {
        return new Rectangle2D.Double(getX(), getY(), getAncho(), getAlto());
    }

    public Rectangle2D getBarra() {
        return new Rectangle2D.Double(getX(), getY(), getAncho(), getAlto());
    }

}

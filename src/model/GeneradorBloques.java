package model;

public class GeneradorBloques extends Figura {

    public GeneradorBloques(int x, int y, int ANCHO, int ALTO) {
        super(x, y, ANCHO, ALTO);

    }

    public void setTamaño() {
        setX(0);
        setY(0);
        setANCHO(0);
        setALTO(0);
    }

}

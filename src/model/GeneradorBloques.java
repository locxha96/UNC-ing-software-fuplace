package model;

public class GeneradorBloques extends Figura implements Observador {

    int repeticionBloque;

    public GeneradorBloques(int x, int y, int ANCHO, int ALTO, int repeticionBloque) {
        super(x, y, ANCHO, ALTO);
        this.repeticionBloque = repeticionBloque;

    }

    public void setPos(int x, int y) { //nueva posicion cuando la pelota impacta al bloque
        setX(x);
        setY(y);
    }

    public void hitBlock() {
        repeticionBloque = repeticionBloque - 1;
        if (repeticionBloque == 0) {
            setTamaño();
        } else {
            setPos((int) (Math.random() * 200), (int) (Math.random() * 200));
        }
    }

    public void setTamaño() {
        setX(0);
        setY(0);
        setANCHO(0);
        setALTO(0);
    }

    @Override
    public void update() {
        hitBlock();

    }
}

package controller;

public class NivelDificil extends NIVEL implements ControllerInterface {

    public NivelDificil() {
        x = 400;
        y = 100;
        anchoBloque = 20;
        altoBloque = 30;
        anchoBarra = 30;
        altoBarra = 10;
        cantidad=10;
    }

    @Override
    public int getRadio() {
        return radioPelota;
    }

    @Override
    public int getx() {
        return x;
    }

    @Override
    public int gety() {
        return y;
    }

    @Override
    public int getAnchoBarra() {
        return anchoBarra;
    }

    @Override
    public int getAltoBarra() {
        return altoBarra;
    }

    @Override
    public int getAnchoBloque() {
        return anchoBloque;
    }

    @Override
    public int getAltoBloque() {
        return altoBloque;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

}

package controller;

import view.LaminaPelota;

public class NivelMedio extends NIVEL implements ControllerInterface {

    public NivelMedio() {
        x = 250;
        y = 100;
        anchoBloque = 80;
        altoBloque = 30;
        anchoBarra = 50;
        altoBarra = 10;
        cantidad=8;
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

    @Override
    public LaminaPelota getPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Crear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

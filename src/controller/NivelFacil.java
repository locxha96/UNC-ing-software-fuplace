
package controller;


import java.util.Random;



public class NivelFacil extends NIVEL implements ControllerInterface{

public NivelFacil(){
x=100;
y=200;
anchoBloque=100;
altoBloque=30;
anchoBarra =80;
altoBarra=10;
}



    @Override
    public int getRadio() {
       return rr;
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

   
   
}

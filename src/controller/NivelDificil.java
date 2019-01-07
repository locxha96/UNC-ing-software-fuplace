package controller;

import java.util.Random;

public class NivelDificil implements ControllerInterface {

    public int r;
    public int g;
    public int b;
    public int rr = 10;

    public NivelDificil() {
        Random rand = new Random();
        r = rand.nextInt(255);
        g = rand.nextInt(255);
        b = rand.nextInt(255);
    }

    @Override
    public int getr() {
        return r;
    }

    @Override
    public int getg() {
        return g;
    }

    @Override
    public int getb() {
        return b;
    }

    @Override
    public int getRadio() {
        return rr;
    }

}

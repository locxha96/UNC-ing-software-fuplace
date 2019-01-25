package controller;

import view.LaminaPelota;


public interface ControllerInterface {
   LaminaPelota getPanel();
   void Crear();
   int getx();
   int gety();
   int getRadio();
   int getAnchoBarra();
   int getAltoBarra();
   int getAnchoBloque();
   int getAltoBloque();
   int getCantidad();
}

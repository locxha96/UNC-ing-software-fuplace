package controller;

import view.Lamina;


public interface ControllerInterface {
   Lamina getPanel();
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

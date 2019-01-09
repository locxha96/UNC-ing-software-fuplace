
package model;
import view.LaminaPelota;

public class HiloPelota extends Thread//implements Runnable
{
   //para actualizar la pelota
    
    private static LaminaPelota lamina;
   
public HiloPelota(LaminaPelota lamina)
    {

     this.lamina=lamina;
    }
public void run()
    {
while(true)
 {lamina.repaint();
   }
 
}}

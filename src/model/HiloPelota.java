
package model;
import javax.swing.JLabel;
import static model.Jugador.getPuntaje;
import view.LaminaPelota;

public class HiloPelota extends Thread
{
   //para actualizar la pelota
    
    private static LaminaPelota lamina;
    private static JLabel v;
   //AGREGUE EL JLABEL PERO no cambia el puntaje
public HiloPelota(LaminaPelota lamina, JLabel v)
    {

     this.lamina=lamina;
    this.v=v;
    
    }
public void run()
    {
while(true)
 {lamina.repaint();
 v.setText(getPuntaje());
   }
 
}}

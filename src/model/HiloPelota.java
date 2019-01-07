
package model;
import view.LaminaPelota;

public class HiloPelota extends Thread//implements Runnable
{
    private Pelota pelota;
    private static LaminaPelota lamina;
public HiloPelota(Pelota pelota, LaminaPelota lamina)
    {
     this.pelota=pelota;
     this.lamina=lamina;
    }
public void run()
    {
lamina.add(pelota);

pelota.mueve_pelota(lamina.getBounds());
    }
}


package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.geom.Rectangle2D;
import model.Barra;
import model.GeneradorBloques;
import model.Pelota;


public class LaminaPelota extends JPanel
{
      Pelota pelota = new Pelota();
      Barra ba= new Barra(5,750);
      private int bloquesTotal = 21;
      private GeneradorBloques mapa;
private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
//Añadimos pelota a la lámina
public void add(Pelota b)
{
pelotas.add(b);
}
//borrar esto
public void eliminar()
{
if(!pelotas.isEmpty()) 
    pelotas.remove(pelotas.size()-1);
}
public int contar()
{
return(pelotas.size());
}
public void dibujar(Graphics2D g) {
       g.fill(pelota.getShape());
       g.fill(ba.getBarra());
    }
 public void actualizar() { //para mover la barra en la laminaa
 ba.MoverBarra(getBounds());
 pelota.mueve_pelota(getBounds(), colision(ba.getBarra()));
    }
 
 private boolean colision(Rectangle2D r){
 return pelota.getPelota().intersects(r);
 }
//este metodo se llama automaticamente cuando se lo necesita para dibujar pelota y barra
public void paintComponent(Graphics g) 
{
super.paintComponent(g);
g.setColor(new Color( 245, 245, 220 ));
g.fillRect(0,0,getWidth(),getHeight());
Graphics2D g2 = (Graphics2D) g; //lo convierto
g2.setColor(Color.BLACK);
dibujar(g2);
mapa = new GeneradorBloques(3, 7);
mapa.dibujar((Graphics2D) g);
actualizar();//ACA SE PODRIA USAR OBSERVER PARA la barra y buscar EL METODO Q MUEVE actu la pelota!!!

try
{
for(int i=0; i < pelotas.size(); i++)
{
        if(pelotas.size()>=2)
        {
         for(int j=i+1;j<pelotas.size(); j++)
         
if(Pelota.choque(pelotas.get(i),pelotas.get(j)))
          {
				System.out.println("Choque: "+i+" , "+j);
                         	  double masa1=pelotas.get(i).getMasa();
		        		  double velocidadx1=pelotas.get(i).getDx();
		        		  double velocidady1=pelotas.get(i).getDy();
		        		  
		        		  double masa2=pelotas.get(j).getMasa();
		        		  double velocidadx2=pelotas.get(j).getDx();
		        		  double velocidady2=pelotas.get(j).getDy();
		        		  
		        		  double sumaMasas=masa1+masa2;
		        		  
		        		  double velocidadF1x=((masa1-masa2)*velocidadx1+2*masa2*velocidadx2)/sumaMasas;
		        		  double velocidadF1y=((masa1-masa2)*velocidady1+2*masa2*velocidady2)/sumaMasas;
		        		  
		        		  double velocidadF2x=((masa2-masa1)*velocidadx2+2*masa1*velocidadx1)/sumaMasas;
		        		  double velocidadF2y=((masa2-masa1)*velocidady2+2*masa1*velocidady1)/sumaMasas;
		        		  
		        		  pelotas.get(i).setDx(velocidadF1x);
		        		  pelotas.get(i).setDy(velocidadF1y);
		        		  pelotas.get(j).setDx(velocidadF2x);
		        		  pelotas.get(j).setDy(velocidadF2y);
  }
pelotas.get(i).pintar_bola(g);
        }
else
        {
pelotas.get(i).pintar_bola(g);
        }
}
Thread.sleep(5);
}
catch(InterruptedException e)
{
//System.out.println("Error al intentar pintar la 
//bola"+e);
}
repaint();
}
}

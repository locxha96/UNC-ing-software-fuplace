
package model;

public class Singleton {
    
    private static Pelota pelota;
    private static Singleton instance;
    private Singleton(){
    pelota = new Pelota();
    }
    
     public static Singleton getInstance() {
         if(instance==null){
             instance =new Singleton();
         }
        return instance;
    }
     public static Pelota getPelota(){
         return pelota;
     }
}

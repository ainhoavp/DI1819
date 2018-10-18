package Modelo;

/**
 *
 * @author Ainhoa
 */
public class Servidor {
    
   private int contadorAccesos;

    public int getContadorAccesos() {
        return contadorAccesos;
    }

    public void setContadorAccesos(int contadorAccesos) {
        this.contadorAccesos = contadorAccesos;
    }
   
    public Servidor() {
        contadorAccesos = 0;
    }
    
   public void incrementaren1Contador(){
       contadorAccesos++;
   }
    
    
    
}

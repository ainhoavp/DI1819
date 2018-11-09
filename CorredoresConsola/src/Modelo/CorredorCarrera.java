package Modelo;

/**
 *
 * @author Ainhoa
 */
public class CorredorCarrera {
   
    private Corredor corredor;
    private String dorsal;
    private double tiempo;

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "CorredorCarrera{" + "corredor=" + corredor + ", dorsal=" + dorsal + ", tiempo=" + tiempo + '}';
    }
    
    
    
    
   
    
}

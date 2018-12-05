package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Ainhoa
 */
public class CorredorCarrera implements Serializable {

    private Corredor corredor;
    private int dorsal;
    private String tiempo;

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }


    public CorredorCarrera(Corredor corredor, int dorsal) {
        this.corredor = corredor;
        this.dorsal = dorsal;
    }

    
    @Override
    public String toString() {
        return "CorredorCarrera{" + "corredor=" + corredor + ", dorsal=" + dorsal + ", tiempo=" + tiempo + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CorredorCarrera other = (CorredorCarrera) obj;
        if (this.dorsal != other.dorsal) {
            return false;
        }
        if (!Objects.equals(this.corredor, other.corredor)) {
            return false;
        }
        return true;
    }

    
    
}

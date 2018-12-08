package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ainhoa
 */
public class CorredorCarrera implements Serializable, Comparable<CorredorCarrera> {

    private Corredor corredor;
    private int dorsal;
    private String tiempo;
    private int tiempoParaClasificacion;

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

    public int getTiempoParaClasificacion() {
        return tiempoParaClasificacion;
    }

    public void setTiempoParaClasificacion(int tiempoParaClasificacion) {
        this.tiempoParaClasificacion = tiempoParaClasificacion;
    }

    public CorredorCarrera(Corredor corredor, int dorsal) {
        this.corredor = corredor;
        this.dorsal = dorsal;
    }

    public CorredorCarrera(String tiempo) {
        this.tiempo = tiempo;
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

    @Override
    public int compareTo(CorredorCarrera o) {
        if (tiempoParaClasificacion < o.tiempoParaClasificacion) {
            return -1;
        }
        if (tiempoParaClasificacion > o.tiempoParaClasificacion) {
            return 1;
        }
        return 0;
    }

}

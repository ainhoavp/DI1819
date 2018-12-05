package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ainhoa
 */
public class Carrera implements Serializable {

    private String nombreCarrera;
    private Date fechaCarrera;
    private String lugarCarrera;
    private int numeroParticipantes;
    private double precio;
    private boolean finalizada = false;
    ArrayList <CorredorCarrera> corredoresCarrera = new ArrayList<>();

    public Carrera(String nombreCarrera, Date fechaCarrera, String lugarCarrera, int numeroParticipantes, double precio) {
        this.nombreCarrera = nombreCarrera;
        if (this.nombreCarrera == null) {
            throw new IllegalArgumentException("El nombre del carrera no puede estar vacío.");
        }
        this.fechaCarrera = fechaCarrera;
        this.lugarCarrera = lugarCarrera;
        this.numeroParticipantes = numeroParticipantes;
        this.precio = precio;

    }

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        if (this.nombreCarrera == null) {
            throw new IllegalArgumentException("El nombre del carrera no puede estar vacío.");
        }
        this.nombreCarrera = nombreCarrera;
    }

    public Date getFechaCarrera() {
        return fechaCarrera;
    }

    public void setFechaCarrera(Date fechaCarrera) {
        this.fechaCarrera = fechaCarrera;
    }

    public String getLugarCarrera() {
        return lugarCarrera;
    }

    public void setLugarCarrera(String lugarCarrera) {
        this.lugarCarrera = lugarCarrera;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<CorredorCarrera> getCorredoresCarrera() {
        return corredoresCarrera;
    }

    public void setCorredoresCarrera(ArrayList<CorredorCarrera> corredoresCarrera) {
        this.corredoresCarrera = corredoresCarrera;
    }
    
    @Override
    public String toString() {
        return "Carrera{" + "nombreCarrera=" + nombreCarrera + ", fechaCarrera=" + fechaCarrera + ", lugarCarrera=" + lugarCarrera + ", numeroParticipantes=" + numeroParticipantes + ", precio=" + precio + '}';
    }

}

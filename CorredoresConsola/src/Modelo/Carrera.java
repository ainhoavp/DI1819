package Modelo;

import java.util.Date;

/**
 *
 * @author Ainhoa
 */
public class Carrera {

    private String nombreCarrera;
    private Date fechaCarrera;
    private String lugarCarrera;
    private int numeroParticipantes;
    private double precio;
    

    public Carrera(String nombreCarrera, Date fechaCarrera, String lugarCarrera, int numeroParticipantes, double precio) {
        this.nombreCarrera = nombreCarrera;
        this.fechaCarrera = fechaCarrera;
        this.lugarCarrera = lugarCarrera;
        this.numeroParticipantes = numeroParticipantes;
        this.precio = precio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
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

  
    
    
    
}

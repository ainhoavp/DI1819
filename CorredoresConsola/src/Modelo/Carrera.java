package Modelo;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

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
    
    private Map<String, Corredor> listaCorredoresCarrera = new TreeMap<String, Corredor>();

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

    public Map<String, Corredor> getListaCorredoresCarrera() {
        return listaCorredoresCarrera;
    }

    public void setListaCorredoresCarrera(Map<String, Corredor> listaCorredoresCarrera) {
        this.listaCorredoresCarrera = listaCorredoresCarrera;
    }

    
    
    
}

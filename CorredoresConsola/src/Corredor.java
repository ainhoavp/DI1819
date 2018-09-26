/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa
 */
import java.io.Serializable;
import java.util.Objects;

public class Corredor implements Serializable {

    private String nombre, apellido, direccion, dni;
    private String fechaNac;
    private int telefono;

    public Corredor(String nombre, String apellido, String direccion, String dni, String fechaNac, int telefono) {
        if (dni == null) {
            throw new IllegalArgumentException("El dni no puede estar vacío."); //no permite crear corredores sin dni para que no falle luego a la hora de compara.
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    public Corredor(String dni) {
        this.dni = dni;

    }

    public Corredor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null) {
            throw new IllegalArgumentException("El dni no puede estar vacío.");
        }
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona: " + "Nombre: " + nombre + ", Apellido: " + apellido + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final Corredor other = (Corredor) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
    
    
    

}

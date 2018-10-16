/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa
 */
public class Aeronave extends Vehiculo implements Volable, Repostable{
    
    
    private double alturaVuelo;
    private boolean estadoVolandoSiNo;
    private String nombre;
    private int capacidadPasajeros, litrosDeposito, capacidadDeposito;
    private char tipoCombustible;

    
     public Aeronave(String matricula) {
        super(matricula);
    }

    public Aeronave(double alturaVuelo, boolean estadoVolandoSiNo, String nombre, char tipoCombustible, int capacidadPasajeros, int litrosDeposito, int capacidadDeposito, String matricula) {
        super(matricula);
        this.alturaVuelo = alturaVuelo;
        this.estadoVolandoSiNo = estadoVolandoSiNo;
        this.nombre = nombre;
        this.tipoCombustible = tipoCombustible;
        this.capacidadPasajeros = capacidadPasajeros;
        this.litrosDeposito = litrosDeposito;
        this.capacidadDeposito = capacidadDeposito;
    }
    
    
    public double getAlturaVuelo() {
        return alturaVuelo;
    }

    public void setAlturaVuelo(double alturaVuelo) {
        this.alturaVuelo = alturaVuelo;
    }

    public boolean isEstadoVolandoSiNo() {
        return estadoVolandoSiNo;
    }

    public void setEstadoVolandoSiNo(boolean estadoVolandoSiNo) {
        this.estadoVolandoSiNo = estadoVolandoSiNo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(char tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }


    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(int litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }

    public int getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(int capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }

    @Override
    public String toString() {
        return "Aeronave{" + "alturaVuelo=" + alturaVuelo + ", estadoVolandoSiNo=" + estadoVolandoSiNo + ", nombre=" + nombre + ", tipoCombustible=" + tipoCombustible + ", capacidadPasajeros=" + capacidadPasajeros + ", litrosDeposito=" + litrosDeposito + ", capacidadDeposito=" + capacidadDeposito + '}';
    }

    @Override
    public void despegar() {
    estadoVolandoSiNo = true;
    }


    @Override
    public void ganarAltura(int num) {
       alturaVuelo = alturaVuelo + num;
    }

    @Override
    public void perderAtura(int num) {
        alturaVuelo = alturaVuelo - num;

    }
     
    
    @Override
    public void repostar(int cantidadLitros, char tipoCombustible) {
        
        if(tipoCombustible == this.tipoCombustible){
            if((cantidadLitros+this.litrosDeposito)>this.capacidadDeposito){
                System.out.println("No se puede repostar tantos litros. La capacidad máxima del deposito es de "+ capacidadDeposito+ " litros."); //gestionar excepcion
            }else{
                this.litrosDeposito=+cantidadLitros; 
            }
            
        }else{
            System.out.println("El tipo de combustible es incorrecto."); //gestionar excepcion
        }
        
        
    }

    
    
    
}

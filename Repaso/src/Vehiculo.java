/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa
 */
public class Vehiculo implements Acelerable {

private String matricula;
private int totalVehiculos, taquimetro, velocidad, velocidadMaxima, posicionX, posicionY;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public int getTaquimetro() {
        return taquimetro;
    }

    public void setTaquimetro(int taquimetro) {
        this.taquimetro = taquimetro;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    
    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", totalVehiculos=" + totalVehiculos + ", taquimetro=" + taquimetro + ", velocidadMaxima=" + velocidadMaxima + ", posicionX=" + posicionX + ", posicionY=" + posicionY + '}';
    }

    @Override
    public void acelerar(int velocidadA) {
         velocidad+=  velocidadA;
    }

    @Override
    public void frenar(int velocidadF) {
       velocidad = velocidad - velocidadF;
    }

   


    
}

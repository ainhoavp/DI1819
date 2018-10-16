/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa
 */
public class Coche extends Vehiculo implements Repostable{
    
    private int litrosDeposito, capacidadDeposito;
    private String matricula;
    private char tipoCombustible;
    
    
    
    public Coche(String matricula) {
        super(matricula);
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public char getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(char tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }



    @Override
    public String toString() {
        return "Coche{" + "litrosDeposito=" + litrosDeposito + ", capacidadDeposito=" + capacidadDeposito + ", matricula=" + matricula + ", tipoCombustible=" + tipoCombustible + '}';
    }

    @Override
    public void repostar(int cantidadLitros, char tipoCombustible) {
        
        if(tipoCombustible == this.tipoCombustible){
            if((cantidadLitros+this.litrosDeposito)>this.capacidadDeposito){
                System.out.println("No se puede repostar tantos litros idiota"); //gestionar excepcion
            }else{
                this.litrosDeposito=+cantidadLitros; 
            }
            
        }else{
            System.out.println("El tipo de combustible es incorrecto."); //gestionar excepcion
        }
        
        
    }

  
    
    
    
    
    
    
}

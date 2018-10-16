
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa
 */
public class PortaAviones extends Vehiculo{
    
    
    private String nombre;
    private int capacidadAeronave;
    ArrayList <Volable> listaAeronaves = new ArrayList();

    public PortaAviones(String matricula) {
        super(matricula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadAeronave() {
        return capacidadAeronave;
    }

    public void setCapacidadAeronave(int capacidadAeronave) {
        this.capacidadAeronave = capacidadAeronave;
    }

    public ArrayList<Volable> getListaAeronaves() {
        return listaAeronaves;
    }

    public void setListaAeronaves(ArrayList<Volable> listaAeronaves) {
        this.listaAeronaves = listaAeronaves;
    }
    
    
    //metodo agregar
    
    public void agregar(Volable v){
        if (listaAeronaves.size()<capacidadAeronave){
        listaAeronaves.add(v);
    }
    else{
            System.out.println("No hay suficiente capacidad.");
}
    
    
}
}
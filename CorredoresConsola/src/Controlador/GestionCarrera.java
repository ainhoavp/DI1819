package Controlador;

import Modelo.Carrera;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ainhoa
 */
public class GestionCarrera implements Serializable {

    private Date fechaCarrera;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Carrera carrera;
    private ArrayList<Carrera> listaCarreras = new ArrayList();

    
    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public void anadirCarrera(String nombC, Date fechaCarrera, String lugarCarrera, int numeroParticipantes, double precio) {
        Carrera carrera = new Carrera(nombC, fechaCarrera, lugarCarrera, numeroParticipantes, precio);
        listaCarreras.add(carrera);
    }

    public void borrarCarrera(String nombre) {

        if (listaCarreras.contains(new Carrera(nombre))) {
            listaCarreras.remove(new Carrera(nombre));
            System.out.println("Carrera  " + nombre + " , BORRADA.");
        } else {
            System.out.println("No hay carreras con ese nombrei");
        }
    }
    
    
    public int generarDorsal(Carrera carrera){
        
        int numUltimoDorsal = 0;
        for (int i = 0; i < carrera.getCorredoresCarrera().size(); i++) {
           numUltimoDorsal = carrera.getCorredoresCarrera().get(i).getDorsal();
        }
            numUltimoDorsal++;
        return numUltimoDorsal;
        
    }

public void guardarEstado(String nombreFichero) throws FileNotFoundException, IOException{
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero));
    oos.writeObject(this);
    oos.close();
}
      
public void leerEstado(String nombreFichero) throws FileNotFoundException, IOException, ClassNotFoundException{
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero));
    GestionCarrera gestionCarrera = (GestionCarrera) ois.readObject();
    this.listaCarreras = gestionCarrera.getListaCarreras();
    this.carrera = gestionCarrera.getCarrera();
    ois.close();
}

}

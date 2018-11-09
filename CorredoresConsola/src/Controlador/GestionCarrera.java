package Controlador;

import Modelo.Carrera;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ainhoa
 */
public class GestionCarrera {

    private Date fechaCarrera;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Carrera carrera;
    ArrayList<Carrera> listaCarreras = new ArrayList();

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
     
//         public int buscarcorredor(String nombre) {
//        carrera = new Carrera(nombre);
//        //corredores.get(Collections.binarySearch(corredores, c1)).setDni(dni);
//        return Collections.binarySearch(listaCarreras, carrera);
//    }
   



     }

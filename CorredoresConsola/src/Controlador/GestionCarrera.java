package Controlador;

import Modelo.Carrera;
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

//         public int buscarcorredor(String nombre) {
//        carrera = new Carrera(nombre);
//        //corredores.get(Collections.binarySearch(corredores, c1)).setDni(dni);
//        return Collections.binarySearch(listaCarreras, carrera);
//    }
//    public void escribirCsvCarreras() {
//        String outputFile = "C:\\Users\\aainh\\Desktop\\2DAM\\DI\\DI1819\\CorredoresConsola\\carreras.csv";
//
//        try {
//
//            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, false), ',');
//
//            
//            csvOutput.write("Nombre");
//            csvOutput.write("Fecha");
//            csvOutput.write("Lugar");
//            csvOutput.write("Número participantes");
//            csvOutput.write("Precio");
//            
//
//            for (Carrera carrera : listaCarreras) {
//
//                csvOutput.write(carrera.getNombreCarrera());
//                csvOutput.write(sdf.format(carrera.getFechaCarrera()));
//                csvOutput.write(carrera.getLugarCarrera());
//                csvOutput.write(String.valueOf(carrera.getNumeroParticipantes()));
//                csvOutput.write(String.valueOf(carrera.getPrecio()));
//
//                csvOutput.endRecord();
//            }
//
//            csvOutput.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
      
}

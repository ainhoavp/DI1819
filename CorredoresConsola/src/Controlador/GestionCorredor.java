package Controlador;

import Modelo.Corredor;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ainhoa
 */
public class GestionCorredor {

    private Date fechaNacimiento;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Corredor corredor;
    ArrayList<Corredor> listaCorredores = new ArrayList();

    public ArrayList<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void setListaCorredores(ArrayList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    /* constructor */
    public GestionCorredor() {
        leerCsvCorredores();
    }

    public void anadirCorredor(String nombC, String apel, String dir, String dni, Date fecha, int tel) {
        Corredor c = new Corredor(nombC, apel, dir, dni, fecha, tel);
        listaCorredores.add(c);

    }

    public void borrarCorredor(String dni) {

        if (listaCorredores.contains(new Corredor(dni))) {
            listaCorredores.remove(new Corredor(dni));
            System.out.println("Corredor con dni " + dni + " , BORRADO.");
        } else {
            System.out.println("No hay corredores con ese dni");
        }

    }

    public int buscarcorredor(String dni) {
        corredor = new Corredor(dni);
        //corredores.get(Collections.binarySearch(corredores, c1)).setDni(dni);
        return Collections.binarySearch(listaCorredores, corredor);
    }

    public void mostrarLista() {
        System.out.println(listaCorredores);
    }

    public void importarCorredores(List lista) {
        listaCorredores.addAll(lista);
    }

    public void modificarNombre(int pos, String nombre) {
        listaCorredores.get(pos).setNombre(nombre);
    }

    public void modificarDni(int pos, String dni) {
        listaCorredores.get(pos).setDni(dni);
    }

    public void modificarDireccion(int pos, String direccion) {
        listaCorredores.get(pos).setDireccion(direccion);
    }

    public void modificarTelf(int pos, int telf) {
        listaCorredores.get(pos).setTelefono(telf);
    }

    public void modificarFecha(int pos, String fecha) throws ParseException {
        fechaNacimiento = sdf.parse(fecha);
        listaCorredores.get(pos).setfNac(fechaNacimiento);
    }

    public void registroCorredores() {
        for (int i = 0; i < listaCorredores.size(); i++) {
            System.out.println(listaCorredores.get(i).toString());
        }
    }

    public String cadenaCsv() {
        String cadenaCsv = "";
        this.ordenarLista();
        for (int i = 0; i < listaCorredores.size(); i++) {
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getNombre() + ",";
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getDni() + ",";
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getDireccion() + ",";
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getTelefono() + ",";
            //cadenaCsv = cadenaCsv + corredores.get(i).getFechaNacimiento()+"\n";
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getfNac().getDate() + "/";
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getfNac().getMonth() + "/";
            cadenaCsv = cadenaCsv + listaCorredores.get(i).getfNac().getYear() + "\n";
        }
        return cadenaCsv;
    }

    public void ordenarLista() {
        Collections.sort(listaCorredores, new Comparator<Corredor>() {
            @Override
            public int compare(Corredor c1, Corredor c2) {
                return c1.getfNac().compareTo(c2.getfNac());
            }
        });
    }

    public void escribirCsvCorredores() {
        String outputFile = "C:\\Users\\aainh\\Desktop\\2DAM\\DI\\DI1819\\CorredoresConsola\\corredores.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File ArchivoCorredores = new File(outputFile);
            ArchivoCorredores.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            csvOutput.write("Nombre");
            csvOutput.write("Apellido");
            csvOutput.write("Dirección");
            csvOutput.write("Dni");
            csvOutput.write("Fecha nacimiento");
            csvOutput.write("Telefono");
            csvOutput.endRecord();

            for (Corredor corredor : listaCorredores) {

                csvOutput.write(corredor.getNombre());
                csvOutput.write(corredor.getApellido());
                csvOutput.write(corredor.getDireccion());
                csvOutput.write(corredor.getDni());
                csvOutput.write(sdf.format(corredor.getfNac()));
                csvOutput.write(String.valueOf(corredor.getTelefono()));
                csvOutput.endRecord();
            }

            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerCsvCorredores() {
        try {
            CsvReader corredores_import = new CsvReader("C:\\Users\\aainh\\Desktop\\2DAM\\DI\\DI1819\\CorredoresConsola\\corredores.csv");
            corredores_import.readHeaders();

            while (corredores_import.readRecord()) {

                String nombre = corredores_import.get(0);
                String apellidos = corredores_import.get(1);
                String direccion = corredores_import.get(2);
                String dni = corredores_import.get(3);
                String fnac = corredores_import.get(4);
                int telefono = Integer.parseInt(corredores_import.get(5));
                //valueOf convierte 

                Corredor corredorAux = new Corredor(nombre, apellidos, direccion, dni, sdf.parse(fnac), telefono);

                listaCorredores.add(corredorAux);
            }

            corredores_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(GestionCorredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

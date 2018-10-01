
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import paqueteLeerDatos.Leer;

/**
 *
 * @author Ainhoa
 */
public class GestionCorredor {

    private Date fechaNacimiento;
    private SimpleDateFormat sdf;
    private Corredor corredor;
    ArrayList<Corredor> listaCorredores = new ArrayList();

    public ArrayList<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void setListaCorredores(ArrayList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
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

}

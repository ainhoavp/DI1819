
import java.util.ArrayList;
import paqueteLeerDatos.Leer;

/**
 *
 * @author Ainhoa
 */
public class GestionCorredor {

    ArrayList<Corredor> listaCorredores = new ArrayList();

    public void anadirCorredor() {
        Corredor c = null;

        System.out.println("Inserta el nombre del corredor: ");
        String nombC = Leer.leerDato();

        System.out.println("Inserta el apellido del corredor: ");
        String apel = Leer.leerDato();

        System.out.println("Inserta la dirección del corredor: ");
        String dir = Leer.leerDato();

        System.out.println("Inserta el DNI: ");
        String dni = Leer.leerDato();

        System.out.println("Inseta la fecha de nacimiento (dd/mm/aa)");
        String fech = Leer.leerDato();

        System.out.println("Inserta el tlf del corredor");
        int tel = Leer.datoInt();

        c = new Corredor(nombC, apel, dir, dni, fech, tel);
        listaCorredores.add(c);

    }

    public void borrarCorredor(String dni) {
        listaCorredores.remove(new Corredor(dni));

    }

    public void mostrarLista() {
        System.out.println(listaCorredores);
    }
}

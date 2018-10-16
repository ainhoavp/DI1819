package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Ainhoa
 */
public class OperacionesFicheros {

    /**
     * Listar Ficheros
     *
     * @param ruta
     * @param ordenarTamañoSiNo
     * @param soloDirectorios
     * @return Lista de Ficheros o null si no es directorioo está vacio
     */
    public static List<File> listarFicheros(String ruta, boolean ordenarTamañoSiNo, boolean soloDirectorios) throws Excepciones.NoEsDirectorio { // boolean ordernarPorNombre, boolean soloDirectorios)

        //punto uno ruta vacía
        if (ruta.isEmpty()) { //si la ruta está vacía
            if (File.listRoots()[0].equals("/")) { //lamamos al metodo listRoots que devuelve un array de Files con las rutas del sistema.
                OperacionesFicheros.listarFicheros("/", false, true);// si es /(linux) volvemos a llamar al método y le pasamos al constructor la ruta
            } else {
                OperacionesFicheros.listarFicheros("C:\\", false, true);//si no es /(linux), es win por lo que llamamos al const. con la ruta c:\\
            }
        }

        File punteroFile = new File(ruta);

        if (!punteroFile.isDirectory()) {
            return null;
        }

        File[] arrayFicheros = punteroFile.listFiles();
        List<File> listaFicheros = Arrays.asList(arrayFicheros);

//_________________COMPARADOR DE FICHEROS POR TAMAÑO______________________
        Comparator<File> comparadorFilesTamano = new Comparator<File>() {
            @Override
            public int compare(File fichero1, File fichero2) {
                if (fichero1.length() < fichero2.length()) {
                    return -1;
                }
                if (fichero1.length() > fichero2.length()) {
                    return 1;
                }
                return 0;
            }
        };
        //____________________________FIN_________________________________________

        if (ordenarTamañoSiNo) {
            Collections.sort(listaFicheros, comparadorFilesTamano);
        }

        ArrayList<File> solosDirectorios = new ArrayList<>();
        if (soloDirectorios) {
            for (File listaFichero : listaFicheros) {
                if (listaFichero.isDirectory()) {
                    solosDirectorios.add(listaFichero);
                }
            }
            return solosDirectorios;
        } else {
            throw new Excepciones.NoEsDirectorio("No es directorio.");
        }
    }

    /*
b.	int crearDirectorios(File rutaOrigen, ArrayList<String> listaDirectorios)
i.	Si la ruta de origen no existe salta una excepción.
ii.	Si el directorio existe salta una excepción.
iii.	Retorna el total de directorios creados.
iv.	Probar el correcto funcionamiento desde un método main().
v.	Generar Javadoc.
     */
    public static int crearDirectorios(File rutaOrigen, ArrayList<String> listaDirectorios) throws Excepciones.LaRutaNoExiste, Excepciones.ElDirectorioYaExiste {
        if (rutaOrigen == null | listaDirectorios == null) {
            throw new IllegalArgumentException();
        }

        int cantidadFicherosCreados = 0;

        if (!rutaOrigen.exists()) {
            throw new Excepciones.LaRutaNoExiste("La ruta no existe.");
        } else if (listaDirectorios.isEmpty()) {
            //otra
        }

        if (!rutaOrigen.isDirectory()) {
            //lanzar otra
        }

        String[] nombreDirectoriosDeLaRutaDelParametro = rutaOrigen.list();

        for (int i = 0; i < nombreDirectoriosDeLaRutaDelParametro.length; i++) {
            if (listaDirectorios.contains(nombreDirectoriosDeLaRutaDelParametro[i])) {
                throw new Excepciones.ElDirectorioYaExiste("El directorio ya existe en la ruta.");
            }
        }
        for (String listaDirectorio : listaDirectorios) {
            File fichero = new File(rutaOrigen.getAbsolutePath() + "/" + listaDirectorio);
            fichero.mkdir();
            cantidadFicherosCreados++;
            System.out.println(fichero.toString());
        }

        return cantidadFicherosCreados;
    }

}

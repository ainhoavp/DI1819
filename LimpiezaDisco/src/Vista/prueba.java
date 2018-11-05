/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Gestion;
import java.io.File;
import java.util.List;

/**
 *
 * @author Ainhoa
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Gestion gestion = new Gestion();

        gestion.listRecursively("C:\\Users\\aainh\\Desktop\\Ainhoa");
        
        
        
        
        List <File> lista = gestion.getListForRecursiveMethod();
         for (File ficheroTamanio : lista) {
                    double tamanio = (double)(ficheroTamanio.length()/1024)/1024; //en mb
                    if(tamanio < 1024){
                        System.out.println("Fichero menor de 1Gb "+tamanio+"Mb "+ ficheroTamanio.length()+" bytes" );
                    }
                    else{
                        System.out.println("Fichero mayor de 1Gb "+ tamanio);
                    }
                    
        
        

//        List<File> listaFileC = gestion.getListForRecursiveMethod();
//        ArrayList<String> listaConSoloNombres = new ArrayList<>();
//        List<File> listaConRutasBorrar = new ArrayList<>();
//        int contador = 0;
//
//        for (File file : listaFileC) {
//            if (file.isDirectory() && file.toString().toLowerCase().contains("chrome") && file.toString().toLowerCase().endsWith("cache") && !file.toString().toLowerCase().contains("script")) {
//                //listaConSoloNombres.add(file.getAbsolutePath());
//                System.out.println(file.toString());
//                File [] borrar = file.listFiles();
//                for (File fileBorrar : borrar) {
//                    fileBorrar.delete();
//                    contador++;
                    
                }
            }

        
       // System.out.println("se han borrado " + contador + " ficheros");

        // ya tengo lista de String con los nombre de ficheros o carpetas de la ruta.
//        for (String ruta : listaConSoloNombres) {
//            if (ruta.toLowerCase().contains("opera") && ruta.toLowerCase().endsWith("cache") && !ruta.toLowerCase().contains("roaming")) {
//                File rutaCache = new File(ruta);
//                listaConRutasBorrar.add(rutaCache);
//                for (File borrar : listaConRutasBorrar) {
//                    System.out.println(borrar.toString());
//                    File[] listaYborrar = borrar.listFiles();
//                    for (File file : listaYborrar) {
//                        file.delete();
//                        contador++;
//                    }
//
//                }
//
//            }
//
//        }
//        System.out.println("se han borrado " + contador + " ficheros");

    
    
    
    
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Gestion;
import java.io.File;

/**
 *
 * @author Ainhoa
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        /* File file = new File("C:/");
        String [] directorios = file.list();
        for (String directorio : directorios) {
            System.out.println(directorio);
        }*/
        Gestion g = new Gestion();
     
        //File[] prueba = file.listFiles();
        //for (File file1 : prueba) {
           // System.out.println(file1);
       // }

       g.listarRecursivo("C:\\");
        
       
    }

        public File[] listarRecursivo(String ruta) {
        file = new File(ruta);

        File[] directorios = file.listFiles();

        if (directorios != null) {

            for (int i = 0; i < directorios.length; i++) {
                System.out.println(directorios[i].getName());
                if (directorios[i].isDirectory()) {
                    System.out.println(directorios[i].toString());
                    listarRecursivo(directorios[i].getAbsolutePath());
                }
                if (directorios[i].isFile()) {
                    System.out.println("Esto es un fichero: " + directorios[i].toString());
                }
            }
        }
        return directorios;
    }
    
    
    
    
    
    
    
    
    
    
}


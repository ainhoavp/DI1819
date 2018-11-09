/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Excepciones;
import Modelo.OperacionesFicheros;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ainhoa
 */
public class Visualiza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Excepciones.LaRutaNoExiste, Excepciones.ElDirectorioYaExiste {

        OperacionesFicheros op = new OperacionesFicheros();
        /*
        List<File> files = new ArrayList();
        try {
        files = op.listarFicheros("c://", true, false);
        } catch (Excepciones.NoEsDirectorio ex) {
        Logger.getLogger(Visualiza.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (File file : files) {
        System.out.println(file);
        }
         */


      File file = new File("C:\\");        
      ArrayList <String> directorios = new ArrayList<>();
      directorios.add("ainhoa");
      
     op.crearDirectorios(file, directorios);
     
      
        



    }
    
    

}

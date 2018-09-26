
import paqueteLeerDatos.Leer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ainhoa
 */
public class Menu {

    Corredor co = new Corredor();
    GestionCorredor gc = new GestionCorredor();
    private boolean salir = false;
    private int opcion;

    public void MostrarMenu() {
        while (!salir) {

            System.out.println("1 Alta corredor");
            System.out.println("2 Baja corredor.");
            System.out.println("3 Modificar corredor.");
            System.out.println("4 Mostrar lista corredores.");
            System.out.println("5 Salir");

            System.out.println("Introduce tu opción y pulsa enter:");
            opcion = Leer.datoInt();

            switch (opcion) {

                case 1:
                    gc.anadirCorredor();
                    break;
                case 2:
             
                    break;
                case 3:
                   
                    break;
                case 4:
                     gc.mostrarLista();
                    break;
              case 5:
                   salir = true;
                    break;
                           default:
                    System.out.println("La opción introducida no está en la lista de opciones.");

            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.MiHilo;

/**
 *
 * @author Ainhoa
 */
public class PruebaHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        // codigo que lanzará los hilos
        int i;
        MiHilo hilo = new MiHilo();
        hilo.start();
        for (i = 1; i <= 10000; i++) {
            System.out.print("SI ");
            if (i % 200 == 0) {
                System.out.print("\n ");
           
            Thread.sleep(5); //añadir el throw
            }
        }
    }
}

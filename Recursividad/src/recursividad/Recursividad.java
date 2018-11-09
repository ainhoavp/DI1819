/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad;

import paqueteLeerDatos.Leer;

/**
 *
 * @author Ainhoa
 */
public class Recursividad {

    public static void main(String[] args) {

        System.out.println("Introduce un número mayor a 0");
        int n = Leer.datoInt();
        while (n > 0) {
            calcularFactorial(n);
            n = n - 1;
        }

    }

    public static void calcularFactorial(int n) {
        if (n < 1) {
            System.out.println("El numero debe ser mayor de 0");
        } else {
            int factorial = 1;
            for (int j = n; j > 0; j--) {
                factorial = factorial * j;
            }
            System.out.println("El factorial de " + n + " es " + factorial);
        }

    }
}

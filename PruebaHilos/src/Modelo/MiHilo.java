/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ainhoa
 */
public class MiHilo extends Thread{
    
    @Override
    public void run(){
int i;
for(i=1;i<=10000;i++) {
    System.out.print ("NO");
    if ( i%200==0) System.out.print ("\n ");
    // Thread.sleep(10); //añadir el throw
    
    
}
    }
}
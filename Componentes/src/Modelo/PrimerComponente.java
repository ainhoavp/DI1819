/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author Ainhoa
 */
public class PrimerComponente extends JLabel implements Serializable {
    
    private static final String SALUDO = "Hola ";
    private String nombre;
    private boolean propiedad1;
    private int propiedad2;
    private float propiedad3;
    private Color propiedad4;
    private Font propiedad5;
    private File propiedad6;
    
    
    public PrimerComponente() {
        super();
        setText(SALUDO);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        setText(SALUDO+nombre);
    }

    public boolean isPropiedad1() {
        return propiedad1;
    }

    public void setPropiedad1(boolean propiedad1) {
        this.propiedad1 = propiedad1;
    }

        
    public int getPropiedad2() {
        return propiedad2;
    }

    public void setPropiedad2(int propiedad2) {
        this.propiedad2 = propiedad2;
    }

    public float getPropiedad3() {
        return propiedad3;
    }

    public void setPropiedad3(float propiedad3) {
        this.propiedad3 = propiedad3;
    }

    public Color getPropiedad4() {
        return propiedad4;
    }

    public void setPropiedad4(Color propiedad4) {
        this.propiedad4 = propiedad4;
    }

    public Font getPropiedad5() {
        return propiedad5;
    }

    public void setPropiedad5(Font propiedad5) {
        this.propiedad5 = propiedad5;
    }

    public File getPropiedad6() {
        return propiedad6;
    }

    public void setPropiedad6(File propiedad6) {
        this.propiedad6 = propiedad6;
    }

    

    
    
    
    
    
}

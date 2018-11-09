package Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Ainhoa
 */
public class BotonEjercicio extends JButton implements Serializable, ActionListener {

    
    private File fileElegido;
    //private File fichero = new File("C:\\Users\\aainh\\Desktop\\clicks.txt");
    private int contadorClicks = 0;

    public BotonEjercicio() {
        super();
        this.setText("Botón");
       addActionListener(this);
        
    }

    public File getFileElegido() {
        return fileElegido;
    }

    public void setFileElegido(File fileElegido) {
        this.fileElegido = fileElegido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date fecha = new Date();
        contadorClicks++;
        String cadenaAescribir = fecha + " " + " 1 click. " + "Contador de clicks: " + Integer.toString(contadorClicks) + " clicks\r\n";
        //comprobar que existe la carpeta anterior con .getParentFile();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileElegido.getAbsolutePath(), true));
            bw.write(cadenaAescribir);
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(BotonEjercicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

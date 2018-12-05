package modelo;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ainhoa
 */
public class CronometroJLabel extends JLabel implements Serializable {

    private Timer timer;
    private int horas, min, seg;
    private Llegada llegada;
    private String tiempoCrono;

    public Llegada getLlegada() {
        return llegada;
    }

    public void setLlegada(Llegada llegada) {
        this.llegada = llegada;
    }

    public CronometroJLabel() {
        setText("00:00:00");
        setFont(new Font("Dialog", 0, 48));
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String tiempo = tiempoCrono;
                String dor = JOptionPane.showInputDialog("Introduce el dorsal del corredor que ha llegado: ");
                int dorsal = Integer.parseInt(dor);

                if (llegada != null) {
                    llegada.ejecutarLlegada(dorsal, tiempo);
                }
            }
        });
    }

    public void addLlegada(Llegada llegada) {
        this.llegada = llegada;
    }

    public void pintarLabelTiempo() {
        tiempoCrono = (horas <= 9 ? "0" : "") + horas + ":" + (min <= 9 ? "0" : "") + min + ":" + (seg <= 9 ? "0" : "") + seg;
        setText(tiempoCrono);
    }

    public void iniciar() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ++seg;
                if (seg == 60) {
                    seg = 0;
                    ++min;
                    pintarLabelTiempo();
                }
                if (min == 60) {
                    min = 0;
                    ++horas;
                    pintarLabelTiempo();
                }

                pintarLabelTiempo();
            }
        }, 0, 1000);

    }

    public void parar() {
        timer.cancel();
        horas = 0;
        min = 0;
        seg = 0;
        pintarLabelTiempo();
    }

}

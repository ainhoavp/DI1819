package Temporizador;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Ainhoa
 */
public class TemporizadorPrueba extends JLabel implements Serializable {

    private int segundos;

    private CuentaAtrasFinalizadaListener listener; //interface que creamos para completar el código. Esto siempre es null.

    public TemporizadorPrueba() {
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void addCuentaAtrasFinalizadaListener(CuentaAtrasFinalizadaListener listener) {
        this.listener = listener;
    }

    public void start(CuentaAtrasFinalizadaListener listener) {
        setText(Integer.toString(segundos));
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (segundos >= 0) {
                    setText(Integer.toString(segundos--));
                } else {
                    setText("Fin cuenta atrás");
                    cancel();
                    //Todo: llamar a un código
                    if (listener != null) {
                        listener.ejecutar();
                    }
                }
            }

        }, 0, 1000);

    }

}

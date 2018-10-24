package Modelo;

/**
 *
 * @author Ainhoa
 */
public class HiloPersona extends Thread {

    private Jardin j;
    private boolean entra = false;

    public HiloPersona(String nombreHilo, Jardin j) {
        this.setName(nombreHilo);
        this.j = j;
        entra = ((int) ((Math.random()) * 2) == 0) ? false : true;
    }

    @Override
    public void run() {

        //synchronized evita que dos hilos accedan al metodo o lo que esté synchronized y hasta que no acaba el metodo synchronized no se desbloquea para
        //el siguiente hilo.
        synchronized (j) {
            if (entra) {
                System.out.println(Thread.currentThread().getName() + " entra en el jardín.");
            } else {
                System.out.println(Thread.currentThread().getName() + " sale del jardín.");
            }

            j.IOPersona(entra);
            System.out.println("Hay " + j.getContador() + " personas en el jardín");
        }

    }

}

package Modelo;

/**
 *
 * @author Ainhoa
 */
public class HiloTerminal extends Thread {

    private String nombreHilo;
    Servidor servidorRC = new Servidor();

    public HiloTerminal(String nombreHilo, Servidor s) {
        this.setName(nombreHilo);
        this.servidorRC = s;
    }

    @Override
    public void run() {
        synchronized (servidorRC) {
            servidorRC.incrementaren1Contador();
            System.out.println("El hilo "+Thread.currentThread().getName()+" ha accedido al servidor");
            //Thread.currentThread() devuelve el hilo en ejecución y .getName el nombre de ese hilo.
            System.out.println("ContadorAccesos: "+servidorRC.getContadorAccesos());
        }
    }

}

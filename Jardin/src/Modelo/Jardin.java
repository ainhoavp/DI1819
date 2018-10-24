package Modelo;

/**
 *
 * @author Ainhoa
 */
public class Jardin {

    private int contador;

    public Jardin(int cont) {
        this.contador = cont;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void IOPersona(boolean entra) {
        if (entra) {
            contador++;
        } else {
            contador--;
        }
    }

}

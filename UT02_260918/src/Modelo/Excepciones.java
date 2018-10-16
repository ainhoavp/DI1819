
package Modelo;

/**
 *
 * @author Ainhoa
 */
public class Excepciones {
    
    public static class CarpetaVacia extends Exception{

        public CarpetaVacia(String message) {
            super(message);
        }
    
}
    
    public static class NoEsDirectorio extends Exception{

        public NoEsDirectorio(String message) {
            super(message);
        }

        
}
    
    
    public static class LaRutaNoExiste extends Exception{

        public LaRutaNoExiste(String message) {
            super(message);
        }
        
        
    }
    
    
    public static class ElDirectorioYaExiste extends Exception{

        public ElDirectorioYaExiste(String message) {
            super(message);
        }
        
    }
    
    
    
    
}

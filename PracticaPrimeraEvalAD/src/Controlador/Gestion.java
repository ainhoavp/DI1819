package Controlador;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Ainhoa
 */
public class Gestion {

    private long total;
    private long libre;
    private File file;
    int contadorElementosBorrados = 0;
    File[] arrayFicherosUnidad = null;
    List<File> listaFicheros = new ArrayList();
    List<File> listaFicherosRecursivo = new ArrayList();
    List<File> listaParaMetodoRecursivo = new ArrayList();
    File[] directorios;

    public List<File> getListaParaMetodoRecursivo() {
        return listaParaMetodoRecursivo;
    }

    public void setListaParaMetodoRecursivo(List<File> listaParaMetodoRecursivo) {
        this.listaParaMetodoRecursivo = listaParaMetodoRecursivo;
    }

    public File[] getDirectorios() {
        return directorios;
    }

    public void setDirectorios(File[] directorios) {
        this.directorios = directorios;
    }

    public List<File> getListaFicherosRecursivo() {
        return listaFicherosRecursivo;
    }

    public void setListaFicherosRecursivo(List<File> listaFicherosRecursivo) {
        this.listaFicherosRecursivo = listaFicherosRecursivo;
    }

    public List<File> getListaFicheros() {
        return listaFicheros;
    }

    public void setListaFicheros(List<File> listaFicheros) {
        this.listaFicheros = listaFicheros;
    }

    public File[] getArrayFicherosUnidad() {
        return arrayFicherosUnidad;
    }

    public void setArrayFicherosUnidad(File[] arrayFicherosUnidad) {
        this.arrayFicherosUnidad = arrayFicherosUnidad;
    }

    public int getContadorDirectoriosBorrados() {
        return contadorElementosBorrados;
    }

    public void setContadorDirectoriosBorrados(int contadorDirectoriosBorrados) {
        this.contadorElementosBorrados = contadorDirectoriosBorrados;
    }

    public long getTotal() {
        return total;
    }

    public long getLibre() {
        return libre;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    //_______________________________________MÉTODOS____________________________________________________________

    public int emptyTrash() {
        File papelera = new File("C://$Recycle.Bin//S-1-5-21-3924842705-2844399566-1741625739-1001");
        File[] archivosPapelera = papelera.listFiles();
        int contadorBorradosPapelera = 0;
        if (archivosPapelera.length > 1) {
            for (File file1 : archivosPapelera) {
                file1.delete();
                contadorBorradosPapelera++;
            }
        }
        return contadorBorradosPapelera / 2;
    }

    public void checkDiskSpace() {
        File fileAbsoluta = new File("C://");
        this.total = fileAbsoluta.getTotalSpace();
        this.libre = fileAbsoluta.getFreeSpace();
    }

    public int confirmDeleteEmptyDirectories(int resultado) {
        if (resultado == 0) {
            contadorElementosBorrados = 0;
            try {
                deleteEmptyDirectoriesR(file);
            } catch (IOException ex) {
                Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;

    }

    /**
     * Lista SOLO los ficheros de la unidad que le pasas por parámetro
     * @param fileSelectU
     * @return File[] con los ficheros de la unidad.
     */
    public File[] scanUnity(File fileSelectU) {
        if (fileSelectU != null) {
            arrayFicherosUnidad = file.listFiles();
        }
        return arrayFicherosUnidad;

    }

    /**
     * Borra directorios vacios 
     * @param fileDelete
     * @return total directorios borrados
     * @throws IOException
     */
    public int deleteEmptyDirectoriesR(File fileDelete) throws IOException {
        File[] arrayFicheros = fileDelete.listFiles();
        if (arrayFicheros != null) {
            for (File fichero : arrayFicheros) {
                if (fichero.isDirectory() && fichero.listFiles().length != 0) {
                    deleteEmptyDirectoriesR(fichero);
                }
                if (fichero.isDirectory() && fichero.listFiles().length == 0) {
                    fichero.delete();
                    contadorElementosBorrados++;
                }
            }
        }
        return contadorElementosBorrados;
    }

    public int selectUnity(Component PantallaPrincipal) {
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = jc.showOpenDialog(PantallaPrincipal);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            file = jc.getSelectedFile();
        }
        return seleccion;

    }

    public int deleteBrowsingHistory() {

        //para chrome sabiedo ruta.
        file = new File("C:/Users/aainh/AppData/Local/Google/Chrome/User Data/Default/Cache");
        int contadorBorrados = 0;
        File[] ficherosDentroDelDirectorioCache = file.listFiles();
        for (File ficheroCache : ficherosDentroDelDirectorioCache) {
            ficheroCache.delete();
            contadorBorrados++;
        }
        return contadorBorrados;
    }
    /**
     * Crea una lista (listaParaMetodoRecursivo) con los ficheros de la ruta
     * @param ruta 
     */

    public void listarRecursivo(String ruta) {
        file = new File(ruta);
        File[] arrayLocal = file.listFiles();
        if (arrayLocal != null) {

            for (File fichero : arrayLocal) {
                if (fichero.isDirectory()) {
                    listarRecursivo(fichero.getAbsolutePath());
                } else {
                    listaParaMetodoRecursivo.add(fichero);
                }
            }
        }
    }

    public List<File> convertirArrayEnList() {
        listaFicheros = Arrays.asList(arrayFicherosUnidad);
        return listaFicheros;

    }

    public List<File> convertirArrayEnListRecursiva() {
        listaFicherosRecursivo = Arrays.asList(directorios);
        return listaFicherosRecursivo;

    }

}

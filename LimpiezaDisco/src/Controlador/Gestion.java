package Controlador;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Ainhoa
 */
public class Gestion {

    File file;
    List<File> listForRecursiveMethod = new ArrayList();
    List<File> listToBeDeletedBySize = new ArrayList();
    long totalSpace;
    long freeSpace;
    int emptyDirectoryCounterDeleted = 0;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<File> getListForRecursiveMethod() {
        return listForRecursiveMethod;
    }

    public void setListForRecursiveMethod(List<File> listaParaMetodoRecursivo) {
        this.listForRecursiveMethod = listaParaMetodoRecursivo;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long total) {
        this.totalSpace = total;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(long libre) {
        this.freeSpace = libre;
    }

    public int getEmptyDirectoryCounterDeleted() {
        return emptyDirectoryCounterDeleted;
    }

    public void setEmptyDirectoryCounterDeleted(int contadorDirectoriosVaciosBorrados) {
        this.emptyDirectoryCounterDeleted = contadorDirectoriosVaciosBorrados;
    }

    public List<File> getListToBeDeletedBySize() {
        return listToBeDeletedBySize;
    }

    public void setListToBeDeletedBySize(List<File> listaBorrarPorTamanio) {
        this.listToBeDeletedBySize = listaBorrarPorTamanio;
    }
    
    

    /**
     * Metodo que selecciona la unidad através de un file choose
     *
     * @param PantallaAplicacion
     * @return file elegido
     */
    public void selectUnity(Component PantallaAplicacion) {
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jc.showOpenDialog(PantallaAplicacion);
        this.file = jc.getSelectedFile();
    }

    /**
     * Lista recursivamente todos los archivos de la ruta seleccionada en el fileChooser
     * @param ruta 
     */
    public void listRecursively(String ruta) {
        File fileRecursivo = new File(ruta);
        File[] arrayLocal = fileRecursivo.listFiles();
        if (arrayLocal != null) {

            for (File fichero : arrayLocal) {
                if (fichero.isDirectory()) {
                    listForRecursiveMethod.add(fichero);
                    listRecursively(fichero.getAbsolutePath());
                } else {
                    if (fichero.isDirectory() || fichero.isFile()) {
                        listForRecursiveMethod.add(fichero);
                    }
                }
            }
        }
    }

    /**
     * Método para saber el espacio total y disponible del disco.
     */
    public void checkDiskSpace() {
        File fileRoot = new File("C://");
        this.totalSpace = fileRoot.getTotalSpace();
        this.freeSpace = fileRoot.getFreeSpace();
    }

    /**
     * Elimina los directorios vacíos de una ruta recursivamente.
     * @param ruta 
     */
    public void deleteEmptyDirectoriesR(String ruta) {
        File fileRuta = new File(ruta);
        File[] arrayFicheros = fileRuta.listFiles();
        if (arrayFicheros != null) {
            for (File fichero : arrayFicheros) {
                if (fichero.isDirectory() && fichero.listFiles().length != 0) {
                    deleteEmptyDirectoriesR(fichero.getAbsolutePath());
                }
                if (fichero.isDirectory() && fichero.listFiles().length == 0) {
                    fichero.delete();
                    emptyDirectoryCounterDeleted++;
                }
            }
        }
    }

    /**
     * Vacía la papelera de reciclaje
     * @return 
     */
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

    
    /**
     * Borra imagenes
     * @return devuelve un int con el número de imagenes borradas
     */
    public int deleteImages() {
        int contadorImagenesBorradas = 0;
        for (Iterator<File> iterator = listForRecursiveMethod.iterator(); iterator.hasNext();) {
            File fileBorrar = iterator.next();
            if (fileBorrar.isFile() && fileBorrar.getAbsolutePath().toLowerCase().endsWith(".jpg") || fileBorrar.getAbsolutePath().toLowerCase().endsWith(".png")) {
                fileBorrar.delete();
                contadorImagenesBorradas++;
                iterator.remove();
            }
        }
        return contadorImagenesBorradas;
    }

    /**
     * Borra videos
     * @return devuelve un int con el número de videos borrados
     */
    public int deleteVideos() {
        int contadorVideosBorrados = 0;
        for (Iterator<File> iterator = listForRecursiveMethod.iterator(); iterator.hasNext();) {
            File fileBorrar = iterator.next();
            if (fileBorrar.isFile() && fileBorrar.getAbsolutePath().toLowerCase().endsWith(".avi") || fileBorrar.getAbsolutePath().toLowerCase().endsWith(".mov")) {
                fileBorrar.delete();
                contadorVideosBorrados++;
                iterator.remove();
            }
        }
        return contadorVideosBorrados;
    }

    /**
     * Borra el historial de navegación (Opera o Chrome) listando c:\\ y buscando la ruta en la que se encuetran los archivos caché
     * @param seleccion pide por parámetro la seleccion del comboBox.
     * @return int con el numero de archivos caché borrados.
     */
    public int deleteBrowsingHistory(int seleccion) {
        listRecursively("c:\\");
        int contador = 0;

        switch (seleccion) {
            case 0:
                for (File fileParaBorrar : listForRecursiveMethod) {
                    if (fileParaBorrar.isDirectory() && fileParaBorrar.toString().toLowerCase().contains("opera") && fileParaBorrar.toString().toLowerCase().endsWith("cache") && !fileParaBorrar.toString().toLowerCase().contains("roaming")) {
                        File[] borrar = fileParaBorrar.listFiles();
                        for (File fileBorrar : borrar) {
                            fileBorrar.delete();
                            contador++;
                        }
                    }
                }
            case 1:
                for (File fileParaBorrar : listForRecursiveMethod) {
                    if (fileParaBorrar.isDirectory() && fileParaBorrar.toString().toLowerCase().contains("chrome") && fileParaBorrar.toString().toLowerCase().endsWith("cache") && !fileParaBorrar.toString().toLowerCase().contains("script")) {
                        File[] borrar = fileParaBorrar.listFiles();
                        for (File fileBorrar : borrar) {
                            fileBorrar.delete();
                            contador++;
                        }
                    }
                }
            default:
                return contador;
        }
    }

    /**
     * Escanea la ruta elegida por el fileChooser para filtrar los archivos por tamaños
     * @param seleccionTamanio necesita un int con la seleccion del comboBox mayor 1gb...
     */
    public void scanFilesBySize(int seleccionTamanio) {
        
        switch (seleccionTamanio) {
            case 0:
                for (File lessThan1Gb : listForRecursiveMethod) {
                    double size = (double) (lessThan1Gb.length() / 1024) / 1024; //en mb
                    if (lessThan1Gb.isFile() && size < 1024) {
                        listToBeDeletedBySize.add(lessThan1Gb);
                    }
                }
            case 1:
                for (File between1and10 : listForRecursiveMethod) {
                    double size = (double) (between1and10.length() / 1024) / 1024; //en mb
                    if (between1and10.isFile() && size >= 1024 && size < (1024 * 10)) {
                        listToBeDeletedBySize.add(between1and10);
                    }
                }
            case 2:
                for (File greaterThan10 : listForRecursiveMethod) {
                    double size = (double) (greaterThan10.length() / 1024) / 1024; //en mb
                    if (greaterThan10.isFile() && size >= (1024 * 10)) {
                        listToBeDeletedBySize.add(greaterThan10);
                    }
                }
        }
    }

    
    
    
    
    
    
}

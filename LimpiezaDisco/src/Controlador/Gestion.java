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
    List<File> listaParaMetodoRecursivo = new ArrayList();
    List<File> listaBorrarPorTamanio = new ArrayList();
    long total;
    long libre;
    int contadorDirectoriosVaciosBorrados = 0;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<File> getListaParaMetodoRecursivo() {
        return listaParaMetodoRecursivo;
    }

    public void setListaParaMetodoRecursivo(List<File> listaParaMetodoRecursivo) {
        this.listaParaMetodoRecursivo = listaParaMetodoRecursivo;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getLibre() {
        return libre;
    }

    public void setLibre(long libre) {
        this.libre = libre;
    }

    public int getContadorDirectoriosVaciosBorrados() {
        return contadorDirectoriosVaciosBorrados;
    }

    public void setContadorDirectoriosVaciosBorrados(int contadorDirectoriosVaciosBorrados) {
        this.contadorDirectoriosVaciosBorrados = contadorDirectoriosVaciosBorrados;
    }

    public List<File> getListaBorrarPorTamanio() {
        return listaBorrarPorTamanio;
    }

    public void setListaBorrarPorTamanio(List<File> listaBorrarPorTamanio) {
        this.listaBorrarPorTamanio = listaBorrarPorTamanio;
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

    public void listarRecursivo(String ruta) {
        File fileRecursivo = new File(ruta);
        File[] arrayLocal = fileRecursivo.listFiles();
        if (arrayLocal != null) {

            for (File fichero : arrayLocal) {
                if (fichero.isDirectory()) {
                    listaParaMetodoRecursivo.add(fichero);
                    listarRecursivo(fichero.getAbsolutePath());
                } else {
                    if (fichero.isDirectory() || fichero.isFile()) {
                        listaParaMetodoRecursivo.add(fichero);
                    }
                }
            }
        }
    }

    public void checkDiskSpace() {
        File fileRoot = new File("C://");
        this.total = fileRoot.getTotalSpace();
        this.libre = fileRoot.getFreeSpace();
    }

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
                    contadorDirectoriosVaciosBorrados++;
                }
            }
        }
    }

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

    public int deleteImages() {
        int contadorImagenesBorradas = 0;
        for (Iterator<File> iterator = listaParaMetodoRecursivo.iterator(); iterator.hasNext();) {
            File fileBorrar = iterator.next();
            if (fileBorrar.isFile() && fileBorrar.getAbsolutePath().toLowerCase().endsWith(".jpg") || fileBorrar.getAbsolutePath().toLowerCase().endsWith(".png")) {
                fileBorrar.delete();
                contadorImagenesBorradas++;
                iterator.remove();
            }
        }
        return contadorImagenesBorradas;
    }

    public int deleteVideos() {
        int contadorVideosBorrados = 0;
        for (Iterator<File> iterator = listaParaMetodoRecursivo.iterator(); iterator.hasNext();) {
            File fileBorrar = iterator.next();
            if (fileBorrar.isFile() && fileBorrar.getAbsolutePath().toLowerCase().endsWith(".avi") || fileBorrar.getAbsolutePath().toLowerCase().endsWith(".mov")) {
                fileBorrar.delete();
                contadorVideosBorrados++;
                iterator.remove();
            }
        }
        return contadorVideosBorrados;
    }

    public int deleteBrowsingHistory(int seleccion) {
        listarRecursivo("c:\\");
        int contador = 0;

        switch (seleccion) {
            case 0:
                for (File fileParaBorrar : listaParaMetodoRecursivo) {
                    if (fileParaBorrar.isDirectory() && fileParaBorrar.toString().toLowerCase().contains("opera") && fileParaBorrar.toString().toLowerCase().endsWith("cache") && !fileParaBorrar.toString().toLowerCase().contains("roaming")) {
                        File[] borrar = fileParaBorrar.listFiles();
                        for (File fileBorrar : borrar) {
                            fileBorrar.delete();
                            contador++;
                        }
                    }
                }
            case 1:
                for (File fileParaBorrar : listaParaMetodoRecursivo) {
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

    public void scanFilesBySize(int seleccionTamanio) {
        
        switch (seleccionTamanio) {
            case 0:
                for (File menor1Gb : listaParaMetodoRecursivo) {
                    double tamanio = (double) (menor1Gb.length() / 1024) / 1024; //en mb
                    if (tamanio < 1024) {
                        listaBorrarPorTamanio.add(menor1Gb);
                    }
                }
            case 1:
                for (File between1and10 : listaParaMetodoRecursivo) {
                    double size = (double) (between1and10.length() / 1024) / 1024; //en mb
                    if (size >= 1024 && size <= (1024 * 10)) {
                        listaBorrarPorTamanio.add(between1and10);
                    }
                }
            case 2:
                for (File greaterThan10 : listaParaMetodoRecursivo) {
                    double size = (double) (greaterThan10.length() / 1024) / 1024; //en mb
                    if (size > (1024 * 10)) {
                        listaBorrarPorTamanio.add(greaterThan10);
                    }
                }
        }
    }

}

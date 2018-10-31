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
                    listarRecursivo(fichero.getAbsolutePath());
                } else {
                    listaParaMetodoRecursivo.add(fichero);
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

    public int deleteBrowsingHistory(int seleccion) {
        File file = null;
        if (seleccion == 0) {
            file = new File("C:/Users/aainh/AppData/Local/Google/Chrome/User Data/Default/Cache");
        } else{
            if(seleccion == 1){
                file = new File("C:\\Users\\aainh\\AppData\\Local\\Opera Software\\Opera Stable\\Cache");
            }}
        int contadorBorrados = 0;
        File[] ficherosDentroDelDirectorioCache = file.listFiles();
        for (File ficheroCache : ficherosDentroDelDirectorioCache) {
            ficheroCache.delete();
            contadorBorrados++;
        }
        return contadorBorrados;
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

}

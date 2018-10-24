package Controlador;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Ainhoa
 */
public class Gestion {

    private long total;
    private long libre;
    private File file;

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

    public int deleteEmptyDirectories(int resultado) {
        int contadorDirectoriosBorrados = 0;
        if (resultado == 0) {
            File[] arrayFiles = file.listFiles();
            for (File arrayFile : arrayFiles) {
                if (arrayFile.isDirectory()) {
                    String[] directoriosDentroDirectorio = arrayFile.list();
                    if (directoriosDentroDirectorio.length == 0) {
                        arrayFile.delete();
                        contadorDirectoriosBorrados++;
                    }
                }
            }
        } else {
            return contadorDirectoriosBorrados;
        }
        return contadorDirectoriosBorrados;

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

    public File[] listarRecursivo(String ruta) {
        file = new File(ruta);

        File[] directorios = file.listFiles();

        if (directorios != null) {

            for (int i = 0; i < directorios.length; i++) {
                System.out.println(directorios[i].getName());
                if (directorios[i].isDirectory()) {
                    System.out.println(directorios[i].toString());
                    listarRecursivo(directorios[i].getAbsolutePath());
                }
                if (directorios[i].isFile()) {
                    System.out.println("Esto es un fichero: " + directorios[i].toString());
                }
            }
        }
        return directorios;
    }
}

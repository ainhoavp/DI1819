package Modelo;

import java.io.File;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ainhoa
 */
public class MiTablaPorTamanio extends AbstractTableModel {

    private final String[] columnas = {"Archivo", "Tamaño"};
    private List<File> listaBorrarPorTamanio;

    public MiTablaPorTamanio(List<File> listaArchivosEscaneados) {
        this.listaBorrarPorTamanio = listaArchivosEscaneados;
    }

    @Override
    public int getRowCount() {
        return listaBorrarPorTamanio.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaBorrarPorTamanio.get(rowIndex).getAbsolutePath();
            case 1:
                double tamanio = (double)(listaBorrarPorTamanio.get(rowIndex).length()/1024)/1024;
                return tamanio;
        }
        return null;

    }
}

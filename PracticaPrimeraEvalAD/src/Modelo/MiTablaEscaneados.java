package Modelo;

import java.io.File;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ainhoa
 */
public class MiTablaEscaneados extends AbstractTableModel {

    private final String[] columnas = {"Archivo"};
    private List<File> listaArchivosEscaneados;

    public MiTablaEscaneados(List<File> listaArchivosEscaneados) {
        this.listaArchivosEscaneados = listaArchivosEscaneados;
    }

    @Override
    public int getRowCount() {
        return listaArchivosEscaneados.size();
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
                return listaArchivosEscaneados.get(rowIndex).getAbsolutePath();
        }
        return null;

    }
}

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
    private List<File> listaArchivosUnidadSeleccionada;

    public MiTablaEscaneados(List<File> listaArchivosEscaneados) {
        this.listaArchivosUnidadSeleccionada = listaArchivosEscaneados;
    }

    @Override
    public int getRowCount() {
        return listaArchivosUnidadSeleccionada.size();
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
                return listaArchivosUnidadSeleccionada.get(rowIndex).getAbsolutePath();
        }
        return null;

    }
}

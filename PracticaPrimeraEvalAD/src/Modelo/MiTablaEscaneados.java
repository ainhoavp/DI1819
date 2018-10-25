package Modelo;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ainhoa
 */
public class MiTablaEscaneados extends AbstractTableModel {

    private final String[] columnas = {"Archivo"};
    private ArrayList<File> listaArchivosEscaneados;

    public MiTablaEscaneados(ArrayList<File> listaArchivosEscaneados) {
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
        return listaArchivosEscaneados.get(rowIndex).getAbsolutePath();
    }

}

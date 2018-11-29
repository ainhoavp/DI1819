package Modelo;


import java.io.Serializable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ainhoa
 */
public class MiTablaCorredoresCarrera extends AbstractTableModel implements Serializable {

    private final String[] columnas = {"Nombre", "Apellidos", "DNI", "Dirección", "F.nac", "Tel", "Dorsal"};
    private final List<CorredorCarrera> listaCorredoresCarrera;

    public MiTablaCorredoresCarrera(List<CorredorCarrera> c) {
        this.listaCorredoresCarrera = c;
    }

    @Override
    //indicamos cuantas filas va a tener la tabla que, obviamente, será el taño de la lista.
    public int getRowCount() {
        return listaCorredoresCarrera.size();
    }

    @Override
    //indicamos el número de columnas que tendrá la tabla, tamaño del array que hayamos creado.
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    //asignar valores a las celdas para que sepa en que posicion tiene que meter cada dato
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return listaCorredoresCarrera.get(rowIndex).getCorredor().getNombre();
            case 1:
                return listaCorredoresCarrera.get(rowIndex).getCorredor().getApellido();
            case 2:
                return listaCorredoresCarrera.get(rowIndex).getCorredor().getDni();
            case 3:
                return listaCorredoresCarrera.get(rowIndex).getCorredor().getDireccion();
            case 4:
                return listaCorredoresCarrera.get(rowIndex).getCorredor().getfNac().toString();
            case 5:
                return listaCorredoresCarrera.get(rowIndex).getCorredor().getTelefono();
            case 6:
                return listaCorredoresCarrera.get(rowIndex).getDorsal();
        }
        return null;
    }

}

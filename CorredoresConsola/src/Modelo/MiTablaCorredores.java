package Modelo;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ainhoa
 */
public class MiTablaCorredores extends AbstractTableModel implements Serializable{

    private final String[] columnas = {"Nombre", "Apellidos", "DNI", "Dirección", "F.nac", "Tel"};
    private final List<Corredor> listaCorredoresTabla;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public MiTablaCorredores(List<Corredor> c) {
        this.listaCorredoresTabla = c;
    }

    @Override
    //indicamos cuantas filas va a tener la tabla que, obviamente, será el taño de la lista.
    public int getRowCount() {
        return listaCorredoresTabla.size();
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
                return listaCorredoresTabla.get(rowIndex).getNombre();
            case 1:
                return listaCorredoresTabla.get(rowIndex).getApellido();
            case 2:
                return listaCorredoresTabla.get(rowIndex).getDni();
            case 3:
                return listaCorredoresTabla.get(rowIndex).getDireccion();
            case 4:
                String fecha = sdf.format(listaCorredoresTabla.get(rowIndex).getfNac());
                return fecha;
            case 5:
                return listaCorredoresTabla.get(rowIndex).getTelefono();
        }
        return null;
    }

}

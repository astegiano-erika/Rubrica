package frontend;

import backend.Persona;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class RubricaTable extends AbstractTableModel {

    private Vector<Persona> elenco;
    private final String[] columns = {"Nome", "Cognome", "Telefono"};

    public RubricaTable(Vector<Persona> elenco) {
        this.elenco = elenco;
    }

    @Override
    public int getRowCount() {
        return elenco.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = elenco.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> p.getNome();
            case 1 -> p.getCognome();
            case 2 -> p.getTelefono();
            default -> "";
        };
    }

    public void refresh(Vector<Persona> newData) {
        this.elenco = newData;
        fireTableDataChanged();  //di libreria per avvisare modifica contenuto
    }
}

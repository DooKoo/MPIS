import javax.swing.table.AbstractTableModel;
import java.util.*;

public class TableModel extends AbstractTableModel {
    private LinkedList<Research> ListOfResearchs;

    public TableModel(Integer id) {
        ListOfResearchs = Main.MBase.getResearchsOfPatient(id);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return ListOfResearchs.get(rowIndex).getId();
            case 1:
                return ListOfResearchs.get(rowIndex).getTypeOfResearch();
            case 2:
                return ListOfResearchs.get(rowIndex).getDateOfResearch();
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return ListOfResearchs.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Тип";
            case 2:
                return "Дата";
            default:
                return null;
        }
    }

    public Research getResearch(int id){return ListOfResearchs.get(id);}
}

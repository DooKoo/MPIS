import java.util.LinkedList;

/**
 * Created by Illya on 01.07.2014.
 * Class that consist main logic methods;
 */
public class DataBaseCore {
    private LinkedList<Patient> PatientsTable;
    private LinkedList<Research> ResearchsTable;

    DataBaseCore() {
        PatientsTable = new LinkedList<Patient>();
        ResearchsTable = new LinkedList<Research>();
    }

    public Patient getPatient(int index) {
        return PatientsTable.get(index);
    }

    public Research getResearch(int index) {
        return ResearchsTable.get(index);
    }

}

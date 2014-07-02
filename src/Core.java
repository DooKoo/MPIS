import com.sun.javafx.scene.layout.region.Margins;

import java.util.HashMap;

/**
 * Created by Illya on 01.07.2014.
 * Class that consist main logic methods;
 */
public class Core {
    private HashMap<Long, Patient> MainTable;
    private Long Count;

    public HashMap<Long, Patient> getMainTable() {
        return MainTable;
    }

    Core()
    {
        MainTable = new HashMap<Long, Patient>();
        Count = new Long(0);
    }

    public void addPatient(Patient newPatient)
    {
        MainTable.put(Count, newPatient);
        Count++;
    }

    public HashMap<Long, Patient> getPatientsWithName(String name)
    {
        Long count = new Long(0);
        HashMap<Long, Patient> newTable = new HashMap<Long, Patient>();
        for (Long i = new Long(0); i < Count; i++) {
            MainTable.get(i);
        }
        return newTable;
    }
}

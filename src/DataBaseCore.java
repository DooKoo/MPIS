import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.util.LinkedList;

public class DataBaseCore{
    private Database MainDataBase;
    private Table PatientTable;
    private Table ResearchTable;

    private LinkedList<Patient> Patients;

    DataBaseCore(String path) {
        try {
            MainDataBase = DatabaseBuilder.open(new File(path));
            PatientTable = MainDataBase.getTable("Patients");
            ResearchTable = MainDataBase.getTable("Researchs");
            Patients = new LinkedList<Patient>();
            for(Row item : PatientTable)
            {
                Patients.add(new Patient((Integer) item.get("Id"), item.get("NameOfPatient").toString(), (Integer) item.get("YearOfBirthday"), toSex(item.get("Sex").toString())));
            }
            System.out.println("All fine");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private Patient.Sex toSex(String _inp)
    {
        if(_inp.equals("ч"))
            return Patient.Sex.Male;
        else if (_inp.equals("ж"))
            return Patient.Sex.Female;
        else
            return Patient.Sex.None;
    }

    public LinkedList<Patient> getPatientTable() {
        return Patients;
    }
}

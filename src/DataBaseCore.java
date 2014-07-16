import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

import java.io.File;

public class DataBaseCore {
    private Database MainDataBase;
    private Table PatientTable;
    private Table ResearchTable;

    DataBaseCore(String path) {
        try {
            MainDataBase = DatabaseBuilder.open(new File(path));
            PatientTable = MainDataBase.getTable("Patients");
            ResearchTable = MainDataBase.getTable("Researchs");
            System.out.println("All fine");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}

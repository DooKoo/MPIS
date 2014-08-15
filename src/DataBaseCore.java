import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.util.LinkedList;

public class DataBaseCore {
    private Database MainDataBase;
    private Table PatientTable;
    private Table ResearchTable;

    DataBaseCore(String path) {
        try {
            MainDataBase = DatabaseBuilder.open(new File(path));
            PatientTable = MainDataBase.getTable("Patients");
            ResearchTable = MainDataBase.getTable("Researchs");
        } catch (Exception e) {
            new AlertWindow(e.getMessage());
        }
    }

    private Patient.Sex toSex(String _inp) {
        if (_inp.equals("ч") || _inp.equals("Чоловік"))
            return Patient.Sex.MALE;
        else if (_inp.equals("ж") || _inp.equals("Жінка"))
            return Patient.Sex.FEMALE;
        else
            return Patient.Sex.NONE;
    }

    public void addPatient(Patient newPatient) {
        try {
            PatientTable.addRow(
                    newPatient.getId(),
                    newPatient.getName(),
                    newPatient.getYearOfBirthday(),
                    newPatient.sexToString());
        } catch (Exception e) {
            new AlertWindow(e.getMessage());
        }
    }

    public int getPatientCount() {
        return PatientTable.getRowCount();
    }

    public int getResearchCount() {
        return ResearchTable.getRowCount();
    }

    public Patient getPatient(Patient patient) {
        Patient result = null;
        for (Row row : PatientTable) {
            Patient tmp = new Patient(
                    (Integer) row.get("Id"),
                    row.get("NameOfPatient").toString(),
                    (Integer) row.get("YearOfBirthday"),
                    toSex(row.get("Sex").toString()));

            if (tmp.equals(patient))
                result = tmp;
        }
        return result;
    }

    public LinkedList<Research> getResearchsOfPatient(Integer id) {
        LinkedList<Research> result = new LinkedList<Research>();
        for (Row row : ResearchTable) {
            if (Integer.parseInt(row.get("IdOfPatient").toString()) == id) {
                Research tmp = new Research();
                tmp.setIdOfPatient(id);
                tmp.setId(Integer.parseInt(row.get("Id").toString()));
                tmp.setTypeOfResearch(row.get("TypeOfResearch").toString());
                tmp.setDateOfResearch(row.get("DateOfResearch").toString());
                tmp.setColonoscopy(Boolean.getBoolean(row.get("Colonoscopy").toString()));
                tmp.setCito(row.get("Cito").toString());
                tmp.setCategory(row.get("Category").toString());
                tmp.setBiopsiya(row.get("Biopsiya").toString());
                tmp.setStacionar(Boolean.getBoolean(row.get("Stacionar").toString()));
                tmp.setDoctor(row.get("Doctor").toString());
                tmp.setFirst(Integer.parseInt(row.get("First").toString()));
                tmp.setFirst2(Integer.parseInt(row.get("First2").toString()));
                tmp.setFromWho(row.get("FromWho").toString());
                tmp.setFirstDiagnos(row.get("FirstDiagnos").toString());
                tmp.setLocalChanges(row.get("LocalChanges").toString());
                tmp.setManipulations(row.get("Manipulations").toString());
                tmp.setNextResearch(row.get("NextResearch").toString());
                tmp.setNotes(row.get("Notes").toString());
                tmp.setOpeartions(row.get("Operations").toString());
                tmp.setResult(row.get("Result").toString());
                result.add(tmp);
            }
        }
        return result;
    }

    public void addResearch(Research newResearch) {
        try {
            ResearchTable.addRow(
                    newResearch.getId(),
                    newResearch.getIdOfPatient(),
                    newResearch.getTypeOfResearch(),
                    newResearch.getDateOfResearch(),
                    newResearch.getFromWho(),
                    newResearch.getFirstDiagnos(),
                    newResearch.getResult(),
                    newResearch.getLocalChanges(),
                    newResearch.getDoctor(),
                    newResearch.isColonoscopy(),
                    newResearch.isStacionar(),
                    newResearch.getCategory(),
                    newResearch.getBiopsiya(),
                    newResearch.getManipulations(),
                    newResearch.getOpeartions(),
                    newResearch.getCito(),
                    newResearch.getFirst(),
                    newResearch.getFirst2(),
                    newResearch.getNextResearch(),
                    newResearch.getNotes());
        } catch (Exception e) {
            new AlertWindow(e.getMessage());
        }
    }

    public void clear(){
        try {
            for (Row row : ResearchTable) {
                ResearchTable.deleteRow(row);
            }
            for (Row row : PatientTable) {
                PatientTable.deleteRow(row);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


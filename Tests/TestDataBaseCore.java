import junit.framework.TestCase;
import java.util.LinkedList;

public class TestDataBaseCore extends TestCase {
    DataBaseCore testBaseCore = new DataBaseCore("E:/CodingForSoul/Git/MPIS/db/testdb.mdb");

    public void testGetResearchsOfPAtient(){
        LinkedList<Research> testList;
//        testBaseCore.addResearch(new Research(0,13,"testType","22.07.14"));
        testList = testBaseCore.getResearchsOfPatient(13);
        assertTrue(testList.get(0).getId().equals(1));
        assertTrue(testList.get(0).getIdOfPatient().equals(13));
        assertEquals("testType",testList.get(0).getTypeOfResearch());
        assertEquals("22.07.14", testList.get(0).getDateOfResearch());
        testBaseCore.clear();
    }

    public void testAddResearch(){
        //testBaseCore.addResearch(new Research(0,1,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(1,2,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(2,2,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(3,1,"test2","22.07.14"));
        assertEquals(4,testBaseCore.getResearchCount());
        testBaseCore.clear();
    }
    public void testGetPatient() {
        testBaseCore.addPatient(new Patient(0,"TestPatient0", 1978, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(1,"TestPatient1", 1979, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(2,"TestPatient2", 1976, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(3,"TestPatient3", 1977, Patient.Sex.MALE));
        assertEquals(new Patient(1,"TestPatient1", 1979, Patient.Sex.MALE), testBaseCore.getPatient(new Patient(7,"TestPatient1", 1979, Patient.Sex.MALE)));
        testBaseCore.clear();
    }
    public void testClear() {
        testBaseCore.addPatient(new Patient(0,"TestPatient0", 1978, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(1,"TestPatient1", 1979, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(2,"TestPatient2", 1976, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(3,"TestPatient3", 1977, Patient.Sex.MALE));
        //testBaseCore.addResearch(new Research(1,1,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(2,2,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(3,2,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(4,1,"test2","22.07.14"));
        testBaseCore.clear();
        assertEquals(0,testBaseCore.getPatientCount()+testBaseCore.getResearchCount());
        testBaseCore.clear();
    }
    public void testPatientCount() {
        assertEquals(0,testBaseCore.getPatientCount());
        testBaseCore.addPatient(new Patient(0,"TestPatient0", 1978, Patient.Sex.MALE));
        testBaseCore.addPatient(new Patient(1,"TestPatient1", 1979, Patient.Sex.MALE));
        assertEquals(2,testBaseCore.getPatientCount());
        testBaseCore.clear();
    }
    public void testResearchCount() {
        assertEquals(0,testBaseCore.getResearchCount());
        //testBaseCore.addResearch(new Research(1,1,"test2","22.07.14"));
        //testBaseCore.addResearch(new Research(2,2,"test2","22.07.14"));
        assertEquals(2,testBaseCore.getResearchCount());
        testBaseCore.clear();
    }
}

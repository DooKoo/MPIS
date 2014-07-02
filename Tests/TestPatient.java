import junit.framework.TestCase;

/**
 * Created by Illya on 02.07.2014.
 * Class that test Patient Class.
 */
public class TestPatient extends TestCase {
    public void testToString()
    {
        Patient testPatient = new Patient(1, "TestSurname I.I", 61, Patient.Sex.None);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Не визначено; Вік:61");
        testPatient.setSex("Male");
        testPatient.setAge(54);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Чоловіча; Вік:54");
        testPatient.setSex("Female");
        testPatient.setAge(34);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Жіноча; Вік:34");
    }
    public void testEquals()
    {
        Patient Test1 = new Patient(1, "TestName1", 61, Patient.Sex.Female);
        Patient Test2 = new Patient(1, "TestName1", 61, Patient.Sex.Female);
        assertTrue(Test1.equals(Test2));
        Test2.setAge(63);
        Test2.setSex("0");
        assertFalse(Test1.equals(Test2));
    }
    public void testAddResearch()
    {

    }
}

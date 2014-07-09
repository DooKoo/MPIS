import junit.framework.TestCase;
/**
 * Created by Illya on 02.07.2014.
 * Class that test Patient Class.
 */
public class TestPatient extends TestCase {
    public void testToString()
    {
        Patient testPatient = new Patient(1, "TestSurname I.I", 1961, Patient.Sex.None);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Не визначено; Рік народження:1961");
        testPatient.setSex("Male");
        testPatient.setYearOfBirthday(1954);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Чоловіча; Рік народження:1954");
        testPatient.setSex("Female");
        testPatient.setYearOfBirthday(1934);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Жіноча; Рік народження:1934");
    }
    public void testEquals()
    {
        Patient Test1 = new Patient(1, "TestName1", 1961, Patient.Sex.Female);
        Patient Test2 = new Patient(1, "TestName1", 1961, Patient.Sex.Female);
        assertTrue(Test1.equals(Test2));
        Test2.setYearOfBirthday(63);
        Test2.setSex("0");
        assertFalse(Test1.equals(Test2));
    }

    public void testSexToString()
    {
        Patient Test1 = new Patient(1, "TestName", 1966, Patient.Sex.Male);
        assertEquals(Test1.sexToString(), "Чоловіча");
        Test1.setSex("None");
        assertEquals(Test1.sexToString(), "Не визначено");
        Test1.setSex("Female");
        assertEquals(Test1.sexToString(), "Жіноча");
    }
}

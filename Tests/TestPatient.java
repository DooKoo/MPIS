import junit.framework.TestCase;

/**
 * Created by Illya on 02.07.2014.
 * Class that test Patient Class.
 */
public class TestPatient extends TestCase {
    public void testToString()
    {
        Patient testPatient = new Patient("TestSurname I.I", 61, new Byte("0"));
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Не визначено; Вік:61");
        testPatient.setSex(new Byte("1"));
        testPatient.setAge(54);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Чоловіча; Вік:54");
        testPatient.setSex(new Byte("2"));
        testPatient.setAge(34);
        assertEquals(testPatient.toString(), "Ім'я:TestSurname I.I; Стать:Жіноча; Вік:34");
    }
}

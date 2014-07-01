import java.util.Date;

/**
 * Created by Illya on 01.07.2014.
 */
public class Patient {
    private String Name;// Surname and initials.
    private Date DateOfBirthday;
    private Byte Sex;// 0-None, 1-Male, 2-Female.

    Patient(String _Name, Date _DateOfBirthday, Byte _Sex)
    {
        Name = _Name;
        DateOfBirthday = _DateOfBirthday;
        Sex = _Sex;
    }
}

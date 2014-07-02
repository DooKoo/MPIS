import java.util.Date;

/**
 * Created by Illya on 01.07.2014.
 */
public class Patient {
    private String Name;// Surname and initials.
    private Integer Age;
    private Byte Sex;// 0-None, 1-Male, 2-Female.

    Patient(String _Name, Integer _Age, Byte _Sex)
    {
        Name = _Name;
        Age = _Age;
        Sex = _Sex;
    }

    public String getName() {
        return Name;
    }

    public Integer getAge() {
        return Age;
    }

    public Byte getSex() {
        return Sex;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setSex(Byte sex) {
        Sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient)
            if ((Name == ((Patient) obj).getName()) &&
                    (Sex == ((Patient) obj).getSex()) &&
                    (Age == ((Patient) obj).getAge())) {
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        String _Sex;
        switch (Sex)
        {
            case 1:
                _Sex = "Чоловіча";
                break;
            case 2:
                _Sex = "Жіноча";
                break;
            default:
                _Sex = "Не визначено";
        }
        return "Ім'я:"+Name+"; Стать:"+_Sex+"; Вік:"+Age;
    }
}

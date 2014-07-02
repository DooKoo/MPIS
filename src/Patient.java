import java.util.ArrayList;

/**
 * Created by Illya on 01.07.2014.
 */
public class Patient {
    public enum Sex {None, Male, Female};
    private Integer Id;
    private String Name;// Surname and initials.
    private Integer Age;
    private Sex SexOfPatient;// 0-None, 1-Male, 2-Female.
    private ArrayList<Research> ResearchsOfPatient;

    Patient(Integer _Id, String _Name, Integer _Age, Sex _Sex)
    {
        Name = _Name;
        Age = _Age;
        SexOfPatient = _Sex;
        Id = _Id;
    }

    public void addResearch(Research research)
    {
        ResearchsOfPatient.add(research);
        research.setLinkToPatient(this);
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Integer getAge() {
        return Age;
    }

    public Sex getSex() {
        return SexOfPatient;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setSex(String sex)
    {
       if (sex.equals("None")) {
           SexOfPatient = Sex.None;
       }
       if (sex.equals("Male")){
           SexOfPatient=Sex.Male;
       }
       if (sex.equals("Female")) {
           SexOfPatient = Sex.Female;
       }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient)
            if ((Name.equals(((Patient) obj).getName())) && (SexOfPatient.equals(((Patient) obj).getSex()))
                    && (Age.equals(((Patient) obj).getAge())) && (Id.equals(((Patient) obj).getId()))) {
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        String _Sex;
        switch (SexOfPatient)
        {
            case Male:
                _Sex = "Чоловіча";
                break;
            case Female:
                _Sex = "Жіноча";
                break;
            default:
                _Sex = "Не визначено";
        }
        return "Ім'я:"+Name+"; Стать:"+_Sex+"; Вік:"+Age;
    }
}

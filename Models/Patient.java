public class Patient{
    public enum Sex {MALE, FEMALE, NONE}
    private int Id;
    private String Name;// Surname and initials.
    private Integer YearOfBirthday;
    private Sex SexOfPatient;// 0-NONE, 1-MALE, 2-FEMALE.

    Patient(Integer _Id, String _Name, Integer _YearOfBirthday, Sex _Sex)
    {
        Name = _Name;
        YearOfBirthday = _YearOfBirthday;
        SexOfPatient = _Sex;
        Id = _Id;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Integer getYearOfBirthday() {
        return YearOfBirthday;
    }

    public Sex getSex() {
        return SexOfPatient;
    }

    public void setYearOfBirthday(Integer yearOfBirthday) {
        YearOfBirthday = yearOfBirthday;
    }

    public void setSex(String sex)
    {
       if (sex.equals("NONE")) {
           SexOfPatient = Sex.NONE;
       }
       if (sex.equals("MALE")){
           SexOfPatient=Sex.MALE;
       }
       if (sex.equals("FEMALE")) {
           SexOfPatient = Sex.FEMALE;
       }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient)
            if ((Name.equals(((Patient) obj).getName())) && (SexOfPatient.equals(((Patient) obj).getSex()))
                    && (YearOfBirthday.equals(((Patient) obj).getYearOfBirthday()))) {
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        return "Ім'я:"+Name+"; Стать:"+sexToString()+"; Рік народження:"+ YearOfBirthday;
    }
    public String sexToString(){
        switch (SexOfPatient)
        {
            case MALE:
                return "Чоловік";
            case FEMALE:
                return "Жінка";
            default:
                return "Не визначено";
        }
    }
    public static Sex stringToSex(String sex)
    {
        if (sex.equals("Чоловік"))
            return Sex.MALE;
        else if (sex.equals("Жінка"))
            return Sex.FEMALE;
        else
            return Sex.NONE;
    }
}

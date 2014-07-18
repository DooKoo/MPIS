public class Patient {
    public enum Sex {None, Male, Female}
    private Integer Id;
    private String Name;// Surname and initials.
    private Integer YearOfBirthday;
    private Sex SexOfPatient;// 0-None, 1-Male, 2-Female.
  //  private ArrayList<Research> ResearchsOfPatient;

    Patient(Integer _Id, String _Name, Integer _YearOfBirthday, Sex _Sex)
    {
        Name = _Name;
        YearOfBirthday = _YearOfBirthday;
        SexOfPatient = _Sex;
        Id = _Id;
    }

   /* public void addResearch(Research research)
    {
        ResearchsOfPatient.add(research);
        research.setLinkToPatient(this);
    }*/

    public Integer getId() {
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

    /*public void setName(String name) {
        Name = name;
    }*/

    public void setYearOfBirthday(Integer yearOfBirthday) {
        YearOfBirthday = yearOfBirthday;
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
                    && (YearOfBirthday.equals(((Patient) obj).getYearOfBirthday())) && (Id.equals(((Patient) obj).getId()))) {
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
            case Male:
                return "Чоловік";
            case Female:
                return "Жінка";
            default:
                return "Не визначено";
        }
    }
    public static Sex stringToSex(String sex)
    {
        if (sex.equals("Чоловік"))
            return Sex.Male;
        else if (sex.equals("Жінка"))
            return Sex.Female;
        else
            return Sex.None;
    }

}

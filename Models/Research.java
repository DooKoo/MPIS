
public class Research {
    private int Id;
    private int IdOfPatient;
    private String TypeOfResearch;
    private String DateOfResearch;
    private String FromWho;// Who is send the patient;
    private String FirstDiagnos;
    private String Result;
    private String LocalChanges;
    private String Doctor;
    private boolean Colonoscopy;
    private boolean Stacionar;// True - stat in hospital, false- at home;
    private String Category;// default - "Ні";
    private String Biopsiya;// [1-10][кр]/(default))Ні;
    private String Manipulations;// default-"Ні";
    private String Opeartions;// default-"Ні";
    private String Cito;// time(default 0:00)
    private int First;
    private int First2;
    private String Notes;
    private String NextResearch;

    public Research(){}

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getFromWho() {
        return FromWho;
    }

    public void setFromWho(String fromWho) {
        FromWho = fromWho;
    }

    public String getFirstDiagnos() {
        return FirstDiagnos;
    }

    public void setFirstDiagnos(String firstDiagnos) {
        FirstDiagnos = firstDiagnos;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getLocalChanges() {
        return LocalChanges;
    }

    public void setLocalChanges(String localChanges) {
        LocalChanges = localChanges;
    }

    public String getDoctor() { return Doctor; }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public boolean isColonoscopy() {
        return Colonoscopy;
    }

    public void setColonoscopy(boolean colonoscopy) {
        Colonoscopy = colonoscopy;
    }

    public boolean isStacionar() {
        return Stacionar;
    }

    public void setStacionar(boolean stacionar) {
        Stacionar = stacionar;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getBiopsiya() {
        return Biopsiya;
    }

    public void setBiopsiya(String biopsiya) {
        Biopsiya = biopsiya;
    }

    public String getManipulations() {
        return Manipulations;
    }

    public void setManipulations(String manipulations) {
        Manipulations = manipulations;
    }

    public String getOpeartions() {
        return Opeartions;
    }

    public void setOpeartions(String opeartions) {
        Opeartions = opeartions;
    }

    public String getCito() {
        return Cito;
    }

    public void setCito(String cito) {
        Cito = cito;
    }

    public int getFirst() {
        return First;
    }

    public void setFirst(int first) {
        First = first;
    }

    public int getFirst2() {
        return First2;
    }

    public void setFirst2(int first2) {
        First2 = first2;
    }

    public String getNextResearch() {
        return NextResearch;
    }

    public void setNextResearch(String nextResearch) {
        NextResearch = nextResearch;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Integer getIdOfPatient() {
        return IdOfPatient;
    }

    public void setIdOfPatient(int idOfPatient) {
        IdOfPatient = idOfPatient;
    }

    public String getTypeOfResearch() {
        return TypeOfResearch;
    }

    public void setTypeOfResearch(String typeOfResearch) {
        TypeOfResearch = typeOfResearch;
    }

    public String getDateOfResearch() {
        return DateOfResearch;
    }

    public void setDateOfResearch(String dateOfResearch) {
        DateOfResearch = dateOfResearch;
    }
}

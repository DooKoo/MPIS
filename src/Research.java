import java.util.Date;

/**
 * Created by Illya on 03.07.2014.
 * Class that defined model Data about researching;
 */
public class Research {
    private Integer Id;
    private Date DateOfResearch;
    private Integer IdOfPatient;
    private Patient LinkToPatient;

    public Research(Integer id, Date dateOfResearch, Patient linkToPatient) {
        Id = id;
        DateOfResearch = dateOfResearch;
        setLinkToPatient(linkToPatient);
    }

    public void setLinkToPatient(Patient linkToPatient) {
        LinkToPatient = linkToPatient;
        IdOfPatient = linkToPatient.getId();
    }
}

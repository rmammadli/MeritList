package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class DoubtModel {

    private String textDoubtDescription;
    private Boolean boolStatus;

    public DoubtModel() {
    }

    public DoubtModel(String textDoubtDescription, Boolean boolStatus) {
        this.textDoubtDescription = textDoubtDescription;
        this.boolStatus = boolStatus;
    }

    public String getDoubtDescription() {
        return textDoubtDescription;
    }

    public void setDoubtDescription(String textDoubtDescription) {
        this.textDoubtDescription = textDoubtDescription;
    }

    public Boolean getStatus() {
        return boolStatus;
    }

    public void setStatus(Boolean boolStatus) {
        this.boolStatus = boolStatus;
    }
}

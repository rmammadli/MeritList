package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HelpModel {

    private String textHelpDescription;

    public HelpModel() {
    }

    public HelpModel(String textHelpDescription) {
        this.textHelpDescription = textHelpDescription;
    }

    public String getHelpDescription() {
        return textHelpDescription;
    }

    public void setHelpDescription(String textPracticeName) {
        this.textHelpDescription = textHelpDescription;
    }
}

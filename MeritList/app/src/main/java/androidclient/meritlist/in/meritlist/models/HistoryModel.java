package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HistoryModel {

    private String textPracticeName, textStatus;

    public HistoryModel() {
    }

    public HistoryModel(String textPracticeName, String textStatus) {
        this.textPracticeName = textPracticeName;
        this.textStatus = textStatus;
    }

    public String getPracticeName() {
        return textPracticeName;
    }

    public void setPracticeName(String textPracticeName) {
        this.textPracticeName = textPracticeName;
    }

    public String getStatus() {
        return textStatus;
    }

    public void setStatus(String textStatus) {
        this.textStatus = textStatus;
    }
}

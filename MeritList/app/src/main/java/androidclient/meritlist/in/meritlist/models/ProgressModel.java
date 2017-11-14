package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class ProgressModel {

    private String textSubject;
    private int intPercentage;
    private Boolean isFinished;

    public ProgressModel() {
    }

    public ProgressModel(String textSubject, int intPercentage, Boolean isFinished) {
        this.textSubject = textSubject;
        this.intPercentage = intPercentage;
        this.isFinished = isFinished;
    }

    public String getSubject() {
        return textSubject;
    }

    public void setSubject(String textSubject) {
        this.textSubject = textSubject;
    }

    public int getPercentage() {
        return intPercentage;
    }

    public void setPercentage(int intPercentage) {
        this.intPercentage = intPercentage;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }
}

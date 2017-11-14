package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/25/16.
 */
public class PracticeModelChild {

    private String textSubject;
    private Boolean isChecked;

    public PracticeModelChild() {}

    public PracticeModelChild(String textSubject, Boolean isChecked) {
        this.textSubject = textSubject;
        this.isChecked = isChecked;
    }

    public String getSubject() {
        return textSubject;
    }

    public void setSubject(String textSubject) {
        this.textSubject = textSubject;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }
}

package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/25/16.
 */
public class PaperModelChild {

    private String textSubject;
    private Boolean isDone;

    public PaperModelChild() {}

    public PaperModelChild(String textSubject, Boolean isDone) {
        this.textSubject = textSubject;
        this.isDone = isDone;
    }

    public String getSubject() {
        return textSubject;
    }

    public void setSubject(String textSubject) {
        this.textSubject = textSubject;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isChecked) {
        this.isDone = isDone;
    }
}

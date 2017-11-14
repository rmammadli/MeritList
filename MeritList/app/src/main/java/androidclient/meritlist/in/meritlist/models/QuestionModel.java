package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class QuestionModel {

    private String textQuestionID;
    private int intQuestionStatus;

    public QuestionModel() {
    }

    public QuestionModel(String textQuestionID, int intQuestionStatus) {
        this.textQuestionID = textQuestionID;
        this.intQuestionStatus = intQuestionStatus;
    }

    public String getQuestionID() {
        return textQuestionID;
    }

    public void setQuestionID(String textQuestionID) {
        this.textQuestionID = textQuestionID;
    }

    public int getQuestionStatus() {
        return intQuestionStatus;
    }

    public void setQuestionStatus(int intQuestionStatus) {
        this.intQuestionStatus = intQuestionStatus;
    }
}

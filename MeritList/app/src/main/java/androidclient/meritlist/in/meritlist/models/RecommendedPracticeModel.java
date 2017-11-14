package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class RecommendedPracticeModel {

    private String subject, description, level;

    public RecommendedPracticeModel() {}

    public RecommendedPracticeModel(String subject, String description, String level) {
        this.subject = subject;
        this.description = description;
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

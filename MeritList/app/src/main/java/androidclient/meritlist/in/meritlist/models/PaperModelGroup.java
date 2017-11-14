package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/25/16.
 */
public class PaperModelGroup {

    private String textGroupName;

    public PaperModelGroup() {}

    public PaperModelGroup(String textGroupName) {
        this.textGroupName = textGroupName;
    }

    public String getGroupName() {
        return textGroupName;
    }

    public void setGroupName(String textGroupName) {
        this.textGroupName = textGroupName;
    }
}

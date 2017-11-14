package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HomeModel {

    private String textTitle;
    private int viewType;

    public HomeModel() {
    }

    public HomeModel(String textTitle, int viewType) {
        this.textTitle = textTitle;
        this.viewType = viewType;
    }

    public String getTitle() {
        return textTitle;
    }

    public void setTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

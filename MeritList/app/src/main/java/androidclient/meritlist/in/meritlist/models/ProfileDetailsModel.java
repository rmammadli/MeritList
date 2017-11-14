package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class ProfileDetailsModel {

    private String detailName, detilData;

    public ProfileDetailsModel() {}

    public ProfileDetailsModel(String detailName, String detilData) {
        this.detailName = detailName;
        this.detilData = detilData;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getDetilData() {
        return detilData;
    }

    public void setDetilData(String detilData) {
        this.detilData = detilData;
    }
}

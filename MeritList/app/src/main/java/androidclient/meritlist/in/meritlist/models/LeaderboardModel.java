package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class LeaderboardModel {

    private String textRank, textName, textCity, textXp;

    public LeaderboardModel() {
    }

    public LeaderboardModel(String textRank, String textName, String textCity, String textXp) {
        this.textRank = textRank;
        this.textName = textName;
        this.textCity = textCity;
        this.textXp = textXp;
    }

    public String getRank() {
        return textRank;
    }

    public void setRank(String textRank) {
        this.textRank = textRank;
    }

    public String getName() {
        return textName;
    }

    public void setDescription(String textName) {
        this.textName = textName;
    }

    public String getCity() {
        return textCity;
    }

    public void setCity(String textCity) {
        this.textCity = textCity;
    }

    public String getXp() {
        return textXp;
    }

    public void setXp(String textXp) {
        this.textXp = textXp;
    }
}

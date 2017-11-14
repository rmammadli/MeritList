package androidclient.meritlist.in.meritlist.models;

/**
 * Created by rmammadov on 5/17/16.
 */
public class NotificationModel {

    private String textNotificationText, textTime;
    private Boolean boolStatus;

    public NotificationModel() {
    }

    public NotificationModel(String textNotificationText, String textTime, Boolean boolStatus) {
        this.textNotificationText = textNotificationText;
        this.textTime = textTime;
        this.boolStatus = boolStatus;
    }

    public String getNotificationText() {
        return textNotificationText;
    }

    public void setNotificationText(String textNotificationText) {
        this.textNotificationText = textNotificationText;
    }

    public String getTime() {
        return textTime;
    }

    public void setTime(String textStatus) {
        this.textTime = textTime;
    }

    public Boolean getStatus() {
        return boolStatus;
    }

    public void setStatus(Boolean boolStatus) {
        this.boolStatus = boolStatus;
    }
}

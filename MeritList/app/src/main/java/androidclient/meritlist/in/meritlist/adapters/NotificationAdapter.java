package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.HistoryModel;
import androidclient.meritlist.in.meritlist.models.NotificationModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private List<NotificationModel> listNotification;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textNotificationText, textTime;
        public AppCompatRadioButton rbStatus;

        public MyViewHolder(View view) {
            super(view);
            textNotificationText = (AppCompatTextView) view.findViewById(R.id.tv_text_notifications_list_item);
            textTime = (AppCompatTextView) view.findViewById(R.id.tv_time_notifications_list_item);
            rbStatus = (AppCompatRadioButton) view.findViewById(R.id.rb_status_notifications_notification_list_item);
        }
    }

    public NotificationAdapter(List<NotificationModel> listNotification) {
        this.listNotification = listNotification;
    }

    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_notification_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, int position) {
        NotificationModel notificationModel = listNotification.get(position);
        holder.textNotificationText.setText(notificationModel.getNotificationText());
        holder.textTime.setText(notificationModel.getTime());

        if(notificationModel.getStatus()){
            holder.rbStatus.setChecked(true);
        }else {
            holder.rbStatus.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return listNotification.size();
    }
}

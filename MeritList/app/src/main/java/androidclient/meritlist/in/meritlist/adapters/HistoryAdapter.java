package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.HistoryModel;
import androidclient.meritlist.in.meritlist.models.LeaderboardModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private List<HistoryModel> listHistory;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textPracticeName, textStatus;

        public MyViewHolder(View view) {
            super(view);
            textPracticeName = (AppCompatTextView) view.findViewById(R.id.tv_practice_name_history_list_item);
            textStatus = (AppCompatTextView) view.findViewById(R.id.tv_practice_status_history_list_item);
        }
    }

    public HistoryAdapter(List<HistoryModel> listHistory) {
        this.listHistory = listHistory;
    }


    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_history_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.MyViewHolder holder, int position) {
        HistoryModel historyModel = listHistory.get(position);
        holder.textPracticeName.setText(historyModel.getPracticeName());
        holder.textStatus.setText(historyModel.getStatus());
    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }
}

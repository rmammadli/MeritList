package androidclient.meritlist.in.meritlist.adapters;

import android.graphics.Color;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.ProgressModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.MyViewHolder> {

    private List<ProgressModel> listProgress;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textSubject, textPercentage;
        public AppCompatImageView ivStatus;
        public ProgressBar pbPercentage;
        public LinearLayoutCompat llProgress;

        public MyViewHolder(View view) {
            super(view);
            textSubject = (AppCompatTextView) view.findViewById(R.id.tv_subject_name_progress_list);
            textPercentage = (AppCompatTextView) view.findViewById(R.id.tv_subject_percentage_progress_list);
            pbPercentage = (ProgressBar) view.findViewById(R.id.pb_progress_list);
            ivStatus = (AppCompatImageView) view.findViewById(R.id.iv_status_progress_list);
            llProgress = (LinearLayoutCompat) view.findViewById(R.id.ll_subject_on_progress);
        }
    }

    public ProgressAdapter(List<ProgressModel> listProgress) {
        this.listProgress = listProgress;
    }

    @Override
    public ProgressAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_progress_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProgressAdapter.MyViewHolder holder, int position) {
        ProgressModel progressModel = listProgress.get(position);
        holder.textSubject.setText(progressModel.getSubject());

        if (progressModel.getIsFinished()) {

        } else {
            holder.ivStatus.setVisibility(View.GONE);
            holder.pbPercentage.setVisibility(View.VISIBLE);
            holder.pbPercentage.setProgress(progressModel.getPercentage());
            holder.textPercentage.setVisibility(View.VISIBLE);
            holder.textPercentage.setText(String.valueOf(progressModel.getPercentage()));
            holder.llProgress.setVisibility(View.VISIBLE);
            holder.textSubject.setTextColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return listProgress.size();
    }
}

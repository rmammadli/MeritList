package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.DoubtModel;
import androidclient.meritlist.in.meritlist.models.NotificationModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class DoubtAdapter extends RecyclerView.Adapter<DoubtAdapter.MyViewHolder> {

    private List<DoubtModel> listDoubt;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textDoubtDescription;
        public AppCompatImageView ivStatus;

        public MyViewHolder(View view) {
            super(view);
            textDoubtDescription = (AppCompatTextView) view.findViewById(R.id.tv_description_doubt_list_item);
            ivStatus = (AppCompatImageView) view.findViewById(R.id.iv_verified_indicator_doubt_list_item);
        }
    }

    public DoubtAdapter(List<DoubtModel> listDoubt) {
        this.listDoubt = listDoubt;
    }

    @Override
    public DoubtAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_doubt_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DoubtAdapter.MyViewHolder holder, int position) {
        DoubtModel doubtModel = listDoubt.get(position);
        holder.textDoubtDescription.setText(doubtModel.getDoubtDescription());

        if(doubtModel.getStatus()){
            holder.ivStatus.setVisibility(View.VISIBLE);
        }else {
            holder.ivStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listDoubt.size();
    }
}

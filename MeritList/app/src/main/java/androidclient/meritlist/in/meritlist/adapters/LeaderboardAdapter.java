package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.LeaderboardModel;
import androidclient.meritlist.in.meritlist.models.RecommendedPracticeModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.MyViewHolder> {

    private List<LeaderboardModel> listLeaderboard;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textRank, textName, textCity, textXp;

        public MyViewHolder(View view) {
            super(view);
            textRank = (AppCompatTextView) view.findViewById(R.id.tv_rank_leaderboard_list_item);
            textName = (AppCompatTextView) view.findViewById(R.id.tv_name_leaderboard_list_item);
            textCity = (AppCompatTextView) view.findViewById(R.id.tv_city_leaderboard_list_item);
            textXp = (AppCompatTextView) view.findViewById(R.id.tv_xp_leaderboard_list_item);
        }
    }

    public LeaderboardAdapter(List<LeaderboardModel> listLeaderboard) {
        this.listLeaderboard = listLeaderboard;
    }

    @Override
    public LeaderboardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_leaderboard_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeaderboardAdapter.MyViewHolder holder, int position) {
        LeaderboardModel leaderboard = listLeaderboard.get(position);
        holder.textRank.setText(leaderboard.getRank());
        holder.textName.setText(leaderboard.getName());
        holder.textCity.setText(leaderboard.getCity());
        holder.textXp.setText(leaderboard.getXp());
    }

    @Override
    public int getItemCount() {
        return listLeaderboard.size();
    }
}

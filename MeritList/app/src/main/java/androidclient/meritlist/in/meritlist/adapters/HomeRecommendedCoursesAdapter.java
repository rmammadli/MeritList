package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.RecommendedPracticeModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HomeRecommendedCoursesAdapter extends RecyclerView.Adapter<HomeRecommendedCoursesAdapter.MyViewHolder> {

    private List<RecommendedPracticeModel> recommenededList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textSubject, textDescription, textLevel;

        public MyViewHolder(View view) {
            super(view);
            textSubject = (AppCompatTextView) view.findViewById(R.id.tv_subject_recommended_home);
            textDescription = (AppCompatTextView) view.findViewById(R.id.tv_description_recommended_home);
            textLevel = (AppCompatTextView) view.findViewById(R.id.tv_level_recommended_home);
        }
    }

    public HomeRecommendedCoursesAdapter(List<RecommendedPracticeModel> recommenededList) {
        this.recommenededList = recommenededList;
    }

    @Override
    public HomeRecommendedCoursesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recommended_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeRecommendedCoursesAdapter.MyViewHolder holder, int position) {
        RecommendedPracticeModel recommendations = recommenededList.get(position);
        holder.textSubject.setText(recommendations.getSubject());
        holder.textDescription.setText(recommendations.getDescription());
        holder.textLevel.setText(recommendations.getLevel());
    }

    @Override
    public int getItemCount() {
        return recommenededList.size();
    }
}

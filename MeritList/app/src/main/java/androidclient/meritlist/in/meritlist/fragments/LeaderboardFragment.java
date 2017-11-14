package androidclient.meritlist.in.meritlist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.HomeRecommendedCoursesAdapter;
import androidclient.meritlist.in.meritlist.adapters.LeaderboardAdapter;
import androidclient.meritlist.in.meritlist.models.LeaderboardModel;
import androidclient.meritlist.in.meritlist.models.RecommendedPracticeModel;

/**
 * Created by rmammadov on 5/13/16.
 */
public class LeaderboardFragment extends Fragment {
    public final static String TAG = "LeaderboardFragment";

    private View view;
    private List<LeaderboardModel> listLeaderboard = new ArrayList<>();
    private RecyclerView recyclerViewLeaderboard;
    private LeaderboardAdapter mAdapterLeaderboard;

    public static LeaderboardFragment newInstance() {
        LeaderboardFragment frag = new LeaderboardFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_leaderboard, container, false);

        //Call setup views after fragment view has been created
        setupView();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Initalize Components
        recyclerViewLeaderboard = (RecyclerView) view.findViewById(R.id.rv_leaderboard);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewLeaderboard.setLayoutManager(mLayoutManager);
        recyclerViewLeaderboard.setItemAnimator(new DefaultItemAnimator());
        mAdapterLeaderboard = new LeaderboardAdapter(listLeaderboard);
        recyclerViewLeaderboard.setAdapter(mAdapterLeaderboard);

        //Call Leaderboard recyclerView method
        prepareLeaderboardData();
    }


    /**
     * Set leaderboard list to recyclerView
     */
    private void prepareLeaderboardData() {
        LeaderboardModel leaderboardModel = new LeaderboardModel("1", "Rajan Soni", "Udaipur", "560");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("2", "Arjun Kumar", "Udaipur", "401");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("3", "Abhinn Kothari", "Kota", "360");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("4", "Prabhash Kataria", "Mumbai", "357");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("5", "Sahil Gupta", "Kota", "340");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("6", "Rohit Mehta", "Udaipur", "336");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("7", "Nikhil Jain", "Delhi", "328");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("8", "Laxman Soni", "Udaipur", "301");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("9", "Pranay Suhalka", "Kota", "280");
        listLeaderboard.add(leaderboardModel);

        leaderboardModel = new LeaderboardModel("10", "Murtaza Alamshah", "Mumbai", "265");
        listLeaderboard.add(leaderboardModel);

        mAdapterLeaderboard.notifyDataSetChanged();
    }
}

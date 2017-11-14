package androidclient.meritlist.in.meritlist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.HistoryAdapter;
import androidclient.meritlist.in.meritlist.adapters.LeaderboardAdapter;
import androidclient.meritlist.in.meritlist.adapters.ProfileDetailListAdapter;
import androidclient.meritlist.in.meritlist.models.HistoryModel;
import androidclient.meritlist.in.meritlist.models.LeaderboardModel;
import androidclient.meritlist.in.meritlist.models.ProfileDetailsModel;

/**
 * Created by rmammadov on 5/13/16.
 */
public class HistoryFragment extends Fragment {
    public final static String TAG = "HistoryFragment";

    private View view;
    private List<HistoryModel> listHistory = new ArrayList<>();
    private RecyclerView recyclerViewHistory;
    private HistoryAdapter mAdapterHistory;

    public static HistoryFragment newInstance() {
        HistoryFragment frag = new HistoryFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_history, container, false);

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
        recyclerViewHistory = (RecyclerView) view.findViewById(R.id.rv_history);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewHistory.setLayoutManager(mLayoutManager);
        recyclerViewHistory.setItemAnimator(new DefaultItemAnimator());
        mAdapterHistory = new HistoryAdapter(listHistory);
        recyclerViewHistory.setAdapter(mAdapterHistory);

        //Call Leaderboard recyclerView method
        prepareHistoryData();
    }

    /**
     * Set recommendation list to recyclerView
     */
    private void prepareHistoryData() {
        HistoryModel historyModel = new HistoryModel("Practice 2: Rotational Motion", "45/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 3: Atomic Structure", "43/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 3: Alcohol Phenol Ether", "47/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 2: Alcohol Phenol Ether", "35/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 1: Alcohol Phenol Ether", "50/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 2: Atomic Structure", "200/360");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 1: Atomic Structure", "40/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("JEE Advanced 2016 - 1", "27/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 2: Aldehyde Ketones", "36/50");
        listHistory.add(historyModel);

        historyModel = new HistoryModel("Practice 1; Aldehyde Ketones", "50/50");
        listHistory.add(historyModel);

        mAdapterHistory.notifyDataSetChanged();
    }
}

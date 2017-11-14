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
import androidclient.meritlist.in.meritlist.adapters.HelpAdapter;
import androidclient.meritlist.in.meritlist.adapters.HistoryAdapter;
import androidclient.meritlist.in.meritlist.models.HelpModel;
import androidclient.meritlist.in.meritlist.models.HistoryModel;

/**
 * Created by rmammadov on 5/13/16.
 */
public class HelpFragment extends Fragment {
    public final static String TAG = "HelpFragment";

    private View view;
    private List<HelpModel> listHelp = new ArrayList<>();
    private RecyclerView recyclerViewHelp;
    private HelpAdapter mAdapterHelp;

    public static HelpFragment newInstance() {
        HelpFragment frag = new HelpFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_help, container, false);

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
        recyclerViewHelp = (RecyclerView) view.findViewById(R.id.rv_help);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewHelp.setLayoutManager(mLayoutManager);
        recyclerViewHelp.setItemAnimator(new DefaultItemAnimator());
        mAdapterHelp = new HelpAdapter(listHelp);
        recyclerViewHelp.setAdapter(mAdapterHelp);

        //Call Leaderboard recyclerView method
        prepareLeaderboardData();
    }

    /**
     * Set recommendation list to recyclerView
     */
    private void prepareLeaderboardData() {
        HelpModel helpModel = new HelpModel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam mauris eros?\n");
        listHelp.add(helpModel);

        helpModel = new HelpModel("Vestibulum non mollis ex, dictum dignissim ligula. Donec placerat tortor ipsum, eu convallis tellus pharetra eu?\n");
        listHelp.add(helpModel);

        helpModel = new HelpModel("Cras convallis nulla vitae felis scelerisque pharetra. Nunc faucibus placerat tincidunt?");
        listHelp.add(helpModel);

        helpModel = new HelpModel("Donec nibh augue, lobortis vitae sagittis a, faucibus eget tellus. In sagittis dolor a vulputate ultrices?");
        listHelp.add(helpModel);

        helpModel = new HelpModel("Morbi gravida ipsum interdum porta lobortis. Erat, nec porttitor mi massa sit amet justo?");
        listHelp.add(helpModel);

        helpModel = new HelpModel("Ut nunc nunc, tincidunt nec justo nec, pellentesque rhoncus mi. Cras nec facilisis neque, in consequat lorem?");
        listHelp.add(helpModel);

        helpModel = new HelpModel("Ipsum interdum porta lobortis?");
        listHelp.add(helpModel);

        mAdapterHelp.notifyDataSetChanged();
    }
}

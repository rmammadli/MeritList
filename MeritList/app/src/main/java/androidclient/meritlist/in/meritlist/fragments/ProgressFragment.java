package androidclient.meritlist.in.meritlist.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.LeaderboardAdapter;
import androidclient.meritlist.in.meritlist.adapters.ProfileDetailListAdapter;
import androidclient.meritlist.in.meritlist.adapters.ProgressAdapter;
import androidclient.meritlist.in.meritlist.models.LeaderboardModel;
import androidclient.meritlist.in.meritlist.models.ProfileDetailsModel;
import androidclient.meritlist.in.meritlist.models.ProgressModel;

/**
 * Created by rmammadov on 5/13/16.
 */
public class ProgressFragment extends Fragment {
    public final static String TAG = "ProgressFragment";

    private View view;
    private List<ProgressModel> listProgress = new ArrayList<>();
    private RecyclerView recyclerViewProgress;
    private ProgressAdapter mAdapterProgress;

    public static ProgressFragment newInstance() {
        ProgressFragment frag = new ProgressFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_progress, container, false);

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
        recyclerViewProgress = (RecyclerView) view.findViewById(R.id.rv_progress);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewProgress.setLayoutManager(mLayoutManager);
        recyclerViewProgress.setItemAnimator(new DefaultItemAnimator());
        mAdapterProgress = new ProgressAdapter(listProgress);
        recyclerViewProgress.setAdapter(mAdapterProgress);

        //Call Progress recyclerView method
        prepareProgressData();
    }

    /**
     * Set progress list to recyclerView
     */
    private void prepareProgressData() {
        ProgressModel progressModel = new ProgressModel("Alcohol Phenol Ether", 50, false);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 40, false);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        progressModel = new ProgressModel("Alcohol Phenol Ether", 100, true);
        listProgress.add(progressModel);

        mAdapterProgress.notifyDataSetChanged();
    }
}

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.activities.HomeActivity;
import androidclient.meritlist.in.meritlist.adapters.HistoryAdapter;
import androidclient.meritlist.in.meritlist.adapters.HomeAdapter;
import androidclient.meritlist.in.meritlist.adapters.HomeRecommendedCoursesAdapter;
import androidclient.meritlist.in.meritlist.constants.Constants;
import androidclient.meritlist.in.meritlist.models.HistoryModel;
import androidclient.meritlist.in.meritlist.models.HomeModel;
import androidclient.meritlist.in.meritlist.models.RecommendedPracticeModel;

/**
 * Created by rmammadov on 5/13/16.
 */
public class HomeFragment extends Fragment {
    public final static String TAG = "HomeFragment";

    private View view;
    private List<RecommendedPracticeModel> listRecommendations = new ArrayList<>();
    private RecyclerView recyclerViewRecommendations;
    private HomeRecommendedCoursesAdapter mAdapterRecommendations;

    private List<HomeModel> listHome = new ArrayList<>();
    private RecyclerView recyclerViewHome;
    private HomeAdapter mAdapterHome;
    private HomeModel homeModel;

    public static HomeFragment newInstance() {
        HomeFragment frag = new HomeFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_home, container, false);

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
        recyclerViewRecommendations = (RecyclerView) view.findViewById(R.id.rv_recommendedpractice);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewRecommendations.setLayoutManager(mLayoutManager);
        recyclerViewRecommendations.setItemAnimator(new DefaultItemAnimator());
        mAdapterRecommendations = new HomeRecommendedCoursesAdapter(listRecommendations);
        recyclerViewRecommendations.setAdapter(mAdapterRecommendations);
        //Home recycleview
        recyclerViewHome = (RecyclerView) view.findViewById(R.id.rv_home);
        RecyclerView.LayoutManager mLayoutManagerHome = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewHome.setLayoutManager(mLayoutManagerHome);
        recyclerViewHome.setItemAnimator(new DefaultItemAnimator());
        //onClick listener of the home list view
        recyclerViewHome.setAdapter(new HomeAdapter (listHome, new HomeAdapter.OnItemClickListener() {
            @Override public void onItemClick(HomeModel item) {
                ((HomeActivity)getActivity()).openNews ();
            }
        }));

        //Setup lists data
        prepareRecommendationsData();
        prepareUpcomingExams();
        prepareNewsFeed();

        //Setup on click listeners
        setupOnClickListeners();
    }

    /**
     * Method to setup on click listeners of the existing components
     */
    private void setupOnClickListeners(){
        //Onclick listener of the News list view

    }

    /**
     * Set recommendation list to recyclerView
     */
    private void prepareRecommendationsData() {
        RecommendedPracticeModel recommendedPracticeModel = new RecommendedPracticeModel("PHYS", "Action & Adventure", "LEVEL 3");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("CHEM", "Animation, Kids & Family", "LEVEL 3");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("MATHS", "Action", "LEVEL 9");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("MATHS", "Animation", "LEVEL 7");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("MATHS", "Science Fiction & Fantasy", "LEVEL 4");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("CHEM", "Action", "LEVEL 3");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("PHYS", "Animation", "LEVEL 5");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("CHEM", "Science Fiction", "LEVEL 3");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("PHYS", "Animation", "LEVEL 6");
        listRecommendations.add(recommendedPracticeModel);

        recommendedPracticeModel = new RecommendedPracticeModel("MATHS", "Action & Adventure", "LEVEL 4");
        listRecommendations.add(recommendedPracticeModel);

        mAdapterRecommendations.notifyDataSetChanged();
    }

    /**
     * fill upcoming exams list view
     */
    private void prepareUpcomingExams(){
        homeModel = new HomeModel (getString (R.string.text_newsfeed_title), Constants.VIEW_TYPE_HEADER);
        listHome.add(homeModel);

        homeModel = new HomeModel ("1. BITSAT online tests: 14 May 2016", Constants.VIEW_TYPE_ITEM);
        listHome.add(homeModel);

        homeModel = new HomeModel ("2. JEE Advanced 2016: 22 May 2016", Constants.VIEW_TYPE_ITEM);
        listHome.add(homeModel);
    }

    /**
     * fill upcoming exams list view
     */
    private void prepareNewsFeed(){
        homeModel = new HomeModel (getString (R.string.text_upcomingexams_title), Constants.VIEW_TYPE_HEADER);
        listHome.add(homeModel);

        homeModel = new HomeModel ("1. JEE (Advanced) draws near, experts tell engg aspirants to focus on revision.", Constants.VIEW_TYPE_ITEM);
        listHome.add(homeModel);

        homeModel = new HomeModel ("2. FIITJEE student Ankit from gurgaon tops mains", Constants.VIEW_TYPE_ITEM);
        listHome.add(homeModel);

        homeModel = new HomeModel ("3. I couldn't clear JEE Mains and my parents won't talk to me", Constants.VIEW_TYPE_ITEM);
        listHome.add(homeModel);

        homeModel = new HomeModel ("4. I couldn't clear JEE Mains and my parents won't talk to me", Constants.VIEW_TYPE_ITEM);
        listHome.add(homeModel);
    }
}

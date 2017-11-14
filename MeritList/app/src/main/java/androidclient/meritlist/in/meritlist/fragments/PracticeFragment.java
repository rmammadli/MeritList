package androidclient.meritlist.in.meritlist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.activities.HomeActivity;
import androidclient.meritlist.in.meritlist.activities.LoginActivity;
import androidclient.meritlist.in.meritlist.adapters.PracticeExpandableAdapter;
import androidclient.meritlist.in.meritlist.adapters.ProfileDetailListAdapter;
import androidclient.meritlist.in.meritlist.models.PracticeModelChild;
import androidclient.meritlist.in.meritlist.models.PracticeModelGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PracticeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PracticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PracticeFragment extends Fragment {
    public final static String TAG = "PracticeFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private AppCompatButton btnStartPractice;
    private RelativeLayout rlPracticeButton;

    //List variables
    private PracticeExpandableAdapter mAdapterPractice;
    private ExpandableListView elvPractices;
    private List<PracticeModelGroup> listDataHeader;
    private HashMap<PracticeModelGroup, List<PracticeModelChild>> listDataChild;

    private OnFragmentInteractionListener mListener;

    public PracticeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PracticeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PracticeFragment newInstance(String param1, String param2) {
        PracticeFragment fragment = new PracticeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_practice, container, false);

        //Call setup views after fragment view has been created
        setupView();

        // Inflate the layout for this fragment
        return view;
    }


    /**
     * Setup View components
     */
    private void setupView() {
        //Initalize Components
        elvPractices = (ExpandableListView) view.findViewById(R.id.exlv_practice);
        btnStartPractice = (AppCompatButton) view.findViewById (R.id.btn_start_practice);
        rlPracticeButton = (RelativeLayout) view.findViewById (R.id.rl_practice_button);
        // preparing list data
        preparePracticeData();
        mAdapterPractice = new PracticeExpandableAdapter(getActivity(), listDataHeader, listDataChild);
        elvPractices.setAdapter(mAdapterPractice);

        //Setup click listeners method call
        setupClickListeners();
    }

    /**
     * Setup click listeners of the components
     */
    private void setupClickListeners() {
        //Set start practice button listener
        btnStartPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).openExamDetails ();
            }
        });

        elvPractices.setOnScrollListener(new AbsListView.OnScrollListener () {
            private int mLastFirstVisibleItem;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if(mLastFirstVisibleItem<firstVisibleItem)
                {
                    hidePracticeButton ();
                }
                if(mLastFirstVisibleItem>firstVisibleItem)
                {
                    hidePracticeButton ();
                }
                mLastFirstVisibleItem=firstVisibleItem;
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
     * Preparing the list data
     */
    private void preparePracticeData() {
        listDataHeader = new ArrayList<PracticeModelGroup>();
        listDataChild = new HashMap<PracticeModelGroup, List<PracticeModelChild>>();

        // Adding child data
        PracticeModelGroup practiceModelGroup = new PracticeModelGroup("Physics Class XII");
        listDataHeader.add(practiceModelGroup);

        practiceModelGroup = new PracticeModelGroup("Chemistry Class XI");
        listDataHeader.add(practiceModelGroup);

        practiceModelGroup = new PracticeModelGroup("Chemistry Class XII");
        listDataHeader.add(practiceModelGroup);

        // Adding child data
        List<PracticeModelChild> groupXII = new ArrayList<PracticeModelChild>();

        PracticeModelChild practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupXII.add(practiceModelChild);

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupXII.add(practiceModelChild);

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupXII.add(practiceModelChild);

        // Adding child data
        List<PracticeModelChild> groupXI = new ArrayList<PracticeModelChild>();

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupXI.add(practiceModelChild);

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupXI.add(practiceModelChild);

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupXI.add(practiceModelChild);

        // Adding child data
        List<PracticeModelChild> groupX = new ArrayList<PracticeModelChild>();

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupX.add(practiceModelChild);

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupX.add(practiceModelChild);

        practiceModelChild = new PracticeModelChild("Physics Class XII", true);
        groupX.add(practiceModelChild);

        listDataChild.put(listDataHeader.get(0), groupXII); // Header, Child data
        listDataChild.put(listDataHeader.get(1), groupXI);
        listDataChild.put(listDataHeader.get(2), groupX);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * Translate and hide practice button
     */
    public void hidePracticeButton(){
        rlPracticeButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator ()).start();
    }

    /**
     * Translate and show practice button
     */
    public void showPracticeButton(){
        rlPracticeButton.animate().translationY(-rlPracticeButton.getBottom()).setInterpolator(new AccelerateInterpolator ()).start();
    }
}

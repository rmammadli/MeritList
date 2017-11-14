package androidclient.meritlist.in.meritlist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.activities.HomeActivity;
import androidclient.meritlist.in.meritlist.adapters.PaperExpandableAdapter;
import androidclient.meritlist.in.meritlist.models.PaperModelChild;
import androidclient.meritlist.in.meritlist.models.PaperModelGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaperFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PaperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaperFragment extends Fragment {
    public final static String TAG = "PaperFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    //List variables
    PaperExpandableAdapter mAdapterPaper;
    ExpandableListView elvPapers;
    List<PaperModelGroup> listDataHeader;
    HashMap<PaperModelGroup, List<PaperModelChild>> listDataChild;

    private OnFragmentInteractionListener mListener;

    public PaperFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaperFragment newInstance(String param1, String param2) {
        PaperFragment fragment = new PaperFragment();
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
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_paper, container, false);

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
        elvPapers = (ExpandableListView) view.findViewById(R.id.exlv_paper);
        // preparing list data
        preparePaperData();
        mAdapterPaper = new PaperExpandableAdapter(getActivity(), listDataHeader, listDataChild);
        elvPapers.setAdapter(mAdapterPaper);

        //Call Setup onClickListeneres method for existing method
        setupOnClickListeners();
    }

    /**
     * Method to setup on click listeners of the existing components
     */
    private void setupOnClickListeners(){
        //Onclick listener of the News list view
        elvPapers.setOnChildClickListener (new ExpandableListView.OnChildClickListener () {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                ((HomeActivity)getActivity()).openExamDetails ();
                return true;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void preparePaperData() {
        listDataHeader = new ArrayList<PaperModelGroup>();
        listDataChild = new HashMap<PaperModelGroup, List<PaperModelChild>>();

        // Adding child data
        PaperModelGroup paperModelGroup = new PaperModelGroup("IIT JEE Mains");
        listDataHeader.add(paperModelGroup);

        paperModelGroup = new PaperModelGroup("IIT JEE Advanced");
        listDataHeader.add(paperModelGroup);

        paperModelGroup = new PaperModelGroup("IIT JEE Advanced XII");
        listDataHeader.add(paperModelGroup);

        // Adding child data
        List<PaperModelChild> groupMains = new ArrayList<PaperModelChild>();

        PaperModelChild paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", true);
        groupMains.add(paperModelChild);

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", true);
        groupMains.add(paperModelChild);

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", true);
        groupMains.add(paperModelChild);

        // Adding child data
        List<PaperModelChild> groupAdvanced = new ArrayList<PaperModelChild>();

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", true);
        groupAdvanced.add(paperModelChild);

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", false);
        groupAdvanced.add(paperModelChild);

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", false);
        groupAdvanced.add(paperModelChild);

        // Adding child data
        List<PaperModelChild> groupXII = new ArrayList<PaperModelChild>();

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", false);
        groupXII.add(paperModelChild);

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", true);
        groupXII.add(paperModelChild);

        paperModelChild = new PaperModelChild("Resonance JEE-A model paper 2016 - 1", true);
        groupXII.add(paperModelChild);

        listDataChild.put(listDataHeader.get(0), groupMains); // Header, Child data
        listDataChild.put(listDataHeader.get(1), groupAdvanced);
        listDataChild.put(listDataHeader.get(2), groupXII);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

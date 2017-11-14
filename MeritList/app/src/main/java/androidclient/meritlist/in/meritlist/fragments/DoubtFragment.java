package androidclient.meritlist.in.meritlist.fragments;

import android.content.Context;
import android.net.Uri;
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
import androidclient.meritlist.in.meritlist.adapters.DoubtAdapter;
import androidclient.meritlist.in.meritlist.adapters.HistoryAdapter;
import androidclient.meritlist.in.meritlist.models.DoubtModel;
import androidclient.meritlist.in.meritlist.models.HistoryModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DoubtFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DoubtFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoubtFragment extends Fragment {
    public final static String TAG = "DoubtFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View view;
    private List<DoubtModel> listDoubt = new ArrayList<>();
    private RecyclerView recyclerViewDoubt;
    private DoubtAdapter mAdapterDoubt;

    public DoubtFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoubtFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DoubtFragment newInstance(String param1, String param2) {
        DoubtFragment fragment = new DoubtFragment();
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
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_doubt, container, false);

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
        recyclerViewDoubt = (RecyclerView) view.findViewById(R.id.rv_doubt);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewDoubt.setLayoutManager(mLayoutManager);
        recyclerViewDoubt.setItemAnimator(new DefaultItemAnimator());
        mAdapterDoubt = new DoubtAdapter(listDoubt);
        recyclerViewDoubt.setAdapter(mAdapterDoubt);

        //Call Leaderboard recyclerView method
        prepareDoubtData();
    }

    /**
     * Set doubt list to recyclerView
     */
    private void prepareDoubtData() {
        DoubtModel doubtModel = new DoubtModel("A force F⃗ =8iˆ−6jˆ−10kˆF→=8i^-6j^-10k^ newton produces an acceleration of 1m...", true);
        listDoubt.add(doubtModel);

        doubtModel = new DoubtModel("It can shown that ∫01xk(1−x)n−kdx=[nCk(n+1)]−1fork=0,1,...,n∫01xk(1−x)n−kdx=[nCk(n+1)]−1…", false);
        listDoubt.add(doubtModel);

        doubtModel = new DoubtModel("The hybridisation of carbon atoms in C-C single bond of H−C≡C−CH=CH2?", true);
        listDoubt.add(doubtModel);

        doubtModel = new DoubtModel("What is the area of the region enclosed by the lines x = 0, y = 0, and x + y = 2?", true);
        listDoubt.add(doubtModel);

        mAdapterDoubt.notifyDataSetChanged();
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

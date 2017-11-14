package androidclient.meritlist.in.meritlist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.activities.ExamDetailsActivity;
import androidclient.meritlist.in.meritlist.constants.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    private static final String ARG_QUESTION_NUMBER = "question_number";
    private static final String ARG_QUESTION_ID = "question_id";
    private static final String ARG_QUESTION_STATUS = "question_status";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParamQuestionNumber;
    private String mParamQuestionID;
    private int mParamQuestionStatus;

    private View view;
    private String questionID;
    private WebView wvQuestion;

    private OnFragmentInteractionListener mListener;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(int page, String questionID, int questionStatus) {
        QuestionFragment fragment = new QuestionFragment ();
        Bundle args = new Bundle ();
        args.putInt (ARG_QUESTION_NUMBER, page);
        args.putString (ARG_QUESTION_ID, questionID);
        args.putInt (ARG_QUESTION_STATUS, questionStatus);
        fragment.setArguments (args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if (getArguments () != null) {
            mParamQuestionNumber = getArguments ().getInt (ARG_QUESTION_NUMBER);
            mParamQuestionID = getArguments ().getString (ARG_QUESTION_ID);
            mParamQuestionStatus = getArguments ().getInt (ARG_QUESTION_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = getActivity ().getLayoutInflater ().inflate (R.layout.fragment_question, container, false);

        //Setup View method call
        setupView();

        return view;
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Setup webview
        wvQuestion = (WebView) view.findViewById (R.id.wv_question);
        wvQuestion.getSettings().setJavaScriptEnabled(true);
        wvQuestion.getSettings().setSupportZoom (true);
        wvQuestion.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wvQuestion.loadUrl ("file:///android_asset/questions/question.html");
        //Setup answer options
        callSetupOptions();
    }

    private void callSetupOptions(){
        if(mParamQuestionNumber == 2){
            ((ExamDetailsActivity)getActivity()).setupTabAnswerOptions (Constants.OPTION_TYPE_MATRIX, 4);
        }else if(mParamQuestionNumber == 3){
            ((ExamDetailsActivity)getActivity()).setupTabAnswerOptions (Constants.OPTION_TYPE_MULTICHOICE, 3);
        }else if(mParamQuestionNumber == 4){
            ((ExamDetailsActivity)getActivity()).setupTabAnswerOptions (Constants.OPTION_TYPE_MATRIX, 2);
        }else if(mParamQuestionNumber == 5){
            ((ExamDetailsActivity)getActivity()).setupTabAnswerOptions (Constants.OPTION_TYPE_MULTICHOICE, 5);
        }else if(mParamQuestionNumber == 6){
            ((ExamDetailsActivity)getActivity()).setupTabAnswerOptions (Constants.OPTION_TYPE_MATRIX, 5);
        }else {
            ((ExamDetailsActivity)getActivity()).setupTabAnswerOptions (Constants.OPTION_TYPE_MULTICHOICE, 4);
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction (uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach ();
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
}

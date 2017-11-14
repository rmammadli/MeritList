package androidclient.meritlist.in.meritlist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.meritlist.in.meritlist.constants.Constants;
import androidclient.meritlist.in.meritlist.R;

/**
 * Created by rmammadov on 5/13/16.
 */
public class IntroFragment extends Fragment {
    public final static String TAG = "IntroFragment";

    private int mBackgroundColor, mPage;

    public static IntroFragment newInstance(int backgroundColor, int page) {
        IntroFragment frag = new IntroFragment();
        Bundle b = new Bundle();
        b.putInt(Constants.BACKGROUND_COLOR, backgroundColor);
        b.putInt(Constants.PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getArguments().containsKey(Constants.BACKGROUND_COLOR))
            throw new RuntimeException("Fragment must contain a \"" + Constants.BACKGROUND_COLOR + "\" argument!");
        mBackgroundColor = getArguments().getInt(Constants.BACKGROUND_COLOR);

        if (!getArguments().containsKey(Constants.PAGE))
            throw new RuntimeException("Fragment must contain a \"" + Constants.PAGE + "\" argument!");
        mPage = getArguments().getInt(Constants.PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Select a layout based on the current page
        int layoutResId;
        switch (mPage) {
            case 0:
                layoutResId = R.layout.fragment_intro_1;
                break;
            case 1:
                layoutResId = R.layout.fragment_intro_2;
                break;
            case 2:
                layoutResId = R.layout.fragment_intro_3;
                break;
            default:
                layoutResId = R.layout.fragment_intro_4;
        }

        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);

        // Set the current page index as the View's tag (useful in the PageTransformer)
        view.setTag(mPage);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the background color of the root view to the color specified in newInstance()
        View background = view.findViewById(R.id.intro_background);
        background.setBackgroundColor(mBackgroundColor);
    }
}

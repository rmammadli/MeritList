package androidclient.meritlist.in.meritlist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.activities.LoginActivity;
import androidclient.meritlist.in.meritlist.adapters.LoginPagerAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by rmammadov on 5/13/16.
 */
public class SignInFragment  extends Fragment{
    public final static String TAG = "SignInFragment";

    private AppCompatButton btnSignIn;
    private View v;

    public static SignInFragment newInstance() {
        SignInFragment f = new SignInFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_signin, container, false);

        //Setup view components
        setupView();

        //Setup listeners of components
        setupClickListeners();

        return v;
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Set Viewpager and its adapter
        btnSignIn = (AppCompatButton) v.findViewById(R.id.btn_signin);
    }

    /**
     * Setup click listeners of the components
     */
    private void setupClickListeners() {
        //Set Viewpager listener
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).openHomeActivity();
            }
        });
    }
}

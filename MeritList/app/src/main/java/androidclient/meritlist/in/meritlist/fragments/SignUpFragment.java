package androidclient.meritlist.in.meritlist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.activities.LoginActivity;

/**
 * Created by rmammadov on 5/13/16.
 */
public class SignUpFragment extends Fragment {
    public final static String TAG = "SignUpFragment";

    private AppCompatButton btnSignUp;
    private View v;

    public static SignUpFragment newInstance() {
        SignUpFragment f = new SignUpFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_signup, container, false);

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
        btnSignUp = (AppCompatButton) v.findViewById(R.id.btn_signup);
    }

    /**
     * Setup click listeners of the components
     */
    private void setupClickListeners() {
        //Set Viewpager listener
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).openHomeActivity();
            }
        });
    }
}

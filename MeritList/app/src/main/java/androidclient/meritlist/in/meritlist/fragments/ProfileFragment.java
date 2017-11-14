package androidclient.meritlist.in.meritlist.fragments;

import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.ListViewCompat;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.ProfileDetailListAdapter;
import androidclient.meritlist.in.meritlist.models.ProfileDetailsModel;

/**
 * Created by rmammadov on 5/13/16.
 */
public class ProfileFragment extends Fragment {
    public final static String TAG = "ProfileFragment";

    private View view;
    private ListViewCompat lvUserDetails;
    ProfileDetailListAdapter adapter;
    public ArrayList<ProfileDetailsModel> profileDetailsModelArrayList = new ArrayList<ProfileDetailsModel>();

    public static ProfileFragment newInstance() {
        ProfileFragment frag = new ProfileFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_profile, container, false);

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
        lvUserDetails = (ListViewCompat) view.findViewById(R.id.lv_userdetails_profile);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        ViewGroup lvHeader = (ViewGroup) inflater.inflate(R.layout.layout_profile_list_header, lvUserDetails, false);
        adapter = new ProfileDetailListAdapter(getActivity(), this, profileDetailsModelArrayList);
        lvUserDetails.setAdapter(adapter);
        lvUserDetails.addHeaderView(lvHeader);

        //Set list data
        setListData();
    }


    /******
     * Method to set data in ArrayList
     *************/
    public void setListData() {
        /******* Firstly take data in model object ******/
        ProfileDetailsModel profileDetailsModel = new ProfileDetailsModel("Last name", "Soni");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Email", "laxman.soni@gmail.com");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Board", "CBSE");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("School", "Delhi Public School, Udaipur");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Coaching Institute", "Aakash Institute, Udaipur");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("JEE Roll no.", "3452345");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("CBSE Roll no.", "22233344");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Birthday", "11 June 1999");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Lives in", "Udaipur, India");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Gender", "Male");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        /******* Firstly take data in model object ******/
        profileDetailsModel = new ProfileDetailsModel("Phone", "+91 99283 69107");
        /******** Take Model Object in ArrayList **********/
        profileDetailsModelArrayList.add(profileDetailsModel);

        adapter.notifyDataSetChanged();
    }

    /**
     * Fire dialog while click on any item of user details list
     */
    public void showEditDialog(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(profileDetailsModelArrayList.get(position).getDetailName());

        // Set up the inputs
        final AppCompatEditText inputPassword = new AppCompatEditText(getActivity());
        final AppCompatEditText inputData = new AppCompatEditText(getActivity());
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        inputData.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        inputData.setText(profileDetailsModelArrayList.get(position).getDetilData());
        builder.setView(inputData);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}

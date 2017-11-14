package androidclient.meritlist.in.meritlist.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.LoginPagerAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    //Global companents
    private ViewPager mViewPager;
    private AppCompatRadioButton rbtnSignIn;
    private AppCompatRadioButton rbtnSignUp;
    private AppCompatButton btnLogin;
    private AppCompatTextView tvOr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Call setupView
        setupView();

        //Call setup ClickListeners
        setupClickListeners();
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Set Viewpager and its adapter
        mViewPager = (ViewPager) findViewById(R.id.viewpager_login);
        rbtnSignIn = (AppCompatRadioButton) findViewById(R.id.radio_signin);
        rbtnSignUp = (AppCompatRadioButton) findViewById(R.id.radio_signup);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_login);
        tvOr = (AppCompatTextView) findViewById(R.id.tv_or);
        mViewPager.setAdapter(new LoginPagerAdapter(getSupportFragmentManager()));

        //Install custom fonts via Calligraphy library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Montserrat-Regular.ttf.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }

    /**
     * Setup click listeners of the components
     */
    private void setupClickListeners() {
        //Set Viewpager listener
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    rbtnSignIn.setChecked(true);
                    btnLogin.setText(getString(R.string.text_btn_signin));
                    tvOr.setText(getString(R.string.text_login_with));
                } else {
                    rbtnSignUp.setChecked(true);
                    btnLogin.setText(getString(R.string.text_btn_signup));
                    tvOr.setText(getString(R.string.text_connect_with));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Set radio selectors
        rbtnSignIn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    mViewPager.setCurrentItem(1);
            }
        });

        //Set radio selectors
        rbtnSignUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    mViewPager.setCurrentItem(0);
            }
        });
    }

    /**
     * Wrap the Activity Context:
     *
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    /**
     * Open home activity method
     */
    public void openHomeActivity(){
        Intent intenOpenHome = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intenOpenHome);

        //Finish this activity
        finish();
    }
}

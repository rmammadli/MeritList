package androidclient.meritlist.in.meritlist.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

import com.flyco.pageindicator.indicator.FlycoPageIndicaor;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.IntroPagerAdapter;
import androidclient.meritlist.in.meritlist.helpers.IntroPageTransformer;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class IntroActivity extends AppCompatActivity {

    //Global companents
    private ViewPager mViewPager;
    private AppCompatButton btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);

        //Call setup View method
        setupView();

        //Call setup ClickListeners
        setupClickListeners();
    }

    /**
     * Setup View components
     */
    private void setupView(){
        //Setup companents --------------------------------------------------------------
        mViewPager = (ViewPager) findViewById(R.id.viewpager_intro);
        btnGetStarted = (AppCompatButton) findViewById(R.id.btn_get_started);

        // Set an Adapter on the ViewPager
        mViewPager.setAdapter(new IntroPagerAdapter(getSupportFragmentManager()));

        // Set a PageTransformer
//        mViewPager.setPageTransformer(false, new IntroPageTransformer());

        //Set page indicators for the pager
        FlycoPageIndicaor mIndicator = (FlycoPageIndicaor) findViewById(R.id.indicator_circle_snap);
        mIndicator.setViewPager(mViewPager);

        //Install custom fonts via Calligraphy library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }

    /**
     * Setup click listeners of the components
     */
    private void setupClickListeners(){
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intLogin = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intLogin);

                //Finish this Activity
                finish();
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
}

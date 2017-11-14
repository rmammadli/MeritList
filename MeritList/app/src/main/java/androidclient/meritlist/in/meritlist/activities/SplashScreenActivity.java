package androidclient.meritlist.in.meritlist.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidclient.meritlist.in.meritlist.constants.Constants;
import androidclient.meritlist.in.meritlist.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Cal setupView method
        setupView();

        //Call setup splash handler method
        splashHandler();
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Install custom fonts via Calligraphy library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
    /**
     * Setup splash handler
     */
    private void splashHandler() {
        new Handler().postDelayed(new Runnable() {
            // Showing splash screen with a timer.
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreenActivity.this, IntroActivity.class);
                startActivity(i);
                finish();
            }
        }, Constants.SPLASH_TIME_OUT);
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

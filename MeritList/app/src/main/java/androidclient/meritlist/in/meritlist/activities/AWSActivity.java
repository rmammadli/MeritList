package androidclient.meritlist.in.meritlist.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunctionException;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaInvokerFactory;
import com.amazonaws.regions.Regions;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.interfaces.MyInterface;
import androidclient.meritlist.in.meritlist.models.NameInfo;

public class AWSActivity extends AppCompatActivity {

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_aws);

        new LongOperation().execute("");

    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider (
                    getApplicationContext (),    /* get the context for the application */
                    "ap-northeast-1:e8302d23-6e50-4421-b110-cfd6d59a41e8",    /* Identity Pool ID */
                    Regions.AP_NORTHEAST_1           /* Region for your identity pool--US_EAST_1 or EU_WEST_1*/
            );

            LambdaInvokerFactory factory = new LambdaInvokerFactory (AWSActivity.this,
                    Regions.AP_NORTHEAST_1, credentialsProvider);

            NameInfo nameInfo = new NameInfo ("TEST","TEST");
            MyInterface invoker = factory.build(MyInterface.class);

            try {
                result = invoker.helloworld (nameInfo);
            } catch (LambdaFunctionException lfe) {
                Log.e("Error", "Failed to execute echo", lfe);
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
            Toast.makeText (AWSActivity.this,result,Toast.LENGTH_LONG);

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}

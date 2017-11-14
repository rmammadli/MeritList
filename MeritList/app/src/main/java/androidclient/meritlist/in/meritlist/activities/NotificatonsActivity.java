package androidclient.meritlist.in.meritlist.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.HistoryAdapter;
import androidclient.meritlist.in.meritlist.adapters.NotificationAdapter;
import androidclient.meritlist.in.meritlist.models.HistoryModel;
import androidclient.meritlist.in.meritlist.models.NotificationModel;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NotificatonsActivity extends AppCompatActivity {

    private List<NotificationModel> listNotification = new ArrayList<>();
    private RecyclerView recyclerViewNotification;
    private NotificationAdapter mAdapterNotification;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificatons);

        //Call method to setup veiw and components after creating activity window
        setupView();
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Initalize Components
        toolbar = (Toolbar) findViewById(R.id.toolbar_notifications);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerViewNotification = (RecyclerView) findViewById(R.id.rv_notifications);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewNotification.setLayoutManager(mLayoutManager);
        recyclerViewNotification.setItemAnimator(new DefaultItemAnimator());
        mAdapterNotification = new NotificationAdapter(listNotification);
        recyclerViewNotification.setAdapter(mAdapterNotification);


        //Install custom fonts via Calligraphy library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        //Set on clickllisteners of the components
        setOnClickListeners();

        //Call Leaderboard recyclerView method
        prepareNotificationList();
    }

    /**
     * Set on click listeners of the components
     */
    private void setOnClickListeners(){
        //Back press of the toolbar and finish notification acitivty to back pervious acitivty
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });
    }
    /**
     * Set notification list to recyclerView
     */
    private void prepareNotificationList() {
        NotificationModel notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", true);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", true);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", true);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        notificationModel = new NotificationModel("Practice 2: Rotational Motion","Yesterday", false);
        listNotification.add(notificationModel);

        mAdapterNotification.notifyDataSetChanged();
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

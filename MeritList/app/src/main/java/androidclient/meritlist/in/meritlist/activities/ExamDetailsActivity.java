package androidclient.meritlist.in.meritlist.activities;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.ExamTabPagerAdapter;
import androidclient.meritlist.in.meritlist.adapters.NotificationAdapter;
import androidclient.meritlist.in.meritlist.constants.Constants;
import androidclient.meritlist.in.meritlist.models.HistoryModel;
import androidclient.meritlist.in.meritlist.models.QuestionModel;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ExamDetailsActivity extends AppCompatActivity {

    //Components----------------------------------
    private Toolbar toolbar;
    private ArrayList<QuestionModel> listQuestion = new ArrayList<QuestionModel> ();
    private ExamTabPagerAdapter mAdapterQuestion;
    private TabLayout mPagerTitleTab;
    private TabLayout mTabLayoutAnswerOptions;

    private List<View> viewOptionViews;
    private List<TextView> tvOptionTitles;
    private List<TextView> tvOptionBodies;
    private List<ImageView> ivOptionLines;
    private int perviousOptionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_exam_details);

        //Setup View method call
        setupView();
    }

    /**
     * Setup View components
     */
    private void setupView() {
        //Initalize Components
        toolbar = (Toolbar) findViewById(R.id.toolbar_exam_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mPagerTitleTab = (TabLayout) findViewById (R.id.tl_exam_details);
        mAdapterQuestion = new ExamTabPagerAdapter (getSupportFragmentManager(), mPagerTitleTab, listQuestion);
        ViewPager pager = (ViewPager) findViewById(R.id.vp_exam_details);
        pager.setAdapter(mAdapterQuestion);
        mPagerTitleTab.setupWithViewPager (pager);
        mTabLayoutAnswerOptions = (TabLayout) findViewById(R.id.tabl_question_answer_options);
        setupTabAnswerOptions(Constants.OPTION_TYPE_SINGLECHOICE, 3);


        //Install custom fonts via Calligraphy library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        //Set on clickllisteners of the components
        setOnClickListeners();

        //Set list data
        prepareHistoryData();
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
     * Set recommendation list to recyclerView
     */
    private void prepareHistoryData() {
        QuestionModel questionModel = new QuestionModel ("Practice 2: Rotational Motion", 1);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 2);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 1);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        questionModel = new QuestionModel ("Practice 3: Atomic Structure", 0);
        listQuestion.add(questionModel);

        mAdapterQuestion.notifyDataSetChanged();
    }

    /**
     * Setup tab details for answer options
     */
    public void setupTabAnswerOptions(int questionType, int optionCount) {
        //Clear existing all tabs
        mTabLayoutAnswerOptions.removeAllTabs ();
        //Setup new tabs based on question
        for (int i = 0; i < optionCount; i++){
            View viewTab = LayoutInflater.from(ExamDetailsActivity.this)
                    .inflate(R.layout.layout_question_answer_options_custom_tab_item, mTabLayoutAnswerOptions, false);
            TextView titleTab = (TextView) viewTab.findViewById(R.id.tv_question_option_title);
            TextView bodyTab = (TextView) viewTab.findViewById(R.id.tv_question_option_body);
            ImageView lineTab = (ImageView) viewTab.findViewById (R.id.iv_line_question_option_line);

            if(questionType == Constants.OPTION_TYPE_MATRIX){
                bodyTab.setVisibility (View.VISIBLE);
                lineTab.setVisibility (View.VISIBLE);
            }else {
                bodyTab.setVisibility (View.GONE);
                lineTab.setVisibility (View.GONE);
            }

//            viewOptionViews.add (viewTab);
//            tvOptionTitles.add (titleTab);
//            tvOptionBodies.add (bodyTab);
//            ivOptionLines.add (lineTab);

            mTabLayoutAnswerOptions.addTab(mTabLayoutAnswerOptions.newTab().setText ("Option1").setCustomView (viewTab));
        }
    }
}

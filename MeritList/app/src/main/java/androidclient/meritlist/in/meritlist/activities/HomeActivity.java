package androidclient.meritlist.in.meritlist.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.adapters.HomePagerAdapter;
import androidclient.meritlist.in.meritlist.fragments.AnalyticFragment;
import androidclient.meritlist.in.meritlist.fragments.DoubtFragment;
import androidclient.meritlist.in.meritlist.fragments.HelpFragment;
import androidclient.meritlist.in.meritlist.fragments.HistoryFragment;
import androidclient.meritlist.in.meritlist.fragments.HomeFragment;
import androidclient.meritlist.in.meritlist.fragments.LeaderboardFragment;
import androidclient.meritlist.in.meritlist.fragments.NewsDetailsFragment;
import androidclient.meritlist.in.meritlist.fragments.PaperFragment;
import androidclient.meritlist.in.meritlist.fragments.PracticeFragment;
import androidclient.meritlist.in.meritlist.fragments.ProfileFragment;
import androidclient.meritlist.in.meritlist.fragments.ProgressFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private int[] tabIcons = {
            R.drawable.ic_tab_home,
            R.drawable.ic_tab_doubts,
            R.drawable.ic_tab_analytics,
            R.drawable.ic_tab_practice,
            R.drawable.ic_tab_papers};

    private Fragment mFragment;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Call setup view method
        setupView();
    }

    /**
     * Setup View components
     */
    private void setupView(){
        //Setup companents --------------------------------------------------------------
        mViewPager = (ViewPager) findViewById(R.id.viewpager_home);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabl_home);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

        fragmentManager = getSupportFragmentManager();

        //Install custom fonts via Calligraphy library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }

    /**
     * setup view pager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), getString(R.string.text_tab_home));
        adapter.addFrag(new DoubtFragment(), getString(R.string.text_tab_doubts));
        adapter.addFrag(new AnalyticFragment(), getString(R.string.text_tab_analytics));
        adapter.addFrag(new PracticeFragment(), getString(R.string.text_tab_practice));
        adapter.addFrag(new PaperFragment(), getString(R.string.text_tab_papers));
        viewPager.setAdapter(adapter);
    }

    /**
     * Setup tab icons
     */
    private void setupTabIcons() {
        AppCompatTextView tabHome = (AppCompatTextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tab, null);
        tabHome.setText(getString(R.string.text_tab_home));
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[0], 0, 0);
        mTabLayout.getTabAt(0).setCustomView(tabHome);

        AppCompatTextView tabDoubts = (AppCompatTextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tab, null);
        tabDoubts.setText(getString(R.string.text_tab_doubts));
        tabDoubts.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[1], 0, 0);
        mTabLayout.getTabAt(1).setCustomView(tabDoubts);

        AppCompatTextView tabAnalytics = (AppCompatTextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tab, null);
        tabAnalytics.setText(getString(R.string.text_tab_analytics));
        tabAnalytics.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[2], 0, 0);
        mTabLayout.getTabAt(2).setCustomView(tabAnalytics);

        AppCompatTextView tabPractice = (AppCompatTextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tab, null);
        tabPractice.setText(getString(R.string.text_tab_practice));
        tabPractice.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[3], 0, 0);
        mTabLayout.getTabAt(3).setCustomView(tabPractice);

        AppCompatTextView tabPapers = (AppCompatTextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tab, null);
        tabPapers.setText(getString(R.string.text_tab_papers));
        tabPapers.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[4], 0, 0);
        mTabLayout.getTabAt(4).setCustomView(tabPapers);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notifications) {
            Intent intentNotification = new Intent(this, NotificatonsActivity.class);
            startActivity(intentNotification);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            //Call method open profile fragment
            openProfile();
        } else if (id == R.id.nav_home) {
            //Call method to remove current fragment and open home
            removeCurrentFragment();
        } else if (id == R.id.nav_progress) {
            //Call method open progress fragment
            openProgress();
        } else if (id == R.id.nav_leaderboard) {
            //Call method open leaderboard fragment
            openLeaderboard();
        } else if (id == R.id.nav_history) {
            //Call method open history fragment
            openHistory();
        } else if (id == R.id.nav_help) {
            //Call method open help fragment
            openHelp();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
     * Open Profile Fragment
     */
    public void openProfile() {
        mFragment = new ProfileFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.frame_home_content, mFragment);
        fragmentTransaction.addToBackStack(ProfileFragment.TAG);
        if (!this.isFinishing())
            fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Open Profile Fragment
     */
    public void openProgress() {
        mFragment = new ProgressFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.frame_home_content, mFragment);
        fragmentTransaction.addToBackStack(ProfileFragment.TAG);
        if (!this.isFinishing())
            fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Open Leaderboard Fragment
     */
    public void openLeaderboard() {
        mFragment = new LeaderboardFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.frame_home_content, mFragment);
        fragmentTransaction.addToBackStack(ProfileFragment.TAG);
        if (!this.isFinishing())
            fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Open History Fragment
     */
    public void openHistory() {
        mFragment = new HistoryFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.frame_home_content, mFragment);
        fragmentTransaction.addToBackStack(ProfileFragment.TAG);
        if (!this.isFinishing())
            fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Open Help Fragment
     */
    public void openHelp() {
        mFragment = new HelpFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.frame_home_content, mFragment);
        fragmentTransaction.addToBackStack(ProfileFragment.TAG);
        if (!this.isFinishing())
            fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Open NEws Fragment
     */
    public void openNews() {
        mFragment = new NewsDetailsFragment ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.frame_home_content, mFragment);
        fragmentTransaction.addToBackStack(ProfileFragment.TAG);
        if (!this.isFinishing())
            fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Remove current fragment and open home
     */
    private void removeCurrentFragment() {
        Fragment fr = fragmentManager.findFragmentById(R.id.frame_home_content);
        if (fr != null) {
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right).remove(fr).commit();
            mFragment = null;
        }
    }


    /**
     * Open ExamDetails activity method
     */
    public void openExamDetails(){
        Intent intenOpenExamDetails = new Intent(HomeActivity.this, ExamDetailsActivity.class);
        startActivity(intenOpenExamDetails);
    }

    /**
     * Translate and hide toolbar and tabs
     */
    public void hideTabsandToolbar(){
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator ()).start();
    }

    /**
     * Translate and show toolbar and tabs
     */
    public void showTabsandToolbar(){
        toolbar.animate().translationY(-toolbar.getBottom()).setInterpolator(new AccelerateInterpolator ()).start();
    }
}

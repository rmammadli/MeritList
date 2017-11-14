package androidclient.meritlist.in.meritlist.adapters;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import androidclient.meritlist.in.meritlist.constants.Constants;
import androidclient.meritlist.in.meritlist.fragments.IntroFragment;

/**
 * Created by rmammadov on 5/13/16.
 */
public class IntroPagerAdapter extends FragmentPagerAdapter {

    public IntroPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#7978AD"), position); // blue
            case 1:
                return IntroFragment.newInstance(Color.parseColor("#7978AD"), position); // blue
            case 2:
                return IntroFragment.newInstance(Color.parseColor("#7978AD"), position); // blue
            default:
                return IntroFragment.newInstance(Color.parseColor("#7978AD"), position); // green
        }
    }

    /***
     *
     * @returns Intro pages count
     */
    @Override
    public int getCount() {
        return Constants.PAGE_COUNT;
    }
}

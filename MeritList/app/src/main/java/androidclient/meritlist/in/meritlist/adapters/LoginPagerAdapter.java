package androidclient.meritlist.in.meritlist.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import androidclient.meritlist.in.meritlist.fragments.SignInFragment;
import androidclient.meritlist.in.meritlist.fragments.SignUpFragment;

/**
 * Created by rmammadov on 5/13/16.
 */
public class LoginPagerAdapter extends FragmentPagerAdapter {

    public LoginPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {
            case 0: return SignUpFragment.newInstance();
            default: return SignInFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

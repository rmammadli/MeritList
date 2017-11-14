package androidclient.meritlist.in.meritlist.adapters;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import java.util.List;

import androidclient.meritlist.in.meritlist.fragments.QuestionFragment;
import androidclient.meritlist.in.meritlist.models.QuestionModel;

/**
 * Created by rmammadov on 5/31/16.
 */
public class ExamTabPagerAdapter extends FragmentPagerAdapter {
    private List<QuestionModel> listQuestions;
    private String questionID;
    private int questionStatus;
    private TabLayout mPagerTitleTab;

    public ExamTabPagerAdapter(FragmentManager fm, TabLayout mPagerTitleTab, List<QuestionModel> listQuestions) {
        super (fm);
        this.listQuestions = listQuestions;
        this.mPagerTitleTab = mPagerTitleTab;
    }

    @Override
    public Fragment getItem(int position) {
        QuestionModel questionModel = listQuestions.get (position);
        questionID = questionModel.getQuestionID ();
        questionStatus = questionModel.getQuestionStatus ();
        Spannable wordtoSpan = new SpannableString (String.valueOf (position + 1));
//        if (questionStatus == 1) {
//            wordtoSpan.setSpan (new ForegroundColorSpan (Color.BLUE), 0, wordtoSpan.length () - 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//            mPagerTitleTab.getTabAt (position).setText (wordtoSpan);
//        } else if (questionStatus == 2) {
//            mPagerTitleTab.getTabAt (position).setText ("10");
//        } else if (questionStatus == 0) {
//            mPagerTitleTab.getTabAt (position).setText ("10");
//        }
        return QuestionFragment.newInstance (position + 1, questionID, questionStatus);
    }

    @Override
    public int getCount() {
        return listQuestions.size ();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "" + (position + 1);
    }
}

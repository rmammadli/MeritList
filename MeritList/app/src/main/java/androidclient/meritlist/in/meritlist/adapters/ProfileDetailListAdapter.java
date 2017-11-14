package androidclient.meritlist.in.meritlist.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.fragments.ProfileFragment;
import androidclient.meritlist.in.meritlist.models.ProfileDetailsModel;

/**
 * Created by rmammadov on 5/18/16.
 */

/**
 * Adapter class extends with BaseAdapter and implements with OnClickListener
 */
public class ProfileDetailListAdapter extends BaseAdapter implements View.OnClickListener {

    /***********
     * Declare Used Variables
     *********/
    private Activity activity;
    private ProfileFragment fragment;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    ProfileDetailsModel tempValues = null;
    int i = 0;

    /*************
     * CustomAdapter Constructor
     *****************/
    public ProfileDetailListAdapter(Activity a, ProfileFragment f, ArrayList d) {

        /********** Take passed values **********/
        activity = a;
        data = d;
        fragment = f;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (data.size() <= 0)
            return 1;

        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /******
     * Depends upon data size called for each row , Create each ListView row
     *****/
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.layout_profile_list_item, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.tvDetailName = (AppCompatTextView) vi.findViewById(R.id.tv_detailname_list);
            holder.tvDetailData = (AppCompatTextView) vi.findViewById(R.id.tv_detaildata_list);

            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();

        if (data.size() <= 0) {
            holder.tvDetailName.setText("No Data");

        } else {
            /***** Get each Model object from Arraylist ********/
            tempValues = null;
            tempValues = (ProfileDetailsModel) data.get(position);

            /************  Set Model values in Holder elements ***********/
            holder.tvDetailName.setText(tempValues.getDetailName());
            holder.tvDetailData.setText(tempValues.getDetilData());


            /******** Set Item Click Listner for LayoutInflater for each row *******/
            vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    /*********
     * Called when Item click in ListView
     ************/
    private class OnItemClickListener implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {
            fragment.showEditDialog(mPosition);
        }
    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {
        public AppCompatTextView tvDetailName;
        public AppCompatTextView tvDetailData;
    }
}

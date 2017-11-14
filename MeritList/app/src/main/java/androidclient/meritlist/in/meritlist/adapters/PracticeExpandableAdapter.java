package androidclient.meritlist.in.meritlist.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.PracticeModelChild;
import androidclient.meritlist.in.meritlist.models.PracticeModelGroup;

/**
 * Created by rmammadov on 5/24/16.
 */
public class PracticeExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<PracticeModelGroup> listDataHeader;
    // child data in format of header title, child title
    private HashMap<PracticeModelGroup, List<PracticeModelChild>> listDataChild;


    public PracticeExpandableAdapter(Context context, List<PracticeModelGroup> listDataHeader,
                                 HashMap<PracticeModelGroup, List<PracticeModelChild>> listDataChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        PracticeModelChild practiceModelChild = (PracticeModelChild) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_practice_list_item, null);
        }

        AppCompatTextView txtListChild = (AppCompatTextView) convertView
                .findViewById(R.id.tv_practice_name_practice_list_item);

        AppCompatCheckBox cbSelected = (AppCompatCheckBox) convertView
                .findViewById(R.id.cb_practice_status_practice_list_item);

        txtListChild.setText(practiceModelChild.getSubject().toString());
        cbSelected.setChecked(practiceModelChild.getIsChecked());

        return convertView;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        PracticeModelGroup practiceModelGroup = (PracticeModelGroup) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_practice_list_group, null);
        }

        AppCompatTextView txtListHeader = (AppCompatTextView) convertView
                .findViewById(R.id.tv_list_group_title_practice_list_group);
        txtListHeader.setText(practiceModelGroup.getGroupName());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

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

import java.util.HashMap;
import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.PaperModelChild;
import androidclient.meritlist.in.meritlist.models.PaperModelGroup;
import androidclient.meritlist.in.meritlist.models.PracticeModelChild;
import androidclient.meritlist.in.meritlist.models.PracticeModelGroup;

/**
 * Created by rmammadov on 5/24/16.
 */
public class PaperExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<PaperModelGroup> listDataHeader;
    // child data in format of header title, child title
    private HashMap<PaperModelGroup, List<PaperModelChild>> listDataChild;


    public PaperExpandableAdapter(Context context, List<PaperModelGroup> listDataHeader,
                                  HashMap<PaperModelGroup, List<PaperModelChild>> listDataChild) {
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

        PaperModelChild paperModelChild = (PaperModelChild) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_paper_list_item, null);
        }

        AppCompatTextView txtListChild = (AppCompatTextView) convertView
                .findViewById(R.id.tv_paper_name_paper_list_item);
        AppCompatImageView ivDone = (AppCompatImageView) convertView
                .findViewById(R.id.iv_paper_status_done_paper_list_item);
        AppCompatImageView ivNotDone = (AppCompatImageView) convertView
                .findViewById(R.id.iv_paper_status_not_done_paper_list_item);

        txtListChild.setText(paperModelChild.getSubject().toString());

        if(paperModelChild.getIsDone()) {
            ivDone.setVisibility(View.VISIBLE);
            ivNotDone.setVisibility(View.GONE);
        }else{
            ivDone.setVisibility(View.GONE);
            ivNotDone.setVisibility(View.VISIBLE);
        }
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
        PaperModelGroup paperModelGroup = (PaperModelGroup) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_paper_list_group, null);
        }

        AppCompatTextView txtListHeader = (AppCompatTextView) convertView
                .findViewById(R.id.tv_list_group_title_paper_list_group);
        txtListHeader.setText(paperModelGroup.getGroupName());

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

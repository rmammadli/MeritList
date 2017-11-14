package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.constants.Constants;
import androidclient.meritlist.in.meritlist.models.HelpModel;
import androidclient.meritlist.in.meritlist.models.HomeModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //On item click interface
    public interface OnItemClickListener {
        void onItemClick(HomeModel item);
    }

    private List<HomeModel> listHome;
    private int viewType;
    private View itemView;
    private final OnItemClickListener listener;

    public class MyViewHolderHeader extends RecyclerView.ViewHolder {
        public AppCompatTextView textTitleHeader;

        public MyViewHolderHeader(View view) {
            super(view);
            textTitleHeader = (AppCompatTextView) view.findViewById(R.id.tv_title_home_list_header_item);
        }
    }

    public class MyViewHolderItem extends RecyclerView.ViewHolder {
        public AppCompatTextView textTitle;
        public RelativeLayout rlHomeListItem;

        public MyViewHolderItem(View view) {
            super(view);
            textTitle = (AppCompatTextView) view.findViewById(R.id.tv_title_home_list_item);
            rlHomeListItem = (RelativeLayout) view.findViewById (R.id.rl_home_list_item);
        }

        public void bind(final HomeModel item, final OnItemClickListener listener) {
            rlHomeListItem.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public HomeAdapter(List<HomeModel> listHome, OnItemClickListener listener) {
        this.listHome = listHome;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        //Return item type
        HomeModel homeModel = listHome.get(position);
        return homeModel.getViewType ();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case Constants.VIEW_TYPE_HEADER:
                itemView = LayoutInflater.from (parent.getContext ())
                        .inflate (R.layout.layout_home_list_header_item, parent, false);
                viewHolder = new  MyViewHolderHeader (itemView);
                break;
            default:
                itemView = LayoutInflater.from (parent.getContext ())
                        .inflate (R.layout.layout_home_list_item, parent, false);
                viewHolder = new MyViewHolderItem (itemView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        HomeModel homeModel = listHome.get(position);
        switch (viewHolder.getItemViewType()) {
            case Constants.VIEW_TYPE_HEADER:
                MyViewHolderHeader viewHolderHeader = (MyViewHolderHeader) viewHolder;
                ((MyViewHolderHeader) viewHolder).textTitleHeader.setText (homeModel.getTitle ());
                break;
            default:
                MyViewHolderItem viewHolderItem = (MyViewHolderItem) viewHolder;
                ((MyViewHolderItem) viewHolder).textTitle.setText (homeModel.getTitle ());
                ((MyViewHolderItem) viewHolder).bind (homeModel, listener);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listHome.size();
    }
}

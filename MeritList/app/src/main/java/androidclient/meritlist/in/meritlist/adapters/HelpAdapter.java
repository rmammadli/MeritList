package androidclient.meritlist.in.meritlist.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidclient.meritlist.in.meritlist.R;
import androidclient.meritlist.in.meritlist.models.HelpModel;

/**
 * Created by rmammadov on 5/17/16.
 */
public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.MyViewHolder> {

    private List<HelpModel> listHelp;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textHelpDescription;

        public MyViewHolder(View view) {
            super(view);
            textHelpDescription = (AppCompatTextView) view.findViewById(R.id.tv_description_help_list_item);
        }
    }

    public HelpAdapter(List<HelpModel> listHelp) {
        this.listHelp = listHelp;
    }

    @Override
    public HelpAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_help_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HelpAdapter.MyViewHolder holder, int position) {
        HelpModel helpModel = listHelp.get(position);
        holder.textHelpDescription.setText(helpModel.getHelpDescription());
    }

    @Override
    public int getItemCount() {
        return listHelp.size();
    }
}

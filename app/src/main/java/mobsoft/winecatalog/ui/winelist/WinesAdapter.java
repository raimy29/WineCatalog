package mobsoft.winecatalog.ui.winelist;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by eraikon on 5/1/2016.
 */
public class WinesAdapter extends RecyclerView.Adapter<WinesAdapter.ViewHolder> {

    private Context context;
    private List<Wine> wineList;

    public WinesAdapter(Context context, List<Wine> wineList) {
        this.context = context;
        this.wineList = wineList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_details, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wine wine = wineList.get(position);
        holder.tvName.setText(wine.getName());
        holder.tvDetailSummary.setText(wine.getWinery().toString());
    }

    @Override
    public int getItemCount() {
        return wineList.size();
    }

    public Wine getItem(int position) {
        return wineList.get(position);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDetailSummary;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDetailSummary = (TextView) itemView.findViewById(R.id.tvWinery);
        }
    }
}
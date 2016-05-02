package mobsoft.winecatalog.ui.winelist;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by Raimy on 5/1/2016.
 */
public class WinesAdapter extends ArrayAdapter<Wine> {

    public WinesAdapter(Context context, int textViewResoruceId, List<Wine> wineList) {
        super(context, textViewResoruceId, wineList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Wine wine = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.wine_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.winery = (TextView) convertView.findViewById(R.id.tvWinery);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(wine.getName());
        viewHolder.winery.setText(wine.getWinery());
        return convertView;
    }


    private static class ViewHolder {
        TextView name;
        TextView winery;
    }
}
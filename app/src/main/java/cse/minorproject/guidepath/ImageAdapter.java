package cse.minorproject.guidepath;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Arihant Jain on 06/10/2015.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public Integer[] mThumbIds = {
            R.drawable.icon_gps, R.drawable.metro_logo, R.drawable.dtc_logo,
            R.drawable.rupee_symbol, R.drawable.help_icon, android.R.drawable.ic_menu_info_details
    };

    public String[] itemTexts = {
            "Nearest Stop", "Delhi Metro", "DTC", "Fare", "Help", "About"
    };

    public ImageAdapter(Context c, Integer[] mThumbIds, String[] itemTexts){

        mContext = c;
        this.mThumbIds = mThumbIds;
        this.itemTexts = itemTexts;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if(convertView == null){
            gridView = inflater.inflate(R.layout.item, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_item_text);
            imageView.setImageResource(mThumbIds[position]);
            textView.setText(itemTexts[position]);
        }else{
            gridView = (View) convertView;
        }
        return gridView;

    }
}

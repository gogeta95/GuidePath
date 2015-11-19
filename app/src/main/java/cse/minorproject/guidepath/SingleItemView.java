package cse.minorproject.guidepath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Arihant Jain on 06/10/2015.
 */
public class SingleItemView extends Activity {

    public Integer[] mThumbIds = {
            R.drawable.icon_gps, R.drawable.metro_logo, R.drawable.dtc_logo,
            R.drawable.rupee_symbol, R.drawable.help_icon, android.R.drawable.ic_menu_info_details
    };

    public String[] itemTexts = {
            "Nearest Stop", "Delhi Metro", "DTC", "Fare", "Help", "About"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item_view);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this, mThumbIds, itemTexts);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        //TextView textView = (TextView) findViewById(R.id.grid_item_text);

        imageView.setImageResource(imageAdapter.mThumbIds[position]);
        //textView.setText(imageAdapter.itemTexts[position]);
    }
}

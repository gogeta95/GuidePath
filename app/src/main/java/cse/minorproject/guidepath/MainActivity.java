package cse.minorproject.guidepath;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    public Integer[] mThumbIds = {
            R.drawable.place_symbol, R.drawable.metro_rounded, R.mipmap.dtc_logo,
            R.mipmap.rupee_symbol, R.mipmap.stop, R.mipmap.ic_menu_info_details
    };

    public String[] itemTexts = {
            "Nearest Stop", "Metro Map", "DTC", "Fare", "Bus Route", "About"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, mThumbIds, itemTexts));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:
                        Intent i0 = new Intent(MainActivity.this, NearestStop.class);
                        i0.putExtra("id", position);
                        startActivity(i0);
                        break;
                    case 1:
                        Intent i1 = new Intent(MainActivity.this, MetroMapActivity.class);


                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(MainActivity.this, BusInfo.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(MainActivity.this, FareActivity.class);

                        i3.putExtra("id", position);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(MainActivity.this, StopACtivity.class);


                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(MainActivity.this, About.class);
                        startActivity(i5);
                    default:
                        break;


                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_rate:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID));
                startActivity(intent);
                return true;
            case R.id.action_feedback:
                Intent mailintent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("arihantjain10111993@gmail.com") +
                        "?subject=" + Uri.encode("Guide Path App");
                Uri uri = Uri.parse(uriText);
                mailintent.setData(uri);
                startActivity(mailintent);
                return true;
            case R.id.action_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String s = "An Easy way to navigate for Delhiites. ";
                sendIntent.putExtra(Intent.EXTRA_TEXT, s + " https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return true;
            case R.id.action_help:
                startActivity(new Intent(this,HelpActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

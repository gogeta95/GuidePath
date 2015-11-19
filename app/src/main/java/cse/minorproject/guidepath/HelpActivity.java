package cse.minorproject.guidepath;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Arihant Jain on 15/10/2015.
 */
public class HelpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);

    }

    public void DTCwebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.delhi.gov.in/wps/wcm/connect/doit_dtc/DTC/Home"));
        startActivity(intent);
    }

    public void Metrowebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.delhimetrorail.com/"));
        startActivity(intent);
    }

    public void Airport(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.delhimetrorail.com/Airport-Express-Line.aspx"));
        startActivity(intent);
    }

    public void ISBTInfo(View view) {
        startActivity(new Intent(this,ISBTInfo.class));
    }
}

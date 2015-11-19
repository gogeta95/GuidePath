package cse.minorproject.guidepath;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class FareActivity extends AppCompatActivity {
    FareDB fareDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        final TextInputLayout start = (TextInputLayout) findViewById(R.id.start);
        final TextInputLayout end = (TextInputLayout) findViewById(R.id.end);
        final String stations[] = {FareDB.INDERLOK, FareDB.SHASTRI_NAGAR, FareDB.PRATAP_NAGAR, FareDB.PUL_BANGASH, FareDB.TIS_HAZARI};
        final ArrayAdapter<String> list = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, stations);
        ((AutoCompleteTextView) start.getEditText()).setAdapter(list);
        ((AutoCompleteTextView) end.getEditText()).setAdapter(list);
        fareDB= new FareDB(this);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int fare=fareDB.getFare(start.getEditText().getText().toString(), end.getEditText().getText().toString());
                    new AlertDialog.Builder(FareActivity.this)
                            .setTitle(start.getEditText().getText().toString() + " ↔ "+end.getEditText().getText().toString())
                            .setMessage("Fare: "+fare+" Rs").setPositiveButton("OK",null).create().show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fareDB.close();
    }
}

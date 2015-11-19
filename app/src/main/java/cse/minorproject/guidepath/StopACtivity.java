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

public class StopACtivity extends AppCompatActivity {
    BusInfoDb infoDb;

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
        final ArrayAdapter<String> list = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, BusInfoDb.stops);
        ((AutoCompleteTextView) start.getEditText()).setAdapter(list);
        ((AutoCompleteTextView) end.getEditText()).setAdapter(list);
        infoDb = new BusInfoDb(this);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s[] = infoDb.getBusesByStop(start.getEditText().getText().toString(), end.getEditText().getText().toString());
                    StringBuilder sb = new StringBuilder();
                    for (String s1 : s) {
                        sb.append(s1).append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    new AlertDialog.Builder(StopACtivity.this)
                            .setTitle(start.getEditText().getText().toString() + " ↔ " + end.getEditText().getText().toString())
                            .setMessage("Buses: " + sb).setPositiveButton("OK", null).create().show();
                } catch (Exception e) {
                    new AlertDialog.Builder(StopACtivity.this)
                            .setTitle(start.getEditText().getText().toString() + " ↔ " + end.getEditText().getText().toString())
                            .setMessage("No Buses found for this Route.").setPositiveButton("OK", null).create().show();
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
        infoDb.close();
    }
}

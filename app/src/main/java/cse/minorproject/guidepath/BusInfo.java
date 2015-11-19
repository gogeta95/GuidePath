package cse.minorproject.guidepath;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;


public class BusInfo extends AppCompatActivity {
    ImageButton b1;
    AutoCompleteTextView t1;
    RecyclerView recyclerView;
    TextView not_found;
    BusInfoDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.parseColor("#1B5E20"));
        }
        db = new BusInfoDb(this);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,db.getBusNos());
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        b1 = (ImageButton) findViewById(R.id.search_button);
        not_found = (TextView) findViewById(R.id.not_found);
        not_found.setVisibility(View.GONE);
        t1 = (AutoCompleteTextView) findViewById(R.id.search_bar);
        t1.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findBus();
            }
        });

    }

    public void findBus() {
        Bus bus = db.getBus(t1.getText().toString());

        if (bus != null) {
            String[] stops = bus.getRoute();
            not_found.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.swapAdapter(new RecyclerAdapter(stops, this), true);
        } else {
            recyclerView.setVisibility(View.GONE);
            not_found.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}

class RecyclerAdapter extends RecyclerView.Adapter<StopViewHolder> {
    String[] stops;
    LayoutInflater inflater;


    public RecyclerAdapter(String[] stops, Context context) {
        this.stops = stops;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public StopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StopViewHolder(inflater.inflate(R.layout.bus_item, parent, false));
    }

    @Override
    public void onBindViewHolder(StopViewHolder holder, int position) {
        holder.stop.setText(stops[position]);
    }

    @Override
    public int getItemCount() {
        return stops == null ? 0 : stops.length;
    }
}

class StopViewHolder extends RecyclerView.ViewHolder {
    TextView stop;

    public StopViewHolder(View itemView) {
        super(itemView);
        stop = (TextView) itemView.findViewById(R.id.text);
    }
}
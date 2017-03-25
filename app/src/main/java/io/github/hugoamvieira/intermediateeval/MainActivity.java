package io.github.hugoamvieira.intermediateeval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Create locations list
    GeolocationElement[] locations = new GeolocationElement[]{
            new GeolocationElement("Porto", R.mipmap.ic_launcher_round, new double[]{41.1628634, -8.6568724}),
            new GeolocationElement("Lisbon", R.mipmap.ic_launcher_round, new double[]{38.7436214, -9.1952231}),
            new GeolocationElement("London", R.mipmap.ic_launcher_round, new double[]{51.5285582, -0.24168}),
            new GeolocationElement("Madrid", R.mipmap.ic_launcher_round, new double[]{40.4378698, -3.8196193}),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create ArrayAdapter for GeolocationElement array
        ArrayAdapter<GeolocationElement> mAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, locations);


        // Get list view from xml, set adapter and on item click listener
        ListView mLocationsList = (ListView) findViewById(R.id.locations_list);
        mLocationsList.setAdapter(mAdapter);

        mLocationsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), MapsActivity.class);
                i.putExtra("GeolocationElement", locations[position]);
                startActivity(i);
            }
        });
    }
}
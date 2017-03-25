package io.github.hugoamvieira.intermediateeval;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Get element
        final GeolocationElement obj = (GeolocationElement) getIntent().getSerializableExtra("GeolocationElement");
        final double[] coords = obj.getGeoCoords();

        // Set LatLng object
        LatLng location = new LatLng(coords[0], coords[1]);

        // Set map min zoom
        mMap.setMinZoomPreference(10.0f);

        // Create marker object
        mMap.addMarker(new MarkerOptions().position(location));

        // Move camera to defined lat/lng
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                new AlertDialog.Builder(MapsActivity.this).setTitle("Marker Info")
                        .setMessage("Place: " + obj.getPlaceName() +
                                "\nLatitude: " + coords[0] +
                                "\nLongitude: " + coords[1])
                        .setNeutralButton(android.R.string.ok, null)
                        .setIcon(obj.getImageRef())
                        .show();

                return true;
            }
        });
    }
}

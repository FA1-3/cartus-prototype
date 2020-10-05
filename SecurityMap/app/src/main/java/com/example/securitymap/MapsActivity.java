package com.example.securitymap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity<ADELAIDE> extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
//45.425490, -75.689445, 45.418436, -75.675062
    private LatLngBounds UOTTAWA = new LatLngBounds(new LatLng(45.418436, -75.689445), new LatLng(45.425490, -75.675062));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // 45.425490, -75.689445, 45.418436, -75.675062
        LatLng cby = new LatLng(45.419754, -75.679601);
        mMap.addMarker(new MarkerOptions().position(cby).title("Marker at CBY"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(cby));
        mMap.setLatLngBoundsForCameraTarget(UOTTAWA);
        mMap.setMinZoomPreference(15);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(45.421963, -75.682235) , 16) );
    }
}
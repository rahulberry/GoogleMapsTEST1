package com.example.rahulberry.googlemaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static MapsActivity inst;
    private GoogleMap mMap;
    private LocationManager manager;
    private LocationListener locationListener;

    LocationManager locationManager;

    public static MapsActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //This code above checks whether the user has given permission to give their location.
        //The if statement below checks if the network provider is enabled
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER )){
            //The parameters below are (provider(CAN BE GPS), time between updates, distance between updates, locationlistener is an interface which contains the standard methods that were developed below)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                //the moment the class  is triggered the reference variable, location is given the lat and lng
                public void onLocationChanged(Location location) {
                    //get latitude
                    double latitude = location.getLatitude();
                    //get longitude
                    double longitude = location.getLongitude();
                    //instantiate the class, LatLng
                    LatLng latLng = new LatLng(latitude, longitude);
                    //instantiate the class, Geocoder. Geocoder converts the lat and long to meaningful address names;
                    Geocoder geocoder = new  Geocoder(getApplicationContext());
                    try {
                        //From the addressList below we can get the street name, country name, locality name etc
                        List <Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        //Over here we can even get postal code or a bunch of other information after addressList.get(0)
                        String  str = addressList.get(0).getLocality();
                        str+= addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((latLng), 10.2f));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } {

                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {
                    // method is trigerred when the provider is enabled
                }

                @Override
                public void onProviderDisabled(String provider) {
                    // method is trigerred when the provider is disabled

                }
            });
        }
        else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get latitude
                    double latitude = location.getLatitude();
                    //get longitude
                    double longitude = location.getLongitude();
                    //instantiate the class, LatLng
                    LatLng latLng = new LatLng(latitude, longitude);
                    //instantiate the class, Geocoder. Geocoder converts the lat and long to meaningful address names;
                    Geocoder geocoder = new  Geocoder(getApplicationContext());
                    try {
                        //From the addressList below we can get the street name, country name, locality name etc
                        List <Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        //Over here we can even get postal code or a bunch of other information after addressList.get(0)
                        String  str = addressList.get(0).getLocality();
                        str+= addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((latLng), 10.2f));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } {
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //The code that was generated when making the maps activity is commented out below:
        // Add a marker in London, and move the camera.
     //   LatLng london = new LatLng(51.5074, 0.1278);
     //   mMap.addMarker(new MarkerOptions().position(london).title("Marker in London"));
        // newlatlngzoom zooms into the pointer
      //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((london), 10.2f));


    }

    // this was in an example, I don't know what it does

    /*@Override
    protected void onPause() {
        super.onPause();
        manager.removeUpdates(locationListener);
        Log.i("onPause...","paused");
    }
   */
}
package shiv.com.jemtec;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    private static final int ERROR_DIALOG_REQUEST = 9001;
    GoogleMap mMap;
    private static final double
            JIMS_LAT = 28.466081,
            JIMS_LNG = 77.483265;
    private GoogleApiClient mLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (servicesOK()) {
            setContentView(R.layout.activity_maps);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
            actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
            drawerLayout.setDrawerListener(actionBarDrawerToggle);
            navigationView=(NavigationView)findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.aj_id:
                            Intent a=new Intent(getApplicationContext(),aboutjemtec.class);
                            startActivityForResult(a,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.course_id:
                            Intent c=new Intent(getApplicationContext(),course.class);
                            startActivityForResult(c,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.adm_id:
                            Intent adm=new Intent(getApplicationContext(),Admissions.class);
                            startActivityForResult(adm,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.stud_id:
                            Intent s=new Intent(getApplicationContext(),Students.class);
                            startActivityForResult(s,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_teach:
                            Intent f=new Intent(getApplicationContext(),Faculty.class);
                            startActivityForResult(f,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_not:
                            Toast.makeText(getApplicationContext(), "Notices was selected", Toast.LENGTH_SHORT).show();
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_gallery:
                            Intent g=new Intent(getApplicationContext(),Gallery.class);
                            startActivityForResult(g,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_campus:
                            Intent camp=new Intent(getApplicationContext(),CampusFacilities.class);
                            startActivityForResult(camp,0);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_map:
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_contact:
                            Intent i=new Intent(MapsActivity.this,Contact.class);
                            startActivity(i);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_feed:
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setData(Uri.parse("mailto"));
                            intent.setType("message/rfc822");
                            String[] send_to = {"mailtosemwal@gmail.com", "shivammj1994@gmail.com"};
                            intent.putExtra(Intent.EXTRA_EMAIL, send_to);
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback On App");
                            Intent chooser = Intent.createChooser(intent, "Select Email App");
                            if (intent.resolveActivity(getPackageManager()) != null) {
                                startActivity(chooser);
                            }
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_rate:
                            try {
                                Uri uri1 = Uri.parse("market://details?id=" + getPackageName());
                                Intent gotoMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                                startActivity(gotoMarket1);
                            } catch (ActivityNotFoundException e) {
                                Uri uri1 = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                                Intent gotoMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                                startActivity(gotoMarket1);
                            }
                            drawerLayout.closeDrawers();
                            break;
                    }
                    return false;
                }
            });
            if (initMap()) {
                gotoLocation(JIMS_LAT, JIMS_LNG, 18);
                setupmap();
                mLocationClient = new GoogleApiClient.Builder(this)
                        .addApi(LocationServices.API)
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .build();
                mLocationClient.connect();
            } else {
                Toast.makeText(this, "Map not connected!", Toast.LENGTH_SHORT).show();
            }

        } else {
            setContentView(R.layout.activity_main);
        }
    }

    private void setupmap()
    {
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.466081, 77.483265)).title("JEMTEC"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Add menu handling code
        switch (id) {
            case R.id.mapTypeNone:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
            case R.id.mapTypeNormal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.mapTypeSatellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapTypeTerrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.mapTypeHybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public boolean servicesOK() {

        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {
            Dialog dialog =
                    GooglePlayServicesUtil.getErrorDialog(isAvailable, this, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "Can't connect to mapping service", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    private boolean initMap() {
        if (mMap == null) {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mMap = mapFragment.getMap();
        }
        return (mMap != null);
    }

    private void gotoLocation(double lat, double lng, float zoom) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mMap.moveCamera(update);
    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager imm =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public void geoLocate(View v) throws IOException {

        hideSoftKeyboard(v);

        TextView tv = (TextView) findViewById(R.id.editText1);
        String searchString = tv.getText().toString();

        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(searchString, 1);

        if (list.size() > 0) {
            Address add = list.get(0);
            double lat = add.getLatitude();
            double lng = add.getLongitude();
            gotoLocation(lat, lng, 18);
        }
    }
    public void showCurrentLocation(MenuItem item) {
        try {
            Location currentLocation = LocationServices.FusedLocationApi.getLastLocation(mLocationClient);
            if (currentLocation == null) {
                Toast.makeText(this, "Couldn't connect!", Toast.LENGTH_SHORT).show();
            } else {
                LatLng latLng = new LatLng(
                        currentLocation.getLatitude(),
                        currentLocation.getLongitude()
                );
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(update);

            }} catch (SecurityException e) {
            Log.e("PERMISSION_EXCEPTION", "PERMISSION_NOT_GRANTED");
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Ready to map!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}

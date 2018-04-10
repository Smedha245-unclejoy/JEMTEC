package shiv.com.jemtec;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import javax.xml.parsers.FactoryConfigurationError;


public class CampusFacilities extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.facilities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
                        Intent ab = new Intent(CampusFacilities.this,aboutjemtec.class);
                        startActivity(ab);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.course_id:
                        Intent c = new Intent(CampusFacilities.this,course.class);
                        startActivity(c);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.adm_id:
                        Intent a = new Intent(CampusFacilities.this,Admissions.class);
                        startActivity(a);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.stud_id:
                        Intent s = new Intent(CampusFacilities.this,Students.class);
                        startActivity(s);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_teach:
                        Intent cm = new Intent(CampusFacilities.this,Faculty.class);
                        startActivity(cm);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_not:
                        Intent n = new Intent(CampusFacilities.this,Contact.class);
                        startActivity(n);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_gallery:
                        Intent g = new Intent(CampusFacilities.this,Gallery.class);
                        startActivity(g);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_campus:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_map:
                        Intent i = new Intent(CampusFacilities.this, MapsActivity.class);
                        startActivity(i);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_contact:
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




        String[] adm_list = getResources().getStringArray(R.array.camp_list);
        // Binding resources Array to ListAdapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_facilities, R.id.label, adm_list);
        final ListView lv = (ListView) findViewById(R.id.ListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {

                    Intent myIntent0 = new Intent(getApplicationContext(), library.class);
                    startActivityForResult(myIntent0, 0);
                }

                if (position == 1) {

                    Intent myIntent1 = new Intent(getApplicationContext(), Cafeteria.class);
                    startActivityForResult(myIntent1, 0);
                }
                if (position == 2) {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                            CampusFacilities.this);
                    builderSingle.setTitle("Select One Name:-");
                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                            CampusFacilities.this,
                            android.R.layout.select_dialog_singlechoice);
                    arrayAdapter.add("For Boys");
                    arrayAdapter.add("For Girls");

                    builderSingle.setNegativeButton("cancel",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    builderSingle.setAdapter(arrayAdapter,
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which == 0) {
                                        Intent intent = new Intent(getApplicationContext(), Hostel.class);
                                        startActivityForResult(intent, 0);
                                    }
                                    if (which == 1) {
                                        Intent intent2 = new Intent(getApplicationContext(), Hostel2.class);
                                        startActivityForResult(intent2, 0);
                                    }
                                }
                            });
                    builderSingle.create();
                    builderSingle.show();
                }

                if (position == 3)

                {
                    Intent myIntent3 = new Intent(getApplicationContext(), Transportation.class);
                    startActivityForResult(myIntent3, 0);
                }

                if (position == 4)

                {

                    Intent myIntent4 = new Intent(getApplicationContext(), EngineeringLab.class);
                    startActivityForResult(myIntent4, 0);
                }

                if (position == 5)

                {

                    Intent myIntent5 = new Intent(getApplicationContext(), Stationary.class);
                    startActivityForResult(myIntent5, 0);
                }


            }
        });


    }
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}

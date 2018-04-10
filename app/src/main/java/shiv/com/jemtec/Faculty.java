package shiv.com.jemtec;

import android.content.ActivityNotFoundException;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by medha singh on 4/11/2016.
 */
public class Faculty extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty);
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
                        Toast.makeText(getApplicationContext(), "About Us was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.course_id:
                        Toast.makeText(getApplicationContext(), "Course was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.adm_id:
                        Toast.makeText(getApplicationContext(), "Admissions was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.stud_id:
                        Toast.makeText(getApplicationContext(), "Student was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_teach:
                        Toast.makeText(getApplicationContext(), "Faculty was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_not:
                        Toast.makeText(getApplicationContext(), "Notices was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_gallery:
                        Toast.makeText(getApplicationContext(), "Gallery was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_campus:
                        Toast.makeText(getApplicationContext(), "Campus was selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_map:
                        Intent i = new Intent(Faculty.this, MapsActivity.class);
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

        String[] faculty_list = getResources().getStringArray(R.array.faculty_list);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, R.layout.faculty_item, R.id.label,faculty_list );
        ListView lv = (ListView)findViewById(R.id.ListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {

                    Intent myIntent0 = new Intent(getApplicationContext(), cse_card.class);
                    startActivityForResult(myIntent0, 0);
                }

                if (position == 1) {

                    Intent myIntent1 = new Intent(getApplicationContext(), ece_card.class);
                    startActivityForResult(myIntent1, 0);
                }
                if (position == 2) {

                    Intent myIntent2 = new Intent(getApplicationContext(), ee_card.class);
                    startActivityForResult(myIntent2, 0);
                }
                if (position == 3) {

                    Intent myIntent3 = new Intent(getApplicationContext(), civil_card.class);
                    startActivityForResult(myIntent3, 0);
                }
                if (position == 4) {

                    Intent myIntent4 = new Intent(getApplicationContext(), mech_card.class);
                    startActivityForResult(myIntent4, 0);
                }
                if (position == 5) {

                    Intent myIntent5 = new Intent(getApplicationContext(), sci_hu_card.class);
                    startActivityForResult(myIntent5, 0);
                }
                if (position == 6) {

                    Intent myIntent5 = new Intent(getApplicationContext(), ballb_card.class);
                    startActivityForResult(myIntent5, 0);
                }
                if (position == 7) {

                    Intent myIntent5 = new Intent(getApplicationContext(), bballb_card.class);
                    startActivityForResult(myIntent5, 0);
                }
                if (position == 8) {

                    Intent myIntent5 = new Intent(getApplicationContext(), bca_card.class);
                    startActivityForResult(myIntent5, 0);
                }
                if (position == 9) {

                    Intent myIntent5 = new Intent(getApplicationContext(), bed_card.class);
                    startActivityForResult(myIntent5, 0);
                }


            }
        });


    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

}

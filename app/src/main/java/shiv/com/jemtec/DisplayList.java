package shiv.com.jemtec;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class DisplayList extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        BackgroundTask backgroundTask = new BackgroundTask(DisplayList.this);
        backgroundTask.execute();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
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
                        Intent i = new Intent(DisplayList.this, MapsActivity.class);
                        startActivity(i);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_contact:
                        Intent j = new Intent(DisplayList.this, Contact.class);
                        startActivity(j);
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
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}


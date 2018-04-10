package shiv.com.jemtec;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class aboutjemtec extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_jemtec);
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
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.course_id:
                        Intent co = new Intent(aboutjemtec.this, course.class);
                        startActivity(co);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.adm_id:
                        Intent a = new Intent(aboutjemtec.this, Admissions.class);
                        startActivity(a);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.stud_id:
                        Intent s = new Intent(aboutjemtec.this, Students.class);
                        startActivity(s);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_teach:
                        Intent f = new Intent(aboutjemtec.this, Faculty.class);
                        startActivity(f);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_not:
                        Intent n = new Intent(aboutjemtec.this, Contact.class);
                        startActivity(n);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_gallery:
                        Intent g = new Intent(aboutjemtec.this, Gallery.class);
                        startActivity(g);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_campus:
                        Intent c = new Intent(aboutjemtec.this, CampusFacilities.class);
                        startActivity(c);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_map:
                        Intent m = new Intent(aboutjemtec.this, MapsActivity.class);
                        startActivity(m);
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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("About JIMS"));
        tabLayout.addTab(tabLayout.newTab().setText("Vision"));
        tabLayout.addTab(tabLayout.newTab().setText("Mission"));
        tabLayout.addTab(tabLayout.newTab().setText("Message by Chairman"));
        tabLayout.addTab(tabLayout.newTab().setText("Message by Director"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
       final android.support.v4.view.PagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}




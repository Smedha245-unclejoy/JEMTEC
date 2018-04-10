package shiv.com.jemtec;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class frontpage extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ib1=(ImageButton)findViewById(R.id.ib1);
        ib2=(ImageButton)findViewById(R.id.ib2);
        ib3=(ImageButton)findViewById(R.id.ib3);
        ib4=(ImageButton)findViewById(R.id.ib4);
        ib5=(ImageButton)findViewById(R.id.ib5);
        ib6=(ImageButton)findViewById(R.id.ib6);
        ib7=(ImageButton)findViewById(R.id.ib7);
        ib8=(ImageButton)findViewById(R.id.ib8);
        ib9=(ImageButton)findViewById(R.id.ib9);
        ib10=(ImageButton)findViewById(R.id.ib10);
        ib11=(ImageButton)findViewById(R.id.ib11);
        ib12=(ImageButton)findViewById(R.id.ib12);
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);
        ib6.setOnClickListener(this);
        ib7.setOnClickListener(this);
        ib8.setOnClickListener(this);
        ib9.setOnClickListener(this);
        ib10.setOnClickListener(this);
        ib11.setOnClickListener(this);
        ib12.setOnClickListener(this);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId())
                {
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
                        Intent k=new Intent(frontpage.this, DisplayList.class);
                        startActivity(k);
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
                        Intent j=new Intent(frontpage.this, MapsActivity.class);
                        startActivity(j);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_contact:
                        Intent i=new Intent(frontpage.this,Contact.class);
                        startActivity(i);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_feed:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setData(Uri.parse("mailto"));
                        intent.setType("message/rfc822");
                        String[] send_to={"mailtosemwal@gmail.com","shivammj1994@gmail.com"};
                        intent.putExtra(Intent.EXTRA_EMAIL,send_to);
                        intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback On App");
                       Intent chooser=Intent.createChooser(intent,"Select Email App");
                       if(intent.resolveActivity(getPackageManager())!=null)
                       {
                       startActivity(chooser);
                         }
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.id_rate:
                        try{
                            Uri uri1=Uri.parse("market://details?id="+getPackageName());
                            Intent gotoMarket1=new Intent(Intent.ACTION_VIEW,uri1);
                            startActivity(gotoMarket1);}catch (ActivityNotFoundException e){
                            Uri uri1=Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName());
                            Intent gotoMarket1=new Intent(Intent.ACTION_VIEW,uri1);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib1:
                Intent l=new Intent(frontpage.this, aboutjemtec.class);
                startActivity(l);
                break;
            case R.id.ib2:
                Intent m=new Intent(frontpage.this,course.class);
                startActivity(m);
                break;
            case R.id.ib3:
                Intent a=new Intent(frontpage.this,Admissions.class);
                startActivity(a);
                break;
            case R.id.ib4:
                Intent b=new Intent(frontpage.this,Students.class);
                startActivity(b);
                break;
            case R.id.ib5:
                Intent f=new Intent(frontpage.this,Faculty.class);
                startActivity(f);
                break;
            case R.id.ib6:
                Intent d=new Intent(frontpage.this,DisplayList.class);
                startActivity(d);
                break;
            case R.id.ib7:
                Intent g=new Intent(frontpage.this,Gallery.class);
                startActivity(g);
                break;
            case R.id.ib8:
                Intent c=new Intent(frontpage.this,CampusFacilities.class);
                startActivity(c);
                break;
            case R.id.ib9:
                Intent j=new Intent(frontpage.this, MapsActivity.class);
                startActivity(j);
                break;
            case R.id.ib10:
                Intent i=new Intent(frontpage.this,Contact.class);
                startActivity(i);
                break;
            case R.id.ib11:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto"));
                intent.setType("message/rfc822");
                String[] send_to={"mailtosemwal@gmail.com","shivammj1994@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,send_to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback On App");
                Intent chooser=Intent.createChooser(intent,"Select Email App");
                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(chooser);
                }
                break;
            case R.id.ib12:
                try{
                Uri uri1=Uri.parse("market://details?id="+getPackageName());
                Intent gotoMarket1=new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(gotoMarket1);}catch (ActivityNotFoundException e){
                    Uri uri1=Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName());
                    Intent gotoMarket1=new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(gotoMarket1);
                }
                break;
        }
    }
    public void Developer(MenuItem item)
    {
        Intent i=new Intent(frontpage.this,Contact.class);
        startActivity(i);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}

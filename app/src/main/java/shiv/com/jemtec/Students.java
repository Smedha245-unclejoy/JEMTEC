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
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Students extends AppCompatActivity{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students);
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
                        Intent i = new Intent(Students.this, MapsActivity.class);
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


        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                if (groupPosition == 0) {
                    switch (childPosition) {
                        case 0:
                            Intent intent0 = new Intent(getApplicationContext(), cse1.class);
                            startActivityForResult(intent0, 0);
                            break;
                        case 1:
                            Intent intent1= new Intent(getApplicationContext(),cse2.class);
                            startActivityForResult(intent1,0);
                            break;
                        case 2:
                            Intent intent2= new Intent(getApplicationContext(),cse3.class);
                            startActivityForResult(intent2,0);
                            break;
                        case 3:
                            Intent intent3= new Intent(getApplicationContext(),cse4.class);
                            startActivityForResult(intent3,0);
                            break;

                    }
                }
                if(groupPosition==1)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_ece0=new Intent(getApplicationContext(),ece1.class);
                            startActivityForResult(intent_ece0,0);
                            break;
                        case 1:
                            Intent intent_ece1=new Intent(getApplicationContext(),ece2.class);
                            startActivityForResult(intent_ece1,0);
                            break;
                        case 2:
                            Intent intent_ece2=new Intent(getApplicationContext(),ece3.class);
                            startActivityForResult(intent_ece2,0);
                            break;
                        case 3:
                            Intent intent_ece3=new Intent(getApplicationContext(),ece4.class);
                            startActivityForResult(intent_ece3,0);
                            break;
                    }
                }
                if(groupPosition==2)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_cv0=new Intent(getApplicationContext(),civil1.class);
                            startActivityForResult(intent_cv0,0);
                            break;
                        case 1:
                            Intent intent_cv1=new Intent(getApplicationContext(),civil2.class);
                            startActivityForResult(intent_cv1,0);
                            break;
                        case 2:
                            Intent intent_cv2=new Intent(getApplicationContext(),civil3.class);
                            startActivityForResult(intent_cv2,0);
                            break;
                        case 3:
                            Intent intent_cv3=new Intent(getApplicationContext(),civil4.class);
                            startActivityForResult(intent_cv3,0);
                            break;
                    }
                }
                if(groupPosition==3)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_me0=new Intent(getApplicationContext(),me1.class);
                            startActivityForResult(intent_me0,0);
                            break;
                        case 1:
                            Intent intent_me1=new Intent(getApplicationContext(),me2.class);
                            startActivityForResult(intent_me1,0);
                            break;
                        case 2:
                            Intent intent_me2=new Intent(getApplicationContext(),me3.class);
                            startActivityForResult(intent_me2,0);
                            break;
                        case 3:
                            Intent intent_me3=new Intent(getApplicationContext(),me4.class);
                            startActivityForResult(intent_me3,0);
                            break;
                    }
                }
                if(groupPosition==4)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_ee0=new Intent(getApplicationContext(),ee1.class);
                            startActivityForResult(intent_ee0,0);
                            break;
                        case 1:
                            Intent intent_ee1=new Intent(getApplicationContext(),ee2.class);
                            startActivityForResult(intent_ee1,0);
                            break;
                        case 2:
                            Intent intent_ee2=new Intent(getApplicationContext(),ee3.class);
                            startActivityForResult(intent_ee2,0);
                            break;
                        case 3:
                            Intent intent_ee3=new Intent(getApplicationContext(),ee4.class);
                            startActivityForResult(intent_ee3,0);
                            break;
                    }
                }
                if(groupPosition==5)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_bca0=new Intent(getApplicationContext(),bca1.class);
                            startActivityForResult(intent_bca0,0);
                            break;
                        case 1:
                            Intent intent_bca1=new Intent(getApplicationContext(),bca2.class);
                            startActivityForResult(intent_bca1,0);
                            break;
                        case 2:
                            Intent intent_bca2=new Intent(getApplicationContext(),bca3.class);
                            startActivityForResult(intent_bca2,0);
                            break;
                    }
                }
                if(groupPosition==6)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_ballb0=new Intent(getApplicationContext(),ballb1.class);
                            startActivityForResult(intent_ballb0,0);
                            break;
                        case 1:
                            Intent intent_ballb1=new Intent(getApplicationContext(),ballb2.class);
                            startActivityForResult(intent_ballb1,0);
                            break;
                        case 2:
                            Intent intent_ballb2=new Intent(getApplicationContext(),ballb3.class);
                            startActivityForResult(intent_ballb2,0);
                            break;
                    }
                }
                if(groupPosition==7)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_bballb1=new Intent(getApplicationContext(),bballb1.class);
                            startActivityForResult(intent_bballb1,0);
                            break;
                        case 1:
                            Intent intent_bballb2=new Intent(getApplicationContext(),bballb2.class);
                            startActivityForResult(intent_bballb2,0);
                            break;
                        case 2:
                            Intent intent_bballb3=new Intent(getApplicationContext(),bballb3.class);
                            startActivityForResult(intent_bballb3,0);
                            break;
                    }
                }
                if(groupPosition==8)
                {
                    switch (childPosition){
                        case 0:
                            Intent intent_bed0=new Intent(getApplicationContext(),bed1.class);
                            startActivityForResult(intent_bed0,0);
                            break;
                        case 1:
                            Intent intent_bed1=new Intent(getApplicationContext(),bed1.class);
                            startActivityForResult(intent_bed1,0);
                            break;
                        case 2:
                            Intent intent_bed2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/0BzaRGu22V1EkUFpXcGlweTBhbVU/view?usp=docslist_api"));
                            startActivityForResult(intent_bed2,0);
                            break;
                    }
                }
                if(groupPosition==9){
                    switch (childPosition){
                        case 0:
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://jemtec.freeforums.net"));
                            startActivity(intent);
                            break;

                    }
                }
                return false; }
        });
    }


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("B.Tech(cse)");
        listDataHeader.add("B.Tech(ece)");
        listDataHeader.add("B.Tech(civil)");
        listDataHeader.add("B.Tech(me)");
        listDataHeader.add("B.Tech(ee)");
        listDataHeader.add("BCA");
        listDataHeader.add("BA.LLB");
        listDataHeader.add("BBA.LLB");
        listDataHeader.add("B.Ed");
        listDataHeader.add("Common Discussion Forum");

        // Adding child data
        List<String> btechcse = new ArrayList<String>();
        btechcse.add("Syllabus");
        btechcse.add("Book Bank");
        btechcse.add("Recommended Books");
        btechcse.add("Previous Years Question Papers");


        List<String> btechece = new ArrayList<String>();
        btechece.add("Syllabus");
        btechece.add("Book Bank");
        btechece.add("Recommended Books");
        btechece.add("Previous Years Question Papers");


        List<String> btechcivil = new ArrayList<String>();
        btechcivil.add("Syllabus");
        btechcivil.add("Book Bank");
        btechcivil.add("Recommended Books");
        btechcivil.add("Previous Years Question Papers");

        List<String> btechme = new ArrayList<String>();
        btechme.add("Syllabus");
        btechme.add("Book Bank");
        btechme.add("Recommended Books");
        btechme.add("Previous Years Question Papers");

        List<String> btechee = new ArrayList<String>();
        btechee.add("Syllabus");
        btechee.add("Book Bank");
        btechee.add("Recommended Books");
        btechee.add("Previous Years Question Papers");

        List<String> bca = new ArrayList<String>();
        bca.add("Syllabus");
        bca.add("Recommended Books");
        bca.add("Previous Years Question Papers");

        List<String> ballb = new ArrayList<String>();
        ballb.add("Syllabus");
        ballb.add("Recommended Books");
        ballb.add("Previous Years Question Papers");

        List<String> bballb = new ArrayList<String>();
        bballb.add("Syllabus");
        bballb.add("Recommended Books");
        bballb.add("Previous Years Question Papers");

        List<String> bed = new ArrayList<String>();
        bed.add("Syllabus");
        bed.add("Recommended Books");
        bed.add("Previous Years Question Papers");

        List<String> cmndisc = new ArrayList<String>();
        cmndisc.add("Main Page");



        listDataChild.put(listDataHeader.get(0), btechcse); // Header, Child data
        listDataChild.put(listDataHeader.get(1), btechece);
        listDataChild.put(listDataHeader.get(2), btechcivil);
        listDataChild.put(listDataHeader.get(3), btechme);
        listDataChild.put(listDataHeader.get(4), btechee);
        listDataChild.put(listDataHeader.get(5), bca);
        listDataChild.put(listDataHeader.get(6), ballb);
        listDataChild.put(listDataHeader.get(7), bballb);
        listDataChild.put(listDataHeader.get(8), bed);
        listDataChild.put(listDataHeader.get(9), cmndisc);





    }




}

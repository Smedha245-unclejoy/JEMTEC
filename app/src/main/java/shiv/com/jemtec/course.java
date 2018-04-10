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
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class course extends AppCompatActivity {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_layout);
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
                        Intent i = new Intent(course.this, MapsActivity.class);
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
        ExpandList = (ExpandableListView) findViewById(R.id.exp_List);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(course.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


    }

    public ArrayList<Group> SetStandardGroups() {
        String group_names[] = {"B.Tech in Computer Science and Engineering",
                "B.Tech in Electronics and Communication Engineering", "B.Tech in Civil Engineering", "B.Tech in Electrical Engineering",
                "B.Tech in Mechanical Engineering","B.A./BBA LLB","Bachelor of Computer Applications","Bachelor of Education"};
        String country_names[] = {"Eligibility:\n•\t10+2 with a minimum aggregate of 55% marks in Physics, Chemistry and Mathematics provided the candidate has passed in each Subject separately.\n•\tCandidate must additionally have passed English As a subject of study (core/elective/functional) in the qualifying examination.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, Followed by IPU Counselling Session for Admission.\n•\tDuration: 4 years.\n•\tAnnual Intake: 60.\n•\tFees: INR 97000/- + 5000(book bank) for 1st year\n" +
                "INR 92000/- 2nd year onwards\nCOURSE HIGHLIGHTS:-\nComputer science and engineering students will learn about basic engineering techniques, as other engineering students, during first year course. These techniques include Engineering Mathematics, Physics and Chemistry, and Engineering drawing. From second year they are exposed to core computer science subjects like programming, data structures, Digital logic, Theoretical computer science, Algorithms, Computer networks, Operating systems, Web technologies, Databases and Computer Architecture are few to mention.Also there will be some elective subjects which can be chosen by the students based on their field of interest like Information Security,Machine learning.","Eligibility: \n" +
                "•\t10+2 with a minimum aggregate of 55% marks in Physics, Chemistry and Mathematics provided the candidate has passed in each Subject separately. \n" +
                "•\tCandidate must additionally have passed English As a subject of study (core/elective/functional) in the qualifying examination.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, Followed by IPU Counselling Session for Admission.\n" +
                "•\tDuration: 4 years.\n" +
                "•\tAnnual intake:60\n" +
                "•\tFees: INR 97000/- + 5000(book bank) for 1st year\n" +
                "INR 92000/- 2nd year onwards\nCOURSE HIGHLIGHTS:-\nThe discipline deals with electronic devices and software interfaces. The applications are far reaching, right from the indoors of the house to industries.  It integrates knowledge based on digital electronics and logic design, fundamentals of communication engineering, electronic circuits, signals and systems, power electronics, applied electromagnetic theory, integrated circuits, VLSI, control systems and computer architecture, Microprocessors and Embedded systems,Communication systems,Optical systems,VLSI and Digital Image processing.","Eligibility: \n•\t10+2 with a minimum aggregate of 55% marks in Physics, Chemistry and Mathematics provided the candidate has passed in each Subject separately. \n" +
                "•\tCandidate must additionally have passed English As a subject of study (core/elective/functional) in the qualifying examination.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, Followed by IPU Counselling Session for Admission.\n" +
                "•\tDuration: 4 years.\n" +
                "•\tAnnual intake:60\n" +
                "•\tFees: INR 97000/- + 5000(book bank) for 1st year\n" +
                "INR 92000/- 2nd year onwards\nCOURSE HIGHLIGHTS:-\nCivil engineering graduates are the brains behind all the largest and most essential structures that surround us – buildings, transport networks, energy and water supplies – and so their value within society is great. It includes planning, design, budgeting, surveying, construction management and analysis. At its core, civil engineering is a combination of many scientific specialisations, including mechanics, hydraulics, geotechnics (using knowledge of the earth’s crust to solve construction problems), materials science and statistical analysis.","Eligibility: \n•\t10+2 with a minimum aggregate of 55% marks in Physics, Chemistry and Mathematics provided the candidate has passed in each Subject separately. \n" +
                "•\tCandidate must additionally have passed English As a subject of study (core/elective/functional) in the qualifying examination.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, Followed by IPU Counselling Session for Admission.\n" +
                "•\tDuration: 4 years.\n" +
                "•\tAnnual intake:60\n" +
                "•\tFees: INR 97000/- + 5000(book bank) for 1st year\n" +
                "INR 92000/- 2nd year onwards\nCOURSE HIGHLIGHTS:-\nElectrical\n" +
                "Electrical engineers study and apply the physics and mathematics of electricity, electronics, and electromagnetism to both large and small scale systems to process information and transmit energy. To do this, electrical engineers design computers, electronic devices, communication systems, test equipment, and improve systems through problem solving techniques.they study Electrical machines, electrical and electronic measurements,electric circuits and fields,Power systems ,analog and digital electronics,Control systems ,signals and systems,Power electronics as some of their core subjects.\n","Eligibility: \n•\t10+2 with a minimum aggregate of 55% marks in Physics, Chemistry and Mathematics provided the candidate has passed in each Subject separately. \n" +
                "•\tCandidate must additionally have passed English As a subject of study (core/elective/functional) in the qualifying examination.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, Followed by IPU Counselling Session for Admission.\n" +
                "•\tDuration: 4 years.\n" +
                "•\tAnnual intake:60\n" +
                "•\tFees: INR 97000/- + 5000(book bank) for 1st year\n" +
                "INR 92000/- 2nd year onwards\nCOURSE HIGHLIGHTS:-\nHave you ever dreamed of building a robot or designing an aircraft? Have a passion for racing cars and want to be part of a Formula 1 development team? Maybe you’re fascinated by nanotechnology, developments in cleaner and more efficient energy use, or even the study of sound pollution and sound-proofing.  If any of the above grabs your attention, then maybe you should consider a mechanical engineering career. At undergraduate level, students will start with an introduction to key mechanical engineering topics, such as statics and dynamics, thermodynamics, fluid dynamics, stress analysis, mechanical design and technical drawing. As the course progresses, there should be more opportunities to specialize in a particular field within which mechanical engineering skills are applied, such as vehicle design, robotics, nanotechnology or energy.","Eligibility:\n" +
                "•\tPass in 12th Class of 10+2 of CBSE or equivalent with a minimum of 50% marks in aggregate.\n" +
                "•\tCandidate must additionally have passed in English (core or elective or functional) as a subject.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, followed by IPU Counseling Session for Admission.\n" +
                "\nDuration: 5 years.\n" +
                "Annual intake:108\n" +
                "Fees: INR 70000/- + 5000(book bank) \n" +"COURSE HIGHLIGHTS:\n" +
                "A lawyer is a professional who is qualified to offer advice about the law or represent his client before the tribunal or the court. A lot of preparation and planning goes into the presentation of a case. It is the duty of a lawyer to refer to the updated laws and previous cases and these have to be quoted while formulating a case and presenting it in the court. Thus, a lawyer Lawyers must be orally articulate, have good written communication skills and also be good listeners. In order to argue convincingly in the courtroom before juries and judges, good public speaking skills are essential.\n" +
                "Typically no lawyer works nine to five instead this is the time they are in court. All the spade work and preparation for the case has to be done after court and thus, lawyers work beyond regular working hours.\n" +
                "BA LLB is an integration of arts and law. It includes a thorough study of Law of Contracts, Legal Method, Indian History, Law of Torts, Family Laws, Sociology and some of the other subjects .\n" +
                "While, BBA LLB is an integration of management and business subjects and law. Some of the important subjects include: Law of Contract, Financial management, organizational behavior, Law of Torts, Crime laws, Corporate Law.\n","Eligibility: \n" +
                "•\tPass in 12th Class of 10+2 pattern of CBSE or equivalent with a minimum aggregate of 55% marks in Physics, Chemistry and Mathematics provided the candidate has passed in each Subject separately \n" +
                "OR\n" +
                "•\tThree year Diploma in a branch of Engineering from a polytechnic duly approved by All India Council for Technical Education and affiliated to a recognized examining body with a minimum of 50% marks in aggregate.\n" +
                "•\tCandidate must additionally have passed English as a subject of study (core/elective/functional) in the qualifying examination and Mathematics or Computer Science / Informatics Practice / Computer Applications.\n" +
                "•\tSelection of candidates are based on IPU-CET Entrance Exam, Followed by IPU Counseling Session for Admission.\n" +
                "Duration: 3 years. \n" +
                "Annual intake:60\n" +
                "Fees: INR 97000/- + 5000(book bank) for 1st year\n" +
                "INR 92000/- 2nd year onwards\n" +
                "COURSE HIGHLIGHTS:\n" +
                "Computer Applications is a branch which has been derived from computer science. It simply refers to the use of computers and other technologies for the management of vast information. This branch develops technologies for information management and also provides information management strategies by planning and studying the requirement scenario. It is the study of how computers process and manage all the information. With the advent of the computer technology era, software application and communication systems have become an integral component of every organization’s strategic plan. At JIMS Engineering Management Technical Campus(JEMTEC)‘IT’ is defined with a different fervor – “Innovating Tomorrow”. With India as an IT giant, our endeavors will be in making today’s youth, tomorrow’s Innovators. Keeping in view the Bachelor of Computer Applications programme,JEMTEC boasts of a sound academic base, well balanced course structures to emphasize on planning, designing and building of complex commercial application along with functional knowledge for a career in the field of computer application.\n","Eligibility: \n" +
                "Selection of candidates is based on IPU-CET Entrance Exam, followed by IPU Counselling Session for Admission.\n" +
                "Bachelor of Education:\n" +
                "•\tCandidates with at least 50% marks either in Bachelors degree and/or in the Masters degree in Sciences, Social Sciences, and Humanities or Bachelors in Engineering or Technology with specialization in Science and Mathematics with 55% marks or any other qualification equivalent thereto.\n" +
                "•\tThe candidates have to appear in the Common Entrance Test conducted by GGSIP University.\n" +
                "•\tThe selection and admission of the candidates is done through counseling by GGSIP University, Delhi.\n" +
                "Note:\n" +
                "•\tThe candidate must have passed at least two subjects out of the list of the teaching subjects.\n" +
                "•\tThese two subjects should be available as teaching subjects in the institute/college in which the candidates seeks to take admission.\n" +
                "•\tThe candidates are advised not to opt for two languages as teaching methodology subjects.\n" +
                "•\tUniversity shall abide by the NCTE norms for admissions.\n" +
                "•\t For B.A. (H)/B.Sc. (H) students, 50% marks in aggregate are required in their main exam (excluding the qualifying/subjects) and 45% in the subsidiary are mandatory.\n" +
                "Duration: 2 years. \n" +
                "Annual intake:60\n" +
                "Fees: INR 97000/- + 5000(book bank) \n" +
                "INR 92000/- 2nd year onwards\n" +
                "COURSE HIGHLIGHTS:\n" +
                "The Bachelor of Education (B.Ed.) programme aims at developing the understanding and competencies required by practicing teachers for effective teaching-learning process at the secondary level of school education. This programme prepares prospective teachers to understand the psychological and sociological aspects of the child’s development and also understand his/her behavior under different conditions. The B.Ed program provided by the Faculty of Education, in JIMS Engineering Management Technical Campus (JEMTEC) is rigorous and demands a high degree of commitment. To be successful, a student must display sensitivity and a sense of responsibility to the teaching profession, and a respect for knowledge. The course work combined with rigorous practice of teaching prepares teacher trainees to master the art of teaching and the ability to deal with students based on their individual differences in various classroom situations.\n"
        };
        int Images[] = {R.drawable.comp, R.drawable.ece, R.drawable.civil, R.drawable.elect, R.drawable.mech2,R.drawable.llb,R.drawable.bca,R.drawable.bed};
        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;
        int size = 1;
        int j = 0;
        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch.setImage(Images[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 1;
        }

        return list;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}



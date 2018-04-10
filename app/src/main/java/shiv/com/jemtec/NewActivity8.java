package shiv.com.jemtec;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewActivity8 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_8);
        WebView tv8=(WebView)findViewById(R.id.webview8);
        String text8="<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data8="Guru Gobind Singh Indraprastha University ( IP ), Delhi<br>" +
                "Eligibility Conditions:<br><br>" +
                "1. Bachelor of Education:<br><br>" +
                "Candidates with at least 50% marks either in Bachelors degree and/or in the Masters degree in Sciences, Social Sciences, and Humanities.<br>" +
                "OR<br>" +
                "Candidates with Bachelor degree in Engineering or Technology with specialization in Science and Mathematics with 55% marks, or any other qualification equivalent thereto.<br><br>" +
                "Note: (i) The candidate must have passed at least two subjects out of the list of the teaching subjects.<br>" +
                "(ii) These two subjects should be available as teaching subjects in the institute/college in which the candidates seeks to take admission. The next Table shows the list of subjects that were offered in the Academic Session 2014-15, the list of subjects for the Academic Session would be displayed together with the detailed counseling schedule.<br>" +
                "(iii) The candidates are advised not to opt for two languages as teaching methodology subjects.<br>" +
                "(iv) University shall abide by the NCTE norms for admissions and shall not be responsible for the further job prospects of the students.<br>" +
                "(v) For B.A.(H)/B.Sc.(H) students, 50% marks in aggregate are required in their main exam (excluding the qualifying/subjects) and 45% in the subsidiary are mandatory.<br><br>" +
                "2. Bachelor of Special Education:<br><br>" +
                "The minimum requirement for the candidates seeking admission to this B.Ed. Course is B.A/ B.Sc/ B.Com or an equivalent degree at graduate level. The eligibility for admission is 50% marks in aggregate in 10+2+3 pattern or any other qualification recognized as equivalent thereto.<br><br>" +
                "Details for Entrance Test:<br><br>" +
                "# General Awareness : 20%<br>" +
                "# Reasoning : 20%<br>" +
                "# Mental Ability : 20%<br>" +
                "# English Comprehension : 10%<br>" +
                "# Aptitude for Teaching : 30%<br>" +
                "B. Ed. Admission Schedule : 2016 ( IPU ) :<br>" +
                "# Online Availability of Forms : Available from January end .<br>" +
                "# Last Date for Online Submission : 29 March, 2016<br>" +
                "# CET Exam Date : 16 April,2016 at 10:30 AM to 01:00 PM<br>" +
                "# CET Exam Result Date : 03 May, 2016<br>";
        tv8.loadData(String.format(text8, data8), "text/html", "utf-8");
    }
}

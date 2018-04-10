package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class NewActivity7 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_7);
        WebView tv7=(WebView)findViewById(R.id.webview7);
        String text7 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data7="Exam Name: Guru Gobind Singh Inderprastha University Common Entrance Test Bachelor of Computer Applications<br>" +
                "Commonly Known As: IPU CET BCA<br>" +
                "Exam type: University Level<br>" +
                "Exam category: UG<br>" +
                "Conducting body: Guru Gobind Singh Inderprastha University<br><br>" +
                "IPU CET BCA 2014 Eligibility Criteria:-<br> Candidate must have passed the intermediate or equivalent examination. Candidate pursuing last year of intermediate is also eligible. Candidate must have scored a minimum of aggregate 50% marks in intermediate or equivalent examination.  Candidate must have passed English subject and in one one of the following subjects Mathematics/Computer Science/Informatics Practice /ComputerApplications.<br><br>" +
                "IPU CET BCA 2014 Application Form:-<br> Application form of IPU CET BCA can be availed through online mode only. Candidate is required to fill-in all the asked details and take the print out of completed IPU CET BCA 2014 Application Form. Then, the print out of the completed application form has to be send to the below mentioned address by April 10, 2014.<br><br>" +
                "IPU CET BCA 2014 Exam Pattern: The question paper shall be divided into four sections. Questions will asked from the following topics/subjects English Language & Comprehension, Mathematics, Computer Awareness, General Knowledge (IT and Science related). The question paper will be set in English only. Total time duration of the test is 2:30 hours.<br><br>" +
                "IPU CET BCA 2014 Important Dates<br><br>" +
                "Last date of submission of Online application form : April 10, 2014<br>" +
                "Date of entrance examination : May 10, 2014<br>" +
                "Entrance examination time : 10:30 am to 1:00 pm<br>" +
                "Date for result declaration : May 20, 2014<br>" +
                "Official website: ipu.ac.in<br>" +
                "Address:<br>" +
                "Controller of Examinations,<br>" +
                "Administrative Block,<br>" +
                "Guru Gobind Singh Indraprastha University, <br>" +
                "Sector-16 C, Dwarka,<br>" +
                "New Delhi-110078.";
        tv7.loadData(String.format(text7, data7), "text/html", "utf-8");
    }
}

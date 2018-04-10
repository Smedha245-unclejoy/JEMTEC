package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class NewActivity5 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_5);
        WebView tv5 = (WebView) findViewById(R.id.webview5);
        String text5 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data5="Name of the Exam: Indraprastha University Common Entrance Test.<br>" +
                "Type of Exam: University Level<br>" +
                "Category of Exam: Under Graduate.<br>" +
                " Organizing Authority: Guru Govind Singh Indraprastha University (GGSIPU).<br>" +
                "Organising Authority: Guru Govind Singh Indraprastha University (GGSIPU)<br><br>" +
                "IPU CET 2016 Application Form Procedure:<br>" +
                "Candidates can check below details of Application Form of IPU CET 2016 :-<br>" +
                "Application Fees: Rs.1000<br>" +
                "Payment modes: Debit Card/Credit Card/Net Banking<br><br>" +
                "1.Candidates applying for IPU CET 2016 need to apply online<br>" +
                "They need to submit the duly-filled in online application form before March 29, 2016<br>" +
                "2.Applicants need not to send any hard copy to the university.<br><br>" +
                "<u>IPU CET 2016 Eligibility Criteria:</u><br>" +
                "Eligibility Requirements to appear in IPU CET 2016 are as follows :-<br>" +
                "1.Each applicant must have passed class 12th from a recognized board.<br>" +
                "2.A minimum aggregate of 55% is a prerequisite, while the applicant is required to have passed all subjects (Physics, Chemistry & Mathematics) separately.<br>" +
                "3.Applicants must have passed English subject (core/elective or functional).<br><br>" +
                "IPU CET 2016 Admit Card:<br>" +
                "1.All candidates must possess their IPU CET 2016 Admit Card while appearing for the entrance test.<br>" +
                "2.Admit card can be downloaded from the university website just 7 days prior to the CET exam date.<br>" +
                "3.Applicants can download IPU CET 2016 Hall Ticket by using their login and password.<br>" +
                "4.The applicants must carry two hard copies of the admit card, with 2 passport photographs on it, on the day of the exam.<br>" +
                "5.Candidates must preserve the Admit Card of IPU CET 2016 till the time of counselling/admission<br>" +
                "6.For non-receipt of admit card, Office of Controller of Examinations (Operations) at GGSIP University, Sector 16 C, Dwarka, New Delhi 110078 can be contacted 5 days prior.<br><br>" +
                "IPU CET 2016 Exam Pattern:<br>" +
                "1.The exam will be conducted in English<br>" +
                "2.Exam duration will be 2:30 hours<br>" +
                "3.IPU CET 2016 will comprise a total of 150 questions<br>" +
                "4.The applicant secures 4 marks for every right answer while he/she will lose 1 mark for every wrong answer<br>" +
                "5.The exam will be conducted in offline mode (OMR).<br>" +
                "6.Only black ball pen can be used for marking and writing the exam.<br>" +
                "7.Sections Covered:<br>" +
                "                     Physics (33.33%)<br>" +
                "                     Chemistry (33.33%)<br>" +
                "                     Mathematics (33.33%)<br><br>" +
                "IPU CET 2016 Important dates:<br><br>" +
                "Online Applications: January 30,  2016<br>" +
                "Last Date of Online Applications: March 29, 2016<br>" +
                "Issue of Admit Card: Last week of April 2016<br>" +
                "Date for IPU CET 2016: May 8, 2016<br>" +
                "Result declaration: May 24, 2016<br>" +
                "Contact Info:<br>" +
                "Admission Branch, Guru Gobind Singh Indraprastha University," +
                "Dwarka, Sector 16C, Delhi 110078.<br>" +
                "Website: http://www.ipu.ac.in/<br>";
        tv5.loadData(String.format(text5, data5), "text/html", "utf-8");
    }
}


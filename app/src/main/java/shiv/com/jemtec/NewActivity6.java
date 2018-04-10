package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class NewActivity6 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_6);
        WebView tv6 = (WebView) findViewById(R.id.webview6);
        String text6 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data6="Exam Name:  Guru Gobind Singh Indraprastha University Common Entrance Test for BA LLB programme<br>" +
                "Commonly Known As: IPUCET Law<br>" +
                "Exam Type: University<br>" +
                "Exam Category: UG<br>" +
                "Conducting Authority: Guru Gobind Singh Indraprastha University (GGSIPU)<br>" +
                "Seats: 1395 distributed among 9 colleges<br><br>" +
                "IPUCET Law 2015 Eligibility Criteria:<br> Candidates who were applying for IPUCET Law 2015 may check below for the eligibility criteria :<br>" +
                "1.Candidate needed to have passed 10+2 examination from a recognized board<br>" +
                "2.They must have passed individually in each subject and obtained a minimum of 50% of the total marks in aggregate<br>" +
                "3.Candidates must have passed in English (Core or elective or functional) subject<br>" +
                "4.Candidates appearing in 10+2 examination are also eligible provided they meet the criteria when they attend counseling.<br><br>" +
                "IPUCET Law 2015 Application Procedure:<br> Candidates interested in admissions through IPUCET Law 2015 needed to apply online. They needed to apply and submit the duly-filled in online application form till April 15, 2015. Candidates applying for IPUCET law 2015 needed to remit an application fee of Rs. 750 only online via Debit Card/Credit Card/Net Banking.<br><br>" +
                "IPUCET Law 2015 Admit Card: Candidates will be able to download IPUCET Law 2015 Admit Card 7 days prior to the commencement of examination, i.e., from May 1, 2015. No candidate would be allowed to appear for IPUCET Law 2015 without a valid IPUCET Law 2015 Admit Card.<br><br>" +
                "IPUCET Law 2015 Exam Pattern:<br> IPUCET Law was conducted on May 9, 2015 in offline mode for two and a half hours duration. IPUCET law 2015 Paper comprised 150 objective-type questions (MCQs) from various sections, including English Language and Comprehension, General Knowledge, Legal Aptitude and Reasoning. Every correct answer would be awarded four marks. There was a system of negative marking for every wrong answer, under which one mark would be deducted for every wrong answer. The offline exam would be conducted in Delhi only.<br><br>" +
                "IPUCET Law selection process:<br> The admission would be made on the basis of marks obtained in IPUCET Law Score and Rank.<br>" +

                "IPUCET Law 2015 Important dates:<br><br>" +
                "Online Applications : February 9, 2015 - April 15, 2015<br>" +
                "Issue of Admit Card : May 1, 2015<br>" +
                "IPUCET Law 2015 : May 9, 2015 (2:00 pm – 4:30 pm)<br>" +
                "Result : May 16, 2015<br>";
        tv6.loadData(String.format(text6, data6), "text/html", "utf-8");
    }
}

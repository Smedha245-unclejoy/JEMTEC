package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class NewActivity1 extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_1);

        WebView tv1 = (WebView) findViewById(R.id.webView1);
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data1="<u>IPU CET 2015 Reservation Criteria: </u>IPU CET 2015 Reservation Criteria provide the details about the percentage of seats kept for different reserved categories. As of now, the university has not provided the reservation criteria that will be followed for the academic session starting from 2015. In the meantime, we bring you the details regarding IPU CET 2015 Reservation Criteria based on the year 2015.<br>   1. For University Schools, IGIT and Government Institutions of Delhi <br>A. For students of Delhi Region: 85% of sanctioned intake as below<br> a.SC -15% b.ST -7.5%<br> c.Def - 5% defence personnel <br>d.PH- 3%<br> e.OBC- 27 %<br> B. For students from Outside Delhi Regions:15% of sanctioned Intake as below <br>a.SC -15% <br>b.ST -7.5%<br> c.Def - 5% defence personnel<br> d.PH- 3%<br> 2. For Institutions outside Delhi in NCR<br> a.SC -15%<br> b.ST -7.5% <br>c.Def - 5% defence personnel <br>d.PH- 3% 3.<br> Self Financing Institutes Colleges in NCT of Delhi <br>a.SC -17%<br> b.ST -1% <br>c.Def - 5% ST -1% defence personnel<br> d.PH- 3% <br>IPU CET 2015 Guidelines for Reservations: <br>1.Candidates seeking admissions under reserved categories must furnish the caste/category certificate in their name at the time of counselling.<br> 2.The reservation certificate should be issued from the respective state/region in which the reservation is.<br> 3.Management Quota: 10% of the total seats as per policy of Govt. of NCT of Delhi.";
        tv1.loadData(String.format(text1, data1), "text/html", "utf-8");


    }
}

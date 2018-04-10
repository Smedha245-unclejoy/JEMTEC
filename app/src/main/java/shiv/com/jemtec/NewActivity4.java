package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class NewActivity4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_4);
        WebView tv4 = (WebView) findViewById(R.id.webview4);
        String text4 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data4="1. A candidate must satisfy eligibility criteria and obtain qualifying IPUCET Rank.<br><br>2. According to GGSIPU 2016 Admission Brochure: <br>85% of the sanctioned intake shall be allocated for Delhi Region and 15% of the sanctioned intake shall be allocated for the outside Delhi Region. However in case of Self financing Institutes sanctioned intake also includes 10% management quota seats (if offered).<br><br>2. Please note that through management quota, the admission fees, etc. will be higher than what other students have had to pay.<br>3. Admission Helpline Numbers: 0120 3819700 / 01 / 04 / 05, 0120 6587569";
        tv4.loadData(String.format(text4, data4), "text/html", "utf-8");

    }
}

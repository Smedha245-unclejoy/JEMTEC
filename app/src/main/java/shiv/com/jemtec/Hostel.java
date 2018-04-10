package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class Hostel extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostel);
        WebView wb_bs=(WebView)findViewById(R.id.wb_hs_bs);
        String data_bs="Boys Hostel is within the campus premises, having airy rooms with all basic amenities. Safe, Secure & Healthy environment.<br>" +
                "In addition to conducive academic environment, the institute also provides excellent facilities for sports, cultural activities, and good living conditions.";
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        wb_bs.loadData(String.format(text1, data_bs), "text/html", "utf-8");
    }
}

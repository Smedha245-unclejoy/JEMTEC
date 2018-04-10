package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class Hostel2 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostel_2);
        WebView wb_gs=(WebView)findViewById(R.id.wb_hs_gs);
        String data_gs="For Girls Hostel , College has tied up from Anandam Girls Hostel located nearby College Campus.Transport facility is provided from the hostel to the campus and back.<br>Address: Plot No. 35B,<br> Adjacent to Sharda University,<br> Knowledge Park-3, Greater Noida,<br> Uttar Pradesh 201308<br>" +
                "Phone:098107 00284";
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        wb_gs.loadData(String.format(text1, data_gs), "text/html", "utf-8");
    }
}

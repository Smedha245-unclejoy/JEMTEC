package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class Cafeteria extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafeteria);
        WebView tv1 = (WebView) findViewById(R.id.webview1);
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data1="<u><b>Cafeteria</b></u><br>Believing that the cafeteria is leverage to refresh the energies and health of students the JIMS cafeteria is a place which caters to hygienic and delicious refreshments and snacks. Sitting together, sharing thoughts and group discussions on various subjects & associated problems; gives the students a calm and natural environment for finding solutions to them.<br><br>Rate Chart:";
        tv1.loadData(String.format(text1, data1), "text/html", "utf-8");


    }
}

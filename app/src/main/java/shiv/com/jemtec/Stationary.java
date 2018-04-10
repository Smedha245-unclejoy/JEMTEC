package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class Stationary extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stationary_shop);
        WebView wb_stat=(WebView)findViewById(R.id.wb_stat);
        String data_stat="JIMS Campus has a small stationary shop for the convenience of students.You can get all kinds of daily use stationary tools here,can xerox your important documents,get colored printouts and color photographs.";
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        wb_stat.loadData(String.format(text1, data_stat), "text/html", "utf-8");
    }
}

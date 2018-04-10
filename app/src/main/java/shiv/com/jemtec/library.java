package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class library extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);
        WebView lb1=(WebView)findViewById(R.id.webview5);
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data_lib="A well-stocked library covering all Engineering subjects provides the right ambience for students to study and to improve their comprehensive power. The library provides the latest edition of books of different authors and journals/magazines for all Engineering subjects. It is having computerized issue and receipt facility and internet link to other prominent library systems.<br>In addition, reference books and newspapers are also available for students to scan the environment and to improve their general awareness.";
        lb1.loadData(String.format(text1,data_lib),"text/html","utf-8");
        WebView lb2=(WebView)findViewById(R.id.webview6);
        String data_lib2="All students and faculty members are entitled for membership of the Library.There are total 10,035 volume of books in Library,15 International Journals and 39 National Journals.<br><br><b>Internet Connectivity(10 MBPS)& Reprographics Facility Available.</b>";
        lb2.loadData(String.format(text1,data_lib2),"text/html","utf-8");
    }
}

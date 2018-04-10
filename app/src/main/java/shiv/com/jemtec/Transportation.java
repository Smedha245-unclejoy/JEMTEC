package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class Transportation extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transportation);
        WebView wb=(WebView)findViewById(R.id.webview_trans);
        String text1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data_web="For a smooth and safe journey of students from their respective locations to JIMS Campus,College Buses run from East Delhi to our Campus.";
        wb.loadData(String.format(text1, data_web), "text/html", "utf-8");
        WebView wb2=(WebView)findViewById(R.id.web_trans2);
        String data_web2="Route 1 Stoppages:<br>1.Loni Gol Chakkar 2.Dilshad Garden 3.Jhilmil 4.Shahdara 5.Shyam Lal College 6.Kanti Nagar 7.Azad Ngar 8.Krishna Nagar 9.Swarn Cinema 10.Jagatpuri 11.Preet Vihar Metro 12.Laxmi Nagar Metro 13.Mother Dairy 14.Manglam 15.Mayur Vihar-1 16.Mayur Vihar Extension<br>Route 2 Stoppages:<br><br>1.Durgapuri 2.BhajanPura 3.Maujpur 4.Welcome 5.Shastri park 6.Geeta Colony 7.Mayur Vihar 1 8.Mayur Vihar 3<br>Fees:Rs.11,000(per semester)<br>If any queries :<br>Contact:Mr.Ajay Kumar(9643638336)";
        wb2.loadData(String.format(text1, data_web2), "text/html", "utf-8");
    }
}

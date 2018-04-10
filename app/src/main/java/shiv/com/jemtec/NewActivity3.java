package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class NewActivity3 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_3);
        WebView tv3 = (WebView) findViewById(R.id.webview3);
        String text3 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data3="You Must Have These Documents with you if you are going to appear for Counselling: <br> 1) 10th class mark sheet (original + 2 photo copy) <br> 2) 10th class passing certificate (original + 2 photocopy) <br>3) 12th class Mark sheet (original + 2 photocopy) <br>4) 12th class passing certificate, if available (original + 2 photocopy)<br> 5) character certificate (original) 6) medical certificate  <br> 7) Your IPU CET Admit card (original)<br> 8) Your Drafts 9) Verification form  10) Preference Sheet  <br>11) Caste Certificate (if not general) (original + 2 photocopy) , In the case of Sikh minority, the format as prescribed by Delhi Sikh  Gurudwara Management Committee . <br>12) Affidavit on non-judicial stamp paper of Rs.10/ - for seeking provisional admission in case the result of qualifying examination is yet to be declared.  <br> NOTE :-The Original Certificates (except the admit card, medical certificate &amp; Character Certificate) will be returned to the candidates after verification. The photocopies of these certificates, Admit card (in original), Medical certificate (in original) & Character Certificate (in original) shall be retained.\n" +
                "\n ";
        tv3.loadData(String.format(text3, data3), "text/html", "utf-8");
        tv3.getSettings();
        tv3.setPadding(10,10,10,10);

    }
}

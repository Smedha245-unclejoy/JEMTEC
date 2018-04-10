package shiv.com.jemtec;

/**
 * Created by SHIVAM on 2/19/2016.
 */
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;


import java.util.HashMap;
import java.util.Locale;

public class Fragment5 extends Fragment implements TextToSpeech.OnInitListener{
    private static TextToSpeech tts5;
    WebView tv5;
    private ImageButton imbtn5;
    String text5;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view5= inflater.inflate(R.layout.fragment_5, container, false);
        tv5 = (WebView) view5.findViewById(R.id.webView5);
        String text5 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data5="Prof.(Dr)Rajan Anand Malik<br>B.E,M.Tech,MBA,PhD<br>Director<br>JIMS Engineering ManagementTechnical Campus (JEMTEC) is poised to achieve excellence in professional learning and to acquire a unique status in the National Region (NCR) by synergizing theoretical knowledge and practical skills to provide professional competence and produce professionals of national and international acclaim, who will be recognized as a product of a top ranking Institution imparting high quality education.<br> The underlying force in JEMTEC is the right blend of excellence of faculty, dedication of staff and the interest and the support of management of Jagannath Gupta Memorial Educational Society. I wish to express my sincere greetings to all the students who are aspiring to join JEMTEC and take this opportunity to assure them that the experience that they would gain while studying at JEMTEC would be lifelong for learning and development. I expect that the high quality of knowledge and skills imparted during their stay will help them to develop as valued assets for industry and diverse professional fields, thereby achieving the pinnacle of success.";
        tv5.loadData(String.format(text5, data5), "text/html", "utf-8");
        tts5 = new TextToSpeech(getActivity(), Fragment5.this);
        imbtn5= (ImageButton) view5.findViewById(R.id.imagebutton5);
        return view5;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts5.setLanguage(Locale.US);
            tts5.setSpeechRate(0);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {
                imbtn5.setEnabled(true);
                imbtn5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        speakOut();
                    }
                });

            }
        } else {
            Log.e("TTS", "Initilization Failed");
        }

    }

    @Override
    public void onDestroy() {
        if (tts5 != null) {
            tts5.stop();
            tts5.shutdown();
        }
        super.onDestroy();
    }
    private void speakOut() {
        String data9 = "Prof.(Dr)Rajan Anand Malik<br>B.E,M.Tech,MBA,PhD<br>Director<br>JIMS EngineeringManagementTechnical Campus (JEMTEC) is poised to achieve excellence in professional learning and to acquire a unique status in the National Region (NCR) by synergizing theoretical knowledge and practical skills to provide professional competence and produce professionals of national and international acclaim, who will be recognized as a product of a top ranking Institution imparting high quality education.<br> The underlying force in JEMTEC is the right blend of excellence of faculty, dedication of staff and the interest and the support of management of Jagannath Gupta Memorial Educational Society. I wish to express my sincere greetings to all the students who are aspiring to join JEMTEC and take this opportunity to assure them that the experience that they would gain while studying at JEMTEC would be lifelong for learning and development. I expect that the high quality of knowledge and skills imparted during their stay will help them to develop as valued assets for industry and diverse professional fields, thereby achieving the pinnacle of success.!!";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ttsGreater21(text5);
        } else {
            ttsUnder20(data9.toString());
        }
        Log.e("root", (data9.toString()));
    }
    private void ttsUnder20(String text5) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts5.speak(text5, TextToSpeech.QUEUE_FLUSH,map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text5) {
        String utteranceId=this.hashCode() + "";
        tts5.speak(text5, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}

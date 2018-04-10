package shiv.com.jemtec;

/**
 * Created by SHIVAM on 2/19/2016.
 */
import android.webkit.WebView;
import android.widget.ImageButton;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Locale;




public class Fragment1 extends Fragment implements TextToSpeech.OnInitListener {
    private static TextToSpeech tts;
    WebView tv;
    private ImageButton imbtn;
    String text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        tv = (WebView) view.findViewById(R.id.webView1);
        String text = "<html><body style=\"text-align:justify\"> %s </body></Html>";

        String data = "JIMS Engineering Management Technical Campus at Greater Noida is one of the Best Engineering Colleges in entire Delhi & NCR.It is approved by AICTE and Affiliated to GGSIPU,Delhi(an A Grade Uninversity accredited by NAAC ).<br>The Institute was established in the year 2008 with a mission to provide high quality education in the field of Engineering & Management and to develop and train the next generation technocrats & business leaders.It offers a holistic and harmonized training programme with strong academics, personality development, cultural and sports activities and provides an inspiring learning environnment which transnforms the young students into talented" +
                "professionals.<br>The Institute has qualified and experienced faculty.It also has strong interface with industry which enables it to expose students to guest speakers from Corporate World, Industry visits and seek opportunities, to execute live projects in top industrial organisations.";

        tv.loadData(String.format(text, data), "text/html", "utf-8");



        tts = new TextToSpeech(getActivity(), Fragment1.this);
        imbtn = (ImageButton) view.findViewById(R.id.imagebutton1);


        return view;}


    @Override
    public void onInit ( int status){
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            tts.setSpeechRate(0);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {
                imbtn.setEnabled(true);
                imbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        speakOut();
                    }
                });

            }
        } else {
            Log.e("TTS", "Initialization Failed");
        }
    }
    @Override
    public void onDestroy ()
    {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    private void speakOut() {
        String data1 = "JIMS Engineering Management Technical Campus at Greater Noida is one of the Best Engineering Colleges in entire Delhi & NCR.It is approved by AICTE and Affiliated to GGSIPU,Delhi(an A Grade Uninversity accredited by NAAC ).The Institute was established in the year 2008 with a mission to provide high quality education in the field of Engineering & Management and to develop and train the next generation technocrats & business leaders.It offers a holistic and harmonized training programme with strong academics, personality development, cultural and sports activities and provides an inspiring learning environnment which transnforms the young students into talented"  +
                " professionals.The Institute has qualified and experienced faculty.It also has strong interface with industry which enables it to expose students to guest speakers from Corporate World, Industry visits and seek opportunities, to execute live projects in top industrial organisations.";


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ttsGreater21(text);
        } else {
            ttsUnder20(data1.toString());
        }
        Log.e("root", (data1.toString()));
    }

    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId = this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}


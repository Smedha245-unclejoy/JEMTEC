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

public class Fragment4 extends Fragment implements TextToSpeech.OnInitListener{
    private static TextToSpeech tts4;
    WebView tv4;
    private ImageButton imbtn4;
    String text4;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view4= inflater.inflate(R.layout.fragment_4, container, false);
        tv4 = (WebView) view4.findViewById(R.id.webView4);
        String text4 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data4="Dr.Amit Gupta<br>Masters in International Business<br>B.Com(SRCC)<br>The institute was founded in 2008 with a clear vision and purpose. It was envisioned that in a foreseeable future it would evolve into a world class institution recognized for its commitment to high powered quality education and research.We have also committed ourselves to developing outstanding professionals and entrepreneurs who exemplify humanistic value, are socially responsible stewards and create and disseminate practitioner oriented knowledge that will uplift society. In order to keep pace with the velocity of change and thrive in an uncertain environment our institute has already shifted gears to a mode of mastering change. It has launched several strategic initiatives both at the macro and micro levels to ensure that students overall development is in tune with the present demands and expectation of industry.<br> Our strategic focus in future will address areas of curriculum design,mentoring and live projects,advanced statistical software training, international summer internships, soft skills, stress coping and E learning.These initiatives will focus on developing student competencies in dealing with global complexity, emerging technologies and change,and social and cultural diversity. I am confident that our“high value adding”initiatives will help to create skilled leaders of tomorrow as value is all about up skilling individuals and contributing to business results. Wishing you all the best for a bright future.";
        tv4.loadData(String.format(text4, data4), "text/html", "utf-8");
        tts4 = new TextToSpeech(getActivity(), Fragment4.this);
        imbtn4= (ImageButton) view4.findViewById(R.id.imagebutton4);


        return view4;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts4.setLanguage(Locale.US);
            tts4.setSpeechRate(0);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {
                imbtn4.setEnabled(true);
                imbtn4.setOnClickListener(new View.OnClickListener() {
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
    public void onDestroy()
    {
        if (tts4 != null) {
            tts4.stop();
            tts4.shutdown();
        }
        super.onDestroy();
    }
    private void speakOut() {
        String data8 = "Dr.Amit Gupta<br>Masters in International Business<br>B.Com(SRCC)<br>The institute was founded in 2008 with a clear vision and purpose. It was envisioned that in a foreseeable future it would evolve into a world class institution recognized for its commitment to high powered quality education and research.We have also committed ourselves to developing outstanding professionals and entrepreneurs who exemplify humanistic value, are socially responsible stewards and create and disseminate practitioner oriented knowledge that will uplift society. In order to keep pace with the velocity of change and thrive in an uncertain environment our institute has already shifted gears to a mode of mastering change. It has launched several strategic initiatives both at the macro and micro levels to ensure that students overall development is in tune with the present demands and expectation of industry.<br> Our strategic focus in future will address areas of curriculum design,mentoring and live projects,advanced statistical software training, international summer internships, soft skills, stress coping and E learning.These initiatives will focus on developing student competencies in dealing with global complexity, emerging technologies and change,and social and cultural diversity. I am confident that our“high value adding”initiatives will help to create skilled leaders of tomorrow as value is all about up skilling individuals and contributing to business results. Wishing you all the best for a bright future!!\";\n" +
                "       ";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ttsGreater21(text4);
        } else {
            ttsUnder20(data8.toString());
        }
        Log.e("root", (data8.toString()));
    }
    private void ttsUnder20(String text4) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts4.speak(text4, TextToSpeech.QUEUE_FLUSH,map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text4) {
        String utteranceId=this.hashCode() + "";
        tts4.speak(text4, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}

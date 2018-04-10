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

public class Fragment2 extends Fragment implements TextToSpeech.OnInitListener {
    private static TextToSpeech tts2;
    WebView tv2;
    private ImageButton imbtn2;
    String text2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 =inflater.inflate(R.layout.fragment_2, container, false);
        tv2 = (WebView) view2.findViewById(R.id.webView2);
        String text2 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data2="<u>Vision</u> <br>We visualize that JIMS will evolve in the future as an Institute of high academic learning, known for its total commitment to excellence in management and technical education and research with a holistic concern for quality of life ,environment ,society and ethics.";

        tv2.loadData(String.format(text2, data2), "text/html", "utf-8");
        tts2 = new TextToSpeech(getActivity(), Fragment2.this);
        imbtn2= (ImageButton) view2.findViewById(R.id.imagebutton2);
        return view2;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts2.setLanguage(Locale.US);
            tts2.setSpeechRate(0);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {
                imbtn2.setEnabled(true);
                imbtn2.setOnClickListener(new View.OnClickListener() {
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
    public void onDestroy() {
        if (tts2 != null) {
            tts2.stop();
            tts2.shutdown();
        }
        super.onDestroy();
    }
    private void speakOut() {
        String data6 = "Vision We visualize that JIMS will evolve in the future as an Institute of high academic learning, known for its total commitment to excellence in management and technical education and research with a holistic concern for quality of life ,environment ,society and ethics.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ttsGreater21(text2);
        } else {
            ttsUnder20(data6.toString());
        }
        Log.e("root", (data6.toString()));
    }
    private void ttsUnder20(String text2) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts2.speak(text2, TextToSpeech.QUEUE_FLUSH,map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text2) {
        String utteranceId=this.hashCode() + "";
        tts2.speak(text2, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}
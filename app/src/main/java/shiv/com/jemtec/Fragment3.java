package shiv.com.jemtec;

/**
 * Created by SHIVAM on 2/19/2016.
 */
import android.annotation.TargetApi;
import android.graphics.Color;
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

public class Fragment3 extends Fragment implements TextToSpeech.OnInitListener {
    private static TextToSpeech tts3;
    WebView tv3;
    private ImageButton imbtn3;
    String text3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view3 = inflater.inflate(R.layout.fragment_3, container, false);
        tv3 = (WebView) view3.findViewById(R.id.webView3);
        String text3 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data3 = "<u>Mission</u><br>To serve society and improve the quality of life by imparting high quality education in Management and Engineering, providing training and development services, fostering research, giving consultancy services to industry and disseminating information through publication of books, journals and magazines.";
        tv3.loadData(String.format(text3, data3), "text/html", "utf-8");
        tv3.getSettings();
        tv3.setBackgroundColor(Color.parseColor("#c273b76b"));


        tts3 = new TextToSpeech(getActivity(), Fragment3.this);
        imbtn3 = (ImageButton) view3.findViewById(R.id.imagebutton3);

        return view3;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts3.setLanguage(Locale.US);
            tts3.setSpeechRate(0);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {
                imbtn3.setEnabled(true);
                imbtn3.setOnClickListener(new View.OnClickListener() {
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
        if (tts3 != null) {
            tts3.stop();
            tts3.shutdown();
        }
        super.onDestroy();
    }

    private void speakOut() {
        String data7 = "Mission<br>To serve society and improve the quality of life by imparting high quality education in Management and Engineering, providing training and development services, fostering research, giving consultancy services to industry and disseminating information through publication of books, journals and magazines.\";\n" +
                "       ";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ttsGreater21(text3);
        } else {
            ttsUnder20(data7.toString());
        }
        Log.e("root", (data7.toString()));
    }

    private void ttsUnder20(String text3) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts3.speak(text3, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text3) {
        String utteranceId = this.hashCode() + "";
        tts3.speak(text3, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}
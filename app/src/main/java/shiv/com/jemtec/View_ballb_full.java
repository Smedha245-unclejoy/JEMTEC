package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

public class View_ballb_full extends Activity {
    public static final String[] IMAGES=new String[]{"http://jemtec.16mb.com/welcome/welcometo/0.png","http://jemtec.16mb.com/welcome/welcometo/1.png","http://jemtec.16mb.com/welcome/welcometo/2.png","http://jemtec.16mb.com/welcome/welcometo/3.png","http://jemtec.16mb.com/welcome/welcometo/4.png","http://jemtec.16mb.com/welcome/welcometo/5.png","http://jemtec.16mb.com/welcome/welcometo/6.png","http://jemtec.16mb.com/welcome/welcometo/7.png","http://jemtec.16mb.com/welcome/welcometo/8.png","http://jemtec.16mb.com/welcome/welcometo/9.png","http://jemtec.16mb.com/welcome/welcometo/10.png","http://jemtec.16mb.com/welcome/welcometo/11.png","http://jemtec.16mb.com/welcome/welcometo/12.png","http://jemtec.16mb.com/welcome/welcometo/13.png","http://jemtec.16mb.com/welcome/welcometo/14.png","http://jemtec.16mb.com/welcome/welcometo/15.png"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int imageIndex=getIntent().getIntExtra("position",-1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_full);
        ImageView image=(ImageView)findViewById(R.id.viewfullimage);
        ImageLoader mimageLoader=AppController.getInstance().getImageLoader();
        mimageLoader.get(IMAGES[imageIndex],ImageLoader.getImageListener(image,R.drawable.download,R.drawable.error));
    }
}


package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

public class ViewFullImage extends Activity {
    public static final String[] IMAGES=new String[]{"http://jemtec.16mb.com/ballb/uploads/0.png","http://jemtec.16mb.com/ballb/uploads/2.png","http://jemtec.16mb.com/ballb/uploads/3.png","http://jemtec.16mb.com/ballb/uploads/4.png","http://jemtec.16mb.com/ballb/uploads/5.png","http://jemtec.16mb.com/ballb/uploads/6.png","http://jemtec.16mb.com/ballb/uploads/7.png","http://jemtec.16mb.com/ballb/uploads/8.png","http://jemtec.16mb.com/ballb/uploads/9.png","http://jemtec.16mb.com/ballb/uploads/10.png","http://jemtec.16mb.com/ballb/uploads/11.png","http://jemtec.16mb.com/ballb/uploads/13.png","http://jemtec.16mb.com/ballb/uploads/14.png","http://jemtec.16mb.com/ballb/uploads/15.png"};

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

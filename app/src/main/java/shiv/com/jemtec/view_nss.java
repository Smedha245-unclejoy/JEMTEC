package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;


public class view_nss extends Activity {
        public static final String[] IMAGES=new String[]{"http://jemtec.16mb.com/nss/nss_uploads/0.png","http://jemtec.16mb.com/nss/nss_uploads/1.png","http://jemtec.16mb.com/nss/nss_uploads/2.png","http://jemtec.16mb.com/nss/nss_uploads/3.png","http://jemtec.16mb.com/nss/nss_uploads/4.png","http://jemtec.16mb.com/nss/nss_uploads/5.png","http://jemtec.16mb.com/nss/nss_uploads/6.png","http://jemtec.16mb.com/nss/nss_uploads/7.png","http://jemtec.16mb.com/nss/nss_uploads/8.png","http://jemtec.16mb.com/nss/nss_uploads/9.png","http://jemtec.16mb.com/nss/nss_uploads/10.png","http://jemtec.16mb.com/nss/nss_uploads/11.png","http://jemtec.16mb.com/nss/nss_uploads/12.png","http://jemtec.16mb.com/nss/nss_uploads/13.png"};
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


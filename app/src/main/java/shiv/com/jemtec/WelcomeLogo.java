package shiv.com.jemtec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeLogo extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_logo);
        imageView=(ImageView)findViewById(R.id.logo);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);
        imageView.setAnimation(animation);
 animation.setAnimationListener(new Animation.AnimationListener()
 {
     @Override
     public void onAnimationStart(Animation animation) {

     }

     @Override
     public void onAnimationEnd(Animation animation) {
         finish();
         startActivity(new Intent(getApplicationContext(),frontpage.class));
     }

     @Override
     public void onAnimationRepeat(Animation animation) {

     }

 });
    }
}

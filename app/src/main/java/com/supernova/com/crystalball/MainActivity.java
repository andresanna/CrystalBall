package com.supernova.com.crystalball;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private CrystalBall mCrystalBall = new CrystalBall();
    private TextView manswerLabel;
    private Button mgetAnswerButton;
    private ImageView mcrystalBallImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Declare our View variables
         manswerLabel = (TextView) findViewById(R.id.textView);
  mgetAnswerButton = (Button) findViewById(R.id.majorButton);
        mgetAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = mCrystalBall.getAnswer();


                manswerLabel.setText(answer);
                animateCrystalBall();
                animateAnswer();
                playSound();
            }
        });
        String toastMessage1 = "Welcome to Crystal Ball";
        String toastMessage2 = "I can see the future in your eyes";
        Toast welcomeToast = Toast.makeText(this, toastMessage1, Toast.LENGTH_LONG);
        welcomeToast.setGravity(Gravity.TOP,0,400);
        welcomeToast.show();
        Toast welcomeToast2 = Toast.makeText(this, toastMessage2,Toast.LENGTH_LONG);
        welcomeToast2.setGravity(Gravity.BOTTOM,0,500);
        welcomeToast2.show();



    }
    private void animateAnswer(){
        AlphaAnimation fadein = new AlphaAnimation(0, 1);
        fadein.setDuration(1500);
        fadein.setFillAfter(true);
        manswerLabel.setAnimation(fadein);
                   fadein.getRepeatMode();

    }
    private void playSound(){
        MediaPlayer player = MediaPlayer.create(this,R.raw.crystal_ball);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
     }

    private void animateCrystalBall(){
      mcrystalBallImage = (ImageView) findViewById(R.id.imageView2);
        mcrystalBallImage.setImageResource(R.drawable.ball_animation);
        AnimationDrawable ballAnimation = (AnimationDrawable) mcrystalBallImage.getDrawable();
        if(ballAnimation.isRunning()){
            ballAnimation.stop();

        }
        ballAnimation.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpashActivity extends AppCompatActivity {

    private ImageView ivimage;
    private TextView tvtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        ivimage = findViewById(R.id.ivimage);
        tvtitle = findViewById(R.id.tvtitle);

        //using a thread and halt screen for 2 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SpashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.splashanimation);
        ivimage.startAnimation(myanim);
        tvtitle.startAnimation(myanim);

    }
}

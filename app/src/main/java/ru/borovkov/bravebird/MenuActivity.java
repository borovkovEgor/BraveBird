package ru.borovkov.bravebird;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MenuActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mediaPlayer = MediaPlayer.create(this, R.raw.button_click);

    }

    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();

        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    public void onClickStartButton(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                view.setScaleX(1.0f);
                view.setScaleY(1.0f);

                playSound();

                Intent intent = new Intent(MenuActivity.this, GameCore.class);
                setTheme(R.style.DimBackgroundTheme);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animation);
    }

    public void onClickLocateButton(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);

                playSound();

                Intent intent = new Intent(MenuActivity.this, LocationActivity.class);
                setTheme(R.style.DimBackgroundTheme);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animation);
    }

    public void onClickExitButton(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);

                playSound();

                setTheme(R.style.DimBackgroundTheme);
                onBackPressed();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animation);
    }
}
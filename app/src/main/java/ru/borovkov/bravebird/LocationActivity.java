package ru.borovkov.bravebird;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    private RadioGroup radioGroupLocation;
    private RadioButton radioButtonFirstLocation;
    private RadioButton radioButtonSecondLocation;
    private RadioButton radioButtonThirdLocation;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        initViews();

        mediaPlayer = MediaPlayer.create(this, R.raw.button_click);

        if (DataHolder.getInstance().getData() == 1) {
            radioGroupLocation.check(R.id.radioButtonFirstLocation);
        } else if (DataHolder.getInstance().getData() == 2) {
            radioGroupLocation.check(R.id.radioButtonSecondLocation);
        } else if (DataHolder.getInstance().getData() == 3) {
            radioGroupLocation.check(R.id.radioButtonThirdLocation);
        }
    }

    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
    public void getLocation() {
        int selectedId = radioGroupLocation.getCheckedRadioButtonId();

        if (selectedId == radioButtonFirstLocation.getId()) {
            DataHolder.getInstance().setData(1);
        } else if (selectedId == radioButtonSecondLocation.getId()) {
            DataHolder.getInstance().setData(2);
        } else if (selectedId == radioButtonThirdLocation.getId()) {
            DataHolder.getInstance().setData(3);
        }
    }

    private void initViews() {
        radioGroupLocation = findViewById(R.id.radioGroupLocation);
        radioButtonFirstLocation = findViewById(R.id.radioButtonFirstLocation);
        radioButtonSecondLocation = findViewById(R.id.radioButtonSecondLocation);
        radioButtonThirdLocation = findViewById(R.id.radioButtonThirdLocation);
    }

    public void onClickExitButton(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_scale);
        getLocation();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);

                playSound();

                Intent intent = new Intent(LocationActivity.this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animation);
    }
}

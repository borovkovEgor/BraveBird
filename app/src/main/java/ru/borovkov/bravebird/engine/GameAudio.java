package ru.borovkov.bravebird.engine;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

public class GameAudio {
    public AssetManager assetManager;
    public SoundPool soundPool;

    public GameAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        assetManager = activity.getAssets();
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).build();
    }

    public GameMusic newMusic(String fileName) {
        AssetFileDescriptor assetFileDescriptor;
        try {
            assetFileDescriptor = assetManager.openFd(fileName);
            return new GameMusic(assetFileDescriptor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

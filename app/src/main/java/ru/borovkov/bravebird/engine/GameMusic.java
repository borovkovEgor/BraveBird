package ru.borovkov.bravebird.engine;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.IOException;

public class GameMusic implements MediaPlayer.OnCompletionListener {

    public MediaPlayer mediaPlayer;
    public boolean isPrepared;

    public GameMusic(AssetFileDescriptor assetFileDescriptor) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        isPrepared = true;

        mediaPlayer.setOnCompletionListener(this);

    }

    public void play(boolean looping, float volume) {
        if (mediaPlayer.isPlaying()) {
            return;
        }
        synchronized (this) {
            if (!isPrepared) {
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            mediaPlayer.setLooping(looping);
            mediaPlayer.setVolume(volume, volume);
            mediaPlayer.start();
        }
    }

    public void stop() {
        mediaPlayer.stop();
        synchronized (this) {
            isPrepared = false;
        }
    }

    public void dispose() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        synchronized (this) {
            isPrepared = false;
        }
    }
}

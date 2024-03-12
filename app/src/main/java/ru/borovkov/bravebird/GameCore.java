package ru.borovkov.bravebird;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.borovkov.bravebird.management.LoaderAssets;
import ru.borovkov.bravebird.engine.GameAudio;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.engine.GameScene;
import ru.borovkov.bravebird.engine.GameTouchListener;
import ru.borovkov.bravebird.engine.GameUpdater;
import ru.borovkov.bravebird.scenes.PlayScene;

public class GameCore extends AppCompatActivity {

    private final int FRAME_BUFFER_WIDTH = 1920;
    private final int FRAME_BUFFER_HEIGHT = 1080;

    private GameUpdater gameUpdater;
    private GameGraphics gameGraphics;
    private GameTouchListener gameTouchListener;
    private GameAudio gameAudio;
    private GameScene gameScene;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Point sizeDisplay = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);
        Bitmap frameBuffer = Bitmap.createBitmap(FRAME_BUFFER_WIDTH, FRAME_BUFFER_HEIGHT, Bitmap.Config.ARGB_8888);
        double sceneWidth = (double) FRAME_BUFFER_WIDTH / sizeDisplay.x;
        double sceneHeight = (double) FRAME_BUFFER_HEIGHT / sizeDisplay.y;

        gameAudio = new GameAudio(this);
        gameUpdater = new GameUpdater(this, frameBuffer);
        gameGraphics = new GameGraphics(getAssets(), frameBuffer);
        gameTouchListener = new GameTouchListener(gameUpdater, sceneWidth, sceneHeight);

        gameScene = getStartGameScene();

        setContentView(gameUpdater);

    }

    public void onResume() {
        super.onResume();
        gameScene.resume();
        gameUpdater.startGame();
    }

    public void onPause() {
        super.onPause();
        gameScene.pause();
        gameUpdater.stopGame();
        if (isFinishing()) {
            gameScene.dispose();
        }
    }

    public GameGraphics getGameGraphics() {
        return gameGraphics;
    }

    public GameTouchListener getGameTouchListener() {
        return gameTouchListener;
    }

    public GameScene getCurrentGameScene() {
        return gameScene;
    }

    public GameScene getStartGameScene() {
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGameGraphics());
        return new PlayScene(this);
    }

    public GameAudio getGameAudio() {
        return gameAudio;
    }

    public void goToGameOverActivity() {
        Intent intent = new Intent(this, GameOverActivity.class);
        setTheme(R.style.DimBackgroundTheme);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

}

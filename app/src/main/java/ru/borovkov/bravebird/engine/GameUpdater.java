package ru.borovkov.bravebird.engine;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import ru.borovkov.bravebird.GameCore;

@SuppressLint("ViewConstructor")
public class GameUpdater extends SurfaceView implements Runnable {

    private final float FPS = 60;
    private final float SECOND = 1_000_000_000;
    private final float UPDATE_TIME = SECOND/FPS;

    private final GameCore gameCore;
    private final Bitmap frameBuffer;
    private final SurfaceHolder surfaceHolder;
    private final Rect rect;

    private Canvas canvas;
    private Thread gameThread;

    private boolean running = false;

    public GameUpdater(GameCore gameCore, Bitmap frameBuffer) {
        super(gameCore);
        this.gameCore = gameCore;
        this.frameBuffer = frameBuffer;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    @Override
    public void run() {
        while (running) {
            updater();
        }
    }

    private void updateGame() {
        gameCore.getCurrentGameScene().update();
    }

    private void drawingGame() {

        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            gameCore.getCurrentGameScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void updater() {
        float lastTime = System.nanoTime();
        float delta = 0;

        while (running) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            delta += elapsedTime;
            if (delta > UPDATE_TIME) {
                updateGame();
                drawingGame();
                delta = 0;
            }
        }
    }

    public void startGame(){
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


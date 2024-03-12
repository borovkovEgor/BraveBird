package ru.borovkov.bravebird.engine;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

public class GameTouchListener implements View.OnTouchListener {

    private double touchX;
    private double touchY;
    private final double sceneWidth;
    private final double sceneHeight;

    private boolean isTouchDown;
    private boolean isTouchUp;

    public GameTouchListener(View view, double sceneWidth, double sceneHeight) {
        view.setOnTouchListener(this);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this) {
            isTouchDown = false;
            isTouchUp = false;
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchX = motionEvent.getX() * sceneWidth;
                    touchY = motionEvent.getY() * sceneHeight;
                    isTouchDown = true;
                    isTouchUp = false;
                    break;
                case MotionEvent.ACTION_UP:
                    touchX = motionEvent.getX() * sceneWidth;
                    touchY = motionEvent.getY() * sceneHeight;
                    isTouchDown = false;
                    isTouchUp = true;
                    break;
            }
        }
        return true;
    }

    public boolean getTouchUp(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchUp) {
            if (touchX >= x && touchX <= x + touchWidth - 1 && touchY >= y && touchY <= y + touchHeight - 1) {
                isTouchUp = false;
                return true;
            }
        }
        return false;
    }

    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchDown) {
            if (touchX >= x && touchX <= x + touchWidth - 1 && touchY >= y && touchY <= y + touchHeight - 1) {
                isTouchDown = false;
                return true;
            }
        }
        return false;
    }
}


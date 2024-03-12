package ru.borovkov.bravebird.engine;

import android.graphics.Bitmap;

public class AnimationGame {

    private final double speedAnimation;
    private final int frames;
    private int delayIndex;
    private int countFrames;

    private final Bitmap sprite1;
    private final Bitmap sprite2;
    private final Bitmap sprite3;
    private final Bitmap sprite4;
    private final Bitmap sprite5;
    private final Bitmap sprite6;
    private final Bitmap sprite7;
    private final Bitmap sprite8;
    private Bitmap sprite;

    private boolean animationIsFinished;

    public AnimationGame(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4,
                         Bitmap sprite5, Bitmap sprite6, Bitmap sprite7, Bitmap sprite8)
    {
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        this.sprite4 = sprite4;
        this.sprite5 = sprite5;
        this.sprite6 = sprite6;
        this.sprite7 = sprite7;
        this.sprite8 = sprite8;
        this.speedAnimation = speedAnimation;
        sprite = sprite1;
        frames = 7;
    }

    public void runAnimation() {
        delayIndex++;
        if (delayIndex > speedAnimation) {
            nextFrame();
            delayIndex = 0;
        }
    }

    public void nextFrame() {

        animationIsFinished = false;

        if (countFrames == 0) {
            sprite = sprite1;
        }
        if (countFrames == 1) {
            sprite = sprite2;
        }
        if (countFrames == 2) {
            sprite = sprite3;
        }
        if (countFrames == 3) {
            sprite = sprite4;
        }
        if (countFrames == 4) {
            sprite = sprite5;
        }
        if (countFrames == 5) {
            sprite = sprite6;
        }
        if (countFrames == 6) {
            sprite = sprite7;
        }
        if (countFrames == 7) {
            sprite = sprite8;
        }
        countFrames++;
        if (countFrames > frames) {
            animationIsFinished = true;
            countFrames = 0;
        }
    }

    public void drawingAnimation(GameGraphics gameGraphics, int x, int y) {
        gameGraphics.drawTexture(sprite, x, y);
    }

    public boolean isAnimationIsFinished() {
        return animationIsFinished;
    }
}

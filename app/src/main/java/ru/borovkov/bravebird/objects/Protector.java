package ru.borovkov.bravebird.objects;

import android.graphics.Rect;

import ru.borovkov.bravebird.utilits.UtilResource;
import ru.borovkov.bravebird.engine.AnimationGame;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.engine.GameObjects;

public class Protector extends GameObjects {
    private final int SPEED = 7;

    public AnimationGame animationProtector;

    public Protector(int maxX, int maxY) {
        x = maxX;
        y = (int) (Math.random() * (maxY - UtilResource.spriteEagle.get(0).getHeight()));
        radius = UtilResource.spriteProtector.get(0).getWidth() / 2d;
        this.maxX = maxX;
        this.maxY = maxY - UtilResource.spriteProtector.get(0).getHeight();
        hitBox = new Rect(x, y,
                UtilResource.spriteProtector.get(0).getWidth(),
                UtilResource.spriteProtector.get(0).getHeight());
        animationProtector = new AnimationGame(1, UtilResource.spriteProtector.get(0),
                UtilResource.spriteProtector.get(1),
                UtilResource.spriteProtector.get(2),
                UtilResource.spriteProtector.get(3),
                UtilResource.spriteProtector.get(4),
                UtilResource.spriteProtector.get(5),
                UtilResource.spriteProtector.get(6),
                UtilResource.spriteProtector.get(7));
    }

    public void update() {
        x -= SPEED;
        if (x + UtilResource.spriteProtector.get(0).getWidth() < 0) {
            x = 0;
            y = (int) (Math.random() * (maxY + 1));
        }
        animationProtector.runAnimation();
        hitBox = new Rect(x, y,
                UtilResource.spriteProtector.get(0).getWidth(),
                UtilResource.spriteProtector.get(0).getHeight());
    }

    public void drawing(GameGraphics gameGraphics){
        animationProtector.drawingAnimation(gameGraphics, x, y);
    }
}

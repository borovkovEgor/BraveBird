package ru.borovkov.bravebird.objects;

import android.graphics.Rect;
import ru.borovkov.bravebird.engine.AnimationGame;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.engine.GameObjects;
import ru.borovkov.bravebird.utilits.UtilResource;

public class Eagle extends GameObjects {

    public AnimationGame animationSpriteEagle;

    private final int intervals = 4;
    private final int heightInterval;

    public Eagle(int maxX, int maxY, int eagleY, int speedEagle) {
        this.maxX = maxX;
        this.maxY = maxY - UtilResource.spriteEagle.get(0).getHeight();
        this.heightInterval = maxY / 4;
        x = maxX;
        y = eagleY;
        speed = speedEagle;
        radius = UtilResource.spriteEagle.get(0).getWidth() / 4d;
        animationSpriteEagle = new AnimationGame(1, UtilResource.spriteEagle.get(0),
                UtilResource.spriteEagle.get(1),
                UtilResource.spriteEagle.get(2),
                UtilResource.spriteEagle.get(3),
                UtilResource.spriteEagle.get(4),
                UtilResource.spriteEagle.get(5),
                UtilResource.spriteEagle.get(6),
                UtilResource.spriteEagle.get(7));
    }

    public void update() {
        x -= speed;
        if (x + UtilResource.spriteEagle.get(0).getWidth() < 0) {
            x = maxX;
            int randomInterval = (int) (Math.random() * (intervals - 1));
            int intervalY = (int) (Math.random() * (heightInterval - UtilResource.spriteEagle.get(0).getHeight()));
            y = intervalY + heightInterval * randomInterval;
            speed = (int) (Math.random() * 5 + 9);
        }
        animationSpriteEagle.runAnimation();
        hitBox = new Rect(x, y,
                UtilResource.spriteEagle.get(0).getWidth(),
                UtilResource.spriteEagle.get(0).getHeight());
    }

    public void drawing(GameGraphics gameGraphics){
        animationSpriteEagle.drawingAnimation(gameGraphics, x, y);
    }
}

package ru.borovkov.bravebird.objects;

import android.graphics.Bitmap;
import ru.borovkov.bravebird.DataHolder;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.engine.GameObjects;
import ru.borovkov.bravebird.utilits.UtilResource;

public class Background extends GameObjects {

    private final int SPEED_BACKGROUND = -15;

    private final int maxScreenX;
    private int sprite1X;
    private int sprite2X;
    private final int spriteY;

    private Bitmap sprite1;
    private Bitmap sprite2;

    public Background(int maxScreenX) {
        this.maxScreenX = maxScreenX;
        sprite2X = maxScreenX;
        sprite1X = 0;
        spriteY = 0;
        setLocation();
    }

    public void update() {
        sprite1X += SPEED_BACKGROUND;
        sprite2X += SPEED_BACKGROUND;

        if (sprite1X + maxScreenX < 0) {
            sprite1X = sprite2X + maxScreenX;
        }
        if (sprite2X + maxScreenX < 0) {
            sprite2X = sprite1X + maxScreenX;
        }
    }

    public void drawing(GameGraphics gameGraphics) {
        if (sprite1X < maxScreenX) {
            gameGraphics.drawTexture(sprite1, sprite1X, spriteY);
        }
        if (sprite2X < maxScreenX) {
            gameGraphics.drawTexture(sprite2, sprite2X, spriteY);
        }
    }

    public void setLocation() {

        if (DataHolder.getInstance().getData() == 1) {
            this.sprite1 = UtilResource.spriteFirstLocation.get(0);
            this.sprite2 = UtilResource.spriteFirstLocation.get(1);
        } else if (DataHolder.getInstance().getData() == 3) {
            this.sprite1 = UtilResource.spriteThirdLocation.get(0);
            this.sprite2 = UtilResource.spriteThirdLocation.get(1);
        } else {
            this.sprite1 = UtilResource.spriteSecondLocation.get(0);
            this.sprite2 = UtilResource.spriteSecondLocation.get(1);
        }
    }
}

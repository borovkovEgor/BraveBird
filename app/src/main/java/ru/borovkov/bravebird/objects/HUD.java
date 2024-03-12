package ru.borovkov.bravebird.objects;

import android.graphics.Bitmap;
import ru.borovkov.bravebird.utilits.UtilResource;
import ru.borovkov.bravebird.engine.GameGraphics;

public class HUD {

    private boolean one;
    private boolean two;
    private boolean three;

    private final Bitmap heart;

    public HUD() {
        this.heart = Bitmap.createScaledBitmap(UtilResource.quantityOfLife, 93, 78, true);
        this.three = true;
        this.two = false;
        this.one = false;
    }

    public void update(int quantityOfLife) {

        if (quantityOfLife == 2) {
            three = false;
            two = true;
        }
        if (quantityOfLife == 1) {
            two = false;
            one = true;
        }
        if (quantityOfLife == 0) {
            one = false;
        }
    }

    public void drawing(GameGraphics gameGraphics) {
        if (three) {
            gameGraphics.drawTexture(heart, 15, 15);
            gameGraphics.drawTexture(heart, 123, 15);
            gameGraphics.drawTexture(heart, 231, 15);
        }
        if (two) {
            gameGraphics.drawTexture(heart, 15, 15);
            gameGraphics.drawTexture(heart, 123, 15);
        }
        if (one) {
            gameGraphics.drawTexture(heart, 15, 15);
        }
    }


}

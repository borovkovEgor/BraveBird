package ru.borovkov.bravebird.engine;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.InputStream;

public class GameGraphics {

    private final AssetManager assetManager;
    private final Bitmap frameBufferGame;
    private final Canvas canvas;
    private final Paint paint;

    public GameGraphics(AssetManager assetManager, Bitmap frameBufferGame) {
        this.assetManager = assetManager;
        this.frameBufferGame = frameBufferGame;
        this.canvas = new Canvas(frameBufferGame);
        this.paint = new Paint();
    }

    public Bitmap textureManager(String fileName) {
        InputStream inputStream;
        Bitmap texture;
        try {
            inputStream = assetManager.open(fileName);
            texture = BitmapFactory.decodeStream(inputStream);
            if (texture == null) {
                throw new RuntimeException("The file cannot be uploaded" + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return texture;
    }

    public Bitmap newSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite) {
        return Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
    }

    public void drawTexture(Bitmap texture, int x, int y) {
        canvas.drawBitmap(texture, x, y, paint);
    }

    public int getWidthFrameBuffer() {
        return frameBufferGame.getWidth();
    }

    public int getHeightFrameBuffer() {
        return frameBufferGame.getHeight();
    }
}

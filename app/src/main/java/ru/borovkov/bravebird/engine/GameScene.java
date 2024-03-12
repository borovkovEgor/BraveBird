package ru.borovkov.bravebird.engine;

import ru.borovkov.bravebird.GameCore;

public abstract class GameScene {

    public GameCore gameCore;
    public GameGraphics gameGraphics;
    public int sceneWidth;
    public int sceneHeight;

    public GameScene(GameCore gameCore) {
        this.gameCore = gameCore;
        gameGraphics = gameCore.getGameGraphics();
        sceneWidth = gameCore.getGameGraphics().getWidthFrameBuffer();
        sceneHeight = gameCore.getGameGraphics().getHeightFrameBuffer();
    }

    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();

}

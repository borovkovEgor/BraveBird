package ru.borovkov.bravebird.scenes;

import ru.borovkov.bravebird.management.GameManager;
import ru.borovkov.bravebird.GameCore;
import ru.borovkov.bravebird.utilits.UtilResource;
import ru.borovkov.bravebird.engine.GameScene;

public class PlayScene extends GameScene {

    enum GameState{
        READY, RUNNING, PAUSE, GAMEOVER
    }

    public GameState gameState;
    public GameManager gameManager;

    public PlayScene(GameCore gameCore) {
        super(gameCore);
        this.gameCore = gameCore;
        gameState = GameState.READY;
        gameManager = new GameManager(gameCore, sceneWidth, sceneHeight);
        UtilResource.gameMusic.play(true, 1f);
    }

    @Override
    public void update() {
        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            updateStateGameOver();
        }
    }

    @Override
    public void drawing() {

        if (gameState == GameState.READY) {
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            drawingStateGameOver();
        }
    }

    private void drawingStateReady() {
        gameGraphics.drawTexture(UtilResource.preGameBackground, 0, 0);
    }

    private void updateStateReady() {
        if(gameCore.getGameTouchListener().getTouchUp(0, 0, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    private void drawingStateRunning() {
        gameManager.drawing(gameGraphics);
    }

    private void updateStateRunning() {
        gameManager.update();
        if (GameManager.gameOver) {
            gameState = GameState.GAMEOVER;
        }
    }

    private void drawingStatePause() {
    }

    private void updateStatePause() {
    }

    private void drawingStateGameOver() {
    }

    private void updateStateGameOver() {
        gameCore.goToGameOverActivity();
    }

    @Override
    public void pause() {
        UtilResource.gameMusic.stop();
    }

    @Override
    public void resume() {
        UtilResource.gameMusic.play(true, 1f);
    }

    @Override
    public void dispose() {
        UtilResource.gameMusic.dispose();
    }
}

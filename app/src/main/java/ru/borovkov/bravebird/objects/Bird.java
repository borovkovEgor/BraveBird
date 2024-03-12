package ru.borovkov.bravebird.objects;

import android.graphics.Rect;

import ru.borovkov.bravebird.management.GameManager;
import ru.borovkov.bravebird.engine.AnimationGame;
import ru.borovkov.bravebird.GameCore;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.engine.GameObjects;
import ru.borovkov.bravebird.utilits.UtilResource;
import ru.borovkov.bravebird.utilits.UtilTimerDelay;

public class Bird extends GameObjects {

    enum FlightState {
        UP, DOWN, DEFAULT
    }

    private FlightState flightState;

    private final int SPEED_UP = -8;
    private final int SPEED_DOWN = 8;

    private final GameCore gameCore;

    private AnimationGame animationBirdDefault;
    private AnimationGame animationBirdUp;
    private AnimationGame animationBirdDown;

    private AnimationGame animationBirdShieldDefault;
    private AnimationGame animationBirdShieldUp;
    private AnimationGame animationBirdShieldDown;

    private AnimationGame animationCollision;
    private AnimationGame animationGameOver;

    public UtilTimerDelay timerShieldsOn;

    private boolean isCollision;
    private boolean isGameOver;
    public static boolean isProtector;

    private int quantityOfLife;

    public Bird(GameCore gameCore, int maxX, int maxY) {
        this.gameCore = gameCore;
        this.maxX = maxX;
        this.maxY = maxY - UtilResource.spriteBirdDefault.get(0).getHeight();
        timerShieldsOn = new UtilTimerDelay();
        flightState = FlightState.DEFAULT;
        radius = UtilResource.spriteBirdDefault.get(0).getWidth() / 4d;
        quantityOfLife = 3;
        isProtector = false;
        isGameOver = false;
        isCollision = false;
        x = 525;
        y = 607;

        initAnimation();
    }

    public void stateFlight() {

        if (isTouchDownLeftHalf()) {
            flightState = FlightState.DOWN;
        } else if (isTouchDownRightHalf()) {
            flightState = FlightState.UP;
        } else if (isTouchUpLeftHalf()) {
            flightState = FlightState.DEFAULT;
        } else if (isTouchUpRightHalf()) {
            flightState = FlightState.DEFAULT;
        }
    }

    public void update() {

        stateFlight();

        if (timerShieldsOn.timerDelay(5)) {
            isProtector = false;
        }

        if (!isGameOver) {
            if (!isCollision) {
                if (isProtector) {
                    if (flightState == FlightState.DEFAULT) {
                        animationBirdShieldDefault.runAnimation();
                        speed = 0;
                    }
                    if (flightState == FlightState.UP) {
                        animationBirdShieldUp.runAnimation();
                        speed = SPEED_UP;
                    }
                    if (flightState == FlightState.DOWN) {
                        animationBirdShieldDown.runAnimation();
                        speed = SPEED_DOWN;
                    }
                } else {
                    if (flightState == FlightState.DEFAULT) {
                        animationBirdDefault.runAnimation();
                        speed = 0;
                    }
                    if (flightState == FlightState.UP) {
                        animationBirdUp.runAnimation();
                        speed = SPEED_UP;
                    }
                    if (flightState == FlightState.DOWN) {
                        animationBirdDown.runAnimation();
                        speed = SPEED_DOWN;
                    }
                }
            } else {
                animationCollision.runAnimation();
                speed = 0;
                if (animationCollision.isAnimationIsFinished()) {
                    isCollision = false;
                }
            }
        } else {
            animationGameOver.runAnimation();
            speed = 0;
            if (animationGameOver.isAnimationIsFinished()) {
                GameManager.gameOver = true;
            }
        }
        y += speed;
        if (y < minY) {
            y = minY;
        }
        if (y > maxY) {
            y = maxY;
        }

        hitBox = new Rect( x,  y,
                UtilResource.spriteBirdDefault.get(0).getWidth(),
                UtilResource.spriteBirdDefault.get(0).getHeight());

    }

    public void drawing(GameGraphics gameGraphics){

        if (!isGameOver) {
            if (!isCollision) {
                if (isProtector) {
                    if (flightState == FlightState.DEFAULT) {
                        animationBirdShieldDefault.drawingAnimation(gameGraphics, x - 27, y - 12);
                    }
                    if (flightState == FlightState.UP) {
                        animationBirdShieldUp.drawingAnimation(gameGraphics, x - 25, y - 36);
                    }
                    if (flightState == FlightState.DOWN) {
                        animationBirdShieldDown.drawingAnimation(gameGraphics, x - 27, y - 15);
                    }
                } else {
                    if (flightState == FlightState.DEFAULT) {
                        animationBirdDefault.drawingAnimation(gameGraphics, x, y);
                    }
                    if (flightState == FlightState.UP) {
                        animationBirdUp.drawingAnimation(gameGraphics, x, y);
                    }
                    if (flightState == FlightState.DOWN) {
                        animationBirdDown.drawingAnimation(gameGraphics, x, y);
                    }
                }
            } else {
                animationCollision.drawingAnimation(gameGraphics, x - 34, y - 29);
            }
        } else {
            animationGameOver.drawingAnimation(gameGraphics, x, y);
        }

    }

    public void hitEagle() {
        if (!isProtector && !isCollision) {
            quantityOfLife--;
            isCollision = true;
        }
        if (quantityOfLife < 0) {
            isGameOver = true;
        }

    }

    public void hitProtector() {
        isProtector = true;
        timerShieldsOn.startTimer();
    }

    public int getQuantityOfLife() {
        return quantityOfLife;
    }

    public static boolean isProtector() {
        return isProtector;
    }

    private boolean isTouchUpLeftHalf() {
        return gameCore.getGameTouchListener().getTouchUp(0, 0, 960, 1080);
    }
    private boolean isTouchDownLeftHalf() {
        return gameCore.getGameTouchListener().getTouchDown(0, 0, 960, 1080);
    }
    private boolean isTouchUpRightHalf() {
        return gameCore.getGameTouchListener().getTouchUp(960, 0, 960, 1080);
    }
    private boolean isTouchDownRightHalf() {
        return gameCore.getGameTouchListener().getTouchDown(960, 0, 960, 1080);
    }

    private void initAnimation() {
        animationBirdDefault = new AnimationGame(1, UtilResource.spriteBirdDefault.get(0),
                UtilResource.spriteBirdDefault.get(1),
                UtilResource.spriteBirdDefault.get(2),
                UtilResource.spriteBirdDefault.get(3),
                UtilResource.spriteBirdDefault.get(4),
                UtilResource.spriteBirdDefault.get(5),
                UtilResource.spriteBirdDefault.get(6),
                UtilResource.spriteBirdDefault.get(7));
        animationBirdUp = new AnimationGame(1, UtilResource.spriteBirdUp.get(0),
                UtilResource.spriteBirdUp.get(1),
                UtilResource.spriteBirdUp.get(2),
                UtilResource.spriteBirdUp.get(3),
                UtilResource.spriteBirdUp.get(4),
                UtilResource.spriteBirdUp.get(5),
                UtilResource.spriteBirdUp.get(6),
                UtilResource.spriteBirdUp.get(7));
        animationBirdDown = new AnimationGame(1, UtilResource.spriteBirdDown.get(0),
                UtilResource.spriteBirdDown.get(1),
                UtilResource.spriteBirdDown.get(2),
                UtilResource.spriteBirdDown.get(3),
                UtilResource.spriteBirdDown.get(4),
                UtilResource.spriteBirdDown.get(5),
                UtilResource.spriteBirdDown.get(6),
                UtilResource.spriteBirdDown.get(7));
        animationCollision = new AnimationGame(0, UtilResource.spriteCollision.get(0),
                UtilResource.spriteCollision.get(1),
                UtilResource.spriteCollision.get(2),
                UtilResource.spriteCollision.get(3),
                UtilResource.spriteCollision.get(4),
                UtilResource.spriteCollision.get(5),
                UtilResource.spriteCollision.get(6),
                UtilResource.spriteCollision.get(7));
        animationGameOver = new AnimationGame(1, UtilResource.spriteGameOver.get(0),
                UtilResource.spriteGameOver.get(1),
                UtilResource.spriteGameOver.get(2),
                UtilResource.spriteGameOver.get(3),
                UtilResource.spriteGameOver.get(4),
                UtilResource.spriteGameOver.get(5),
                UtilResource.spriteGameOver.get(6),
                UtilResource.spriteGameOver.get(7));
        animationBirdShieldDefault = new AnimationGame(1, UtilResource.spriteBirdShieldDefault.get(0),
                UtilResource.spriteBirdShieldDefault.get(1),
                UtilResource.spriteBirdShieldDefault.get(2),
                UtilResource.spriteBirdShieldDefault.get(3),
                UtilResource.spriteBirdShieldDefault.get(4),
                UtilResource.spriteBirdShieldDefault.get(5),
                UtilResource.spriteBirdShieldDefault.get(6),
                UtilResource.spriteBirdShieldDefault.get(7));
        animationBirdShieldUp = new AnimationGame(1, UtilResource.spriteBirdShieldUp.get(0),
                UtilResource.spriteBirdShieldUp.get(1),
                UtilResource.spriteBirdShieldUp.get(2),
                UtilResource.spriteBirdShieldUp.get(3),
                UtilResource.spriteBirdShieldUp.get(4),
                UtilResource.spriteBirdShieldUp.get(5),
                UtilResource.spriteBirdShieldUp.get(6),
                UtilResource.spriteBirdShieldUp.get(7));
        animationBirdShieldDown = new AnimationGame(1, UtilResource.spriteBirdShieldDown.get(0),
                UtilResource.spriteBirdShieldDown.get(1),
                UtilResource.spriteBirdShieldDown.get(2),
                UtilResource.spriteBirdShieldDown.get(3),
                UtilResource.spriteBirdShieldDown.get(4),
                UtilResource.spriteBirdShieldDown.get(5),
                UtilResource.spriteBirdShieldDown.get(6),
                UtilResource.spriteBirdShieldDown.get(7));
    }
}

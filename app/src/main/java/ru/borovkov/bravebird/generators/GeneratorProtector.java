package ru.borovkov.bravebird.generators;

import ru.borovkov.bravebird.objects.Bird;
import ru.borovkov.bravebird.objects.Protector;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.utilits.UtilTimerDelay;

public class GeneratorProtector {

    public Protector protector;
    public UtilTimerDelay timerProtector;
    public int maxX;
    public int maxY;

    public GeneratorProtector(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        protector = new Protector(maxX, maxY);
        timerProtector = new UtilTimerDelay();
        timerProtector.startTimer();
    }

    public void update () {
        if (timerProtector.timerDelay(8) && (!Bird.isProtector())) {
            protector.update();
            if (protector.getX() < 0) {
                protector = null;
                protector = new Protector(maxX, maxY);
                timerProtector.startTimer();
            }
        }
    }

    public void drawing(GameGraphics gameGraphics) {
        protector.drawing(gameGraphics);
    }

    public Protector getProtector() {
        return protector;
    }

    public void hitProtectorWithBird() {
        protector = new Protector(maxX, maxY);
        timerProtector.startTimer();
    }
}

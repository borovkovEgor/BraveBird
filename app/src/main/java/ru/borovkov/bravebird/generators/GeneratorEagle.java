package ru.borovkov.bravebird.generators;

import ru.borovkov.bravebird.objects.Eagle;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.utilits.UtilResource;

import java.util.ArrayList;

public class GeneratorEagle {

    private final int maxX;
    private final int maxY;
    private final int heightInterval;

    public ArrayList<Eagle> eagleArrayList;

    public GeneratorEagle(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.heightInterval = maxY / 4;
        this.eagleArrayList = new ArrayList<>();
    }

    private void addEagle() {
        for (int i = 0; i < 4; i++) {
            int speed = (int) (Math.random() * 5 + 9);
            int intervalY = (int) (Math.random() * (heightInterval - UtilResource.spriteEagle.get(0).getHeight()));
            int y = intervalY + heightInterval * i;
            eagleArrayList.add(new Eagle(maxX, maxY, y, speed));
        }
    }

    public void update () {
        if (eagleArrayList.size() < 4) {
            addEagle();
        }
        for (int i = 0; i < eagleArrayList.size(); i++) {
            eagleArrayList.get(i).update();

        }
    }

    public void drawing(GameGraphics gameGraphics) {
        for (int i = 0; i < eagleArrayList.size(); i++) {
            eagleArrayList.get(i).drawing(gameGraphics);
        }
    }

    public void hitBird(Eagle eagle) {
        for (int i = 0; i < eagleArrayList.size(); i++) {
            eagleArrayList.remove(eagle);
        }
    }
}

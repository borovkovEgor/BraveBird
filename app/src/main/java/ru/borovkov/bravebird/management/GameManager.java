package ru.borovkov.bravebird.management;

import ru.borovkov.bravebird.GameCore;
import ru.borovkov.bravebird.generators.GeneratorEagle;
import ru.borovkov.bravebird.generators.GeneratorProtector;
import ru.borovkov.bravebird.objects.Background;
import ru.borovkov.bravebird.objects.Bird;
import ru.borovkov.bravebird.objects.HUD;
import ru.borovkov.bravebird.engine.CollisionDetect;
import ru.borovkov.bravebird.engine.GameGraphics;

public class GameManager {

    private final Bird bird;
    private final Background background;
    private final GeneratorEagle generatorEagle;
    private final GeneratorProtector generatorProtector;
    private final HUD hud;

    public static boolean gameOver;

    public GameManager(GameCore gameCore, int sceneWidth, int sceneHeight) {
        bird = new Bird(gameCore, sceneWidth, sceneHeight);
        background = new Background(sceneWidth);
        generatorEagle = new GeneratorEagle(sceneWidth, sceneHeight);
        generatorProtector = new GeneratorProtector(sceneWidth, sceneHeight);
        hud = new HUD();
        gameOver = false;
    }

    public void update() {
        background.update();
        bird.update();
        generatorEagle.update();
        generatorProtector.update();

        int quantityOfLife = bird.getQuantityOfLife();

        hud.update(quantityOfLife);

        checkHit();
    }

    public void drawing(GameGraphics gameGraphics) {
        background.drawing(gameGraphics);
        bird.drawing(gameGraphics);
        generatorEagle.drawing(gameGraphics);
        generatorProtector.drawing(gameGraphics);
        hud.drawing(gameGraphics);
    }

    private void checkHit() {
        for (int i = 0; i < generatorEagle.eagleArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(bird, generatorEagle.eagleArrayList.get(i))) {
                bird.hitEagle();
                generatorEagle.hitBird(generatorEagle.eagleArrayList.get(i));
            }
        }
        if (CollisionDetect.collisionDetect(bird, generatorProtector.getProtector())) {
            hitBirdWithProtector();
        }
    }

    private void hitBirdWithProtector() {
        bird.hitProtector();
        generatorProtector.hitProtectorWithBird();
    }

}

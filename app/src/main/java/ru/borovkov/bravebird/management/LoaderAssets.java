package ru.borovkov.bravebird.management;

import ru.borovkov.bravebird.GameCore;
import ru.borovkov.bravebird.engine.GameGraphics;
import ru.borovkov.bravebird.utilits.UtilResource;

import java.util.ArrayList;

public class LoaderAssets {

    public LoaderAssets(GameCore gameCore, GameGraphics gameGraphics) {
        loadTextureGame(gameGraphics);
        loadSpriteLocation(gameGraphics);
        loadSpritePlayer(gameGraphics);
        loadSpriteEnemy(gameGraphics);
        loadSpriteOther(gameGraphics);
        loadAudio(gameCore);
    }

    private void loadTextureGame(GameGraphics gameGraphics) {
        UtilResource.textureAtlas = gameGraphics.textureManager("titles.png");
        UtilResource.firstLocation = gameGraphics.textureManager("first_location.png");
        UtilResource.secondLocation = gameGraphics.textureManager("second_location.png");
        UtilResource.thirdLocation = gameGraphics.textureManager("third_location.png");
        UtilResource.preGameBackground = gameGraphics.textureManager("pregame_background.png");

        UtilResource.quantityOfLife = gameGraphics.textureManager("heart.png");
    }

    private void loadAudio(GameCore gameCore) {
        UtilResource.gameMusic = gameCore.getGameAudio().newMusic("star_fighter.mp3");
    }

    private void loadSpriteLocation(GameGraphics gameGraphics) {
        UtilResource.spriteFirstLocation = new ArrayList<>();
        UtilResource.spriteFirstLocation.add(gameGraphics.newSprite(UtilResource.firstLocation, 0, 0, 1920, 1080));
        UtilResource.spriteFirstLocation.add(gameGraphics.newSprite(UtilResource.firstLocation, 1920, 0, 1920, 1080));

        UtilResource.spriteSecondLocation = new ArrayList<>();
        UtilResource.spriteSecondLocation.add(gameGraphics.newSprite(UtilResource.secondLocation, 0, 0, 1920, 1080));
        UtilResource.spriteSecondLocation.add(gameGraphics.newSprite(UtilResource.secondLocation, 1920, 0, 1920, 1080));

        UtilResource.spriteThirdLocation = new ArrayList<>();
        UtilResource.spriteThirdLocation.add(gameGraphics.newSprite(UtilResource.thirdLocation, 0, 0, 1920, 1080));
        UtilResource.spriteThirdLocation.add(gameGraphics.newSprite(UtilResource.thirdLocation, 1920, 0, 1920, 1080));
    }

    private void loadSpriteEnemy(GameGraphics gameGraphics) {
        UtilResource.spriteEagle = new ArrayList<>();

        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 208, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 416, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 624, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 832, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1040, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1248, 574, 208, 198));
        UtilResource.spriteEagle.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1456, 574, 208, 198));
    }

    private void loadSpriteOther(GameGraphics gameGraphics) {
        UtilResource.spriteGameOver = new ArrayList<>();
        UtilResource.spriteProtector = new ArrayList<>();

        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 163, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 326, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 489, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 652, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 815, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 978, 772, 163, 165));
        UtilResource.spriteGameOver.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1141, 772, 163, 165));

        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 58, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 116, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 174, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 232, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 290, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 348, 1422, 58, 56));
        UtilResource.spriteProtector.add(gameGraphics.newSprite(UtilResource.textureAtlas, 406, 1422, 58, 56));

    }

    private void loadSpritePlayer(GameGraphics gameGraphics) {
        UtilResource.spriteBirdDefault = new ArrayList<>();
        UtilResource.spriteBirdUp = new ArrayList<>();
        UtilResource.spriteBirdDown = new ArrayList<>();
        UtilResource.spriteCollision = new ArrayList<>();
        UtilResource.spriteBirdShieldDefault = new ArrayList<>();
        UtilResource.spriteBirdShieldUp = new ArrayList<>();
        UtilResource.spriteBirdShieldDown = new ArrayList<>();


        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 115, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 230, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 345, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 460, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 575, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 690, 0, 115, 134));
        UtilResource.spriteBirdDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 805, 0, 115, 134));

        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 119, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 238, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 357, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 476, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 595, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 714, 134, 119, 114));
        UtilResource.spriteBirdUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 833, 134, 119, 114));

        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 117, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 234, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 351, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 468, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 585, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 702, 248, 117, 148));
        UtilResource.spriteBirdDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 819, 248, 117, 148));

        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 0, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 190, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 380, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 570, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 760, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 950, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 1140, 396, 190, 178)));
        UtilResource.spriteCollision.add((gameGraphics.newSprite(UtilResource.textureAtlas, 1330, 396, 190, 178)));

        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 167, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 334, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 501, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 668, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 835, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1002, 937, 167, 154));
        UtilResource.spriteBirdShieldDefault.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1169, 937, 167, 154));

        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 167, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 334, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 501, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 668, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 835, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1002, 1091, 167, 154));
        UtilResource.spriteBirdShieldUp.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1169, 1091, 167, 154));

        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 0, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 167, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 334, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 501, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 668, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 835, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1002, 1255, 167, 164));
        UtilResource.spriteBirdShieldDown.add(gameGraphics.newSprite(UtilResource.textureAtlas, 1169, 1255, 167, 164));
    }
}

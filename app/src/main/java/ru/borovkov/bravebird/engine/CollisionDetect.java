package ru.borovkov.bravebird.engine;

public class CollisionDetect {

    public static double object1X;
    public static double object1Y;

    public static double object2X;
    public static double object2Y;

    public static double radiusObject1;
    public static double radiusObject2;

    public static double dx;
    public static double dy;

    public static double distanceObjects;

    public static boolean collisionDetect(GameObjects object1, GameObjects object2) {
        object1X = object1.getHitBox().centerX();
        object1Y = object1.getHitBox().centerY();

        object2X = object2.getHitBox().centerX();
        object2Y = object2.getHitBox().centerY();

        radiusObject1 = object1.getRadius();
        radiusObject2 = object2.getRadius();

        dx = object1X - object2X;
        dy = object1Y - object2Y;

        distanceObjects = Math.sqrt(dx * dx + dy * dy);

        return distanceObjects < radiusObject1 + radiusObject2;
    }
}

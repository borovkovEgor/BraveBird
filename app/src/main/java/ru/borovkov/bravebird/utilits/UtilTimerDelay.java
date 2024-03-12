package ru.borovkov.bravebird.utilits;

public class UtilTimerDelay {
    double startTime;
    double nowTime;
    double elapsedTime;
    final double SECOND = 1_000_000_000;

    public void startTimer() {
        startTime = System.nanoTime()/SECOND;
    }

    public boolean timerDelay(double second) {
        nowTime = System.nanoTime()/SECOND;
        elapsedTime = nowTime - startTime;
        return elapsedTime > second;
    }
}

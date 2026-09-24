package com.example.interviewday.models;

public class Time {

    // ===== Constant =====
    public static final int LEVEL_TIME = 10 * 60;

    // ===== Attributes =====
    private int remainingTime;
    private boolean running;

    // ===== Constructor =====
    public Time() {
        remainingTime = LEVEL_TIME;
        running = false;
    }

    // ===== Start =====

    public void start() {
        running = true;
    }

    // ===== Stop =====

    public void stop() {
        running = false;
    }

    // ===== Reset =====

    public void reset() {
        remainingTime = LEVEL_TIME;
        running = false;
    }

    // ===== Countdown =====

    public void decreaseTime(int seconds) {

        if (!running) {
            return;
        }

        remainingTime -= seconds;

        if (remainingTime <= 0) {
            remainingTime = 0;
            running = false;
        }
    }

    // ===== Check Time Up =====

    public boolean isTimeUp() {
        return remainingTime <= 0;
    }

    // ===== Get Remaining Time =====

    public int getRemainingTime() {
        return remainingTime;
    }

    // ===== Get Minutes =====

    public int getMinutes() {
        return remainingTime / 60;
    }

    // ===== Get Seconds =====

    public int getSeconds() {
        return remainingTime % 60;
    }

    // ===== Running Status =====

    public boolean isRunning() {
        return running;
    }
}
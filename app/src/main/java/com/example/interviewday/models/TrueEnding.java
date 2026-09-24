package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการฉากจบแบบสมบูรณ์ (True Ending)
 * OOP: Inheritance + Polymorphism (override checkCondition())
 */
public class TrueEnding extends Ending {

    public TrueEnding(int endingID) {
        super(endingID, "True Ending");
    }

    @Override
    public boolean checkCondition(int completedLevels, int completedQuests, int secretItemsCollected) {
        return completedLevels >= 3 && secretItemsCollected >= 3;
    }
}

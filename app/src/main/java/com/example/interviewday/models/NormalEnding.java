package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการฉากจบแบบธรรมดาเมื่อผู้เล่นผ่านเงื่อนไขทั่วไป
 * OOP: Inheritance + Polymorphism (override checkCondition())
 */
public class NormalEnding extends Ending {

    public NormalEnding(int endingID) {
        super(endingID, "Normal Ending");
    }

    @Override
    public boolean checkCondition(int completedLevels, int completedQuests, int secretItemsCollected) {
        return completedLevels >= 3;
    }
}

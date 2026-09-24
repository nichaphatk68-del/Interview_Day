package com.example.interviewday.models;

/**
 * คลาสแม่: จัดเก็บข้อมูลและกำหนดรูปแบบของฉากจบเกม
 * OOP: Abstraction (checkCondition เป็น abstract, trigger() เป็น template method)
 */
public abstract class Ending {
    protected int endingID;
    protected String endingName;

    public Ending(int endingID, String endingName) {
        this.endingID = endingID;
        this.endingName = endingName;
    }

    public abstract boolean checkCondition(int completedLevels, int completedQuests, int secretItemsCollected);

    public void trigger(int completedLevels, int completedQuests, int secretItemsCollected) {
        if (checkCondition(completedLevels, completedQuests, secretItemsCollected)) {
            showCutscene();
        }
    }

    protected void showCutscene() {
        System.out.println("แสดงฉากจบ: " + endingName);
    }
}

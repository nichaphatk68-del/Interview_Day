package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการเควสหลักที่ผู้เล่นต้องทำเพื่อดำเนินเนื้อเรื่อง
 * OOP: Inheritance + Polymorphism (override completeQuest())
 */
public class MainQuest extends Quest {

    private int unlocksLevelID;

    public MainQuest(int questID, String questName, int unlocksLevelID) {
        super(questID, questName);
        this.unlocksLevelID = unlocksLevelID;
    }

    @Override
    public void completeQuest() {
        setCompleted();
        System.out.println("ทำเควสหลัก '" + questName + "' สำเร็จ -> ปลดล็อกด่าน " + unlocksLevelID);
    }
}

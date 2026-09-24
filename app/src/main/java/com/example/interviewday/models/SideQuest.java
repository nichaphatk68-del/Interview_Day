package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการเควสย่อย
 * OOP: Inheritance + Polymorphism (override completeQuest())
 */
public class SideQuest extends Quest {
    private String requiredItemName;

    public SideQuest(int questID, String questName, String requiredItemName) {
        super(questID, questName);
        this.requiredItemName = requiredItemName;
    }

    @Override
    public void completeQuest() {
        setCompleted();
        System.out.println("ทำเควสย่อย '" + questName + "' สำเร็จ (ต้องใช้: " + requiredItemName + ")");
    }
}

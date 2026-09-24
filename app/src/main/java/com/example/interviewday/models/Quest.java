package com.example.interviewday.models;

/**
 * คลาสแม่: จัดเก็บข้อมูลและสถานะพื้นฐานของเควส
 * OOP: Abstraction + Encapsulation (status เป็น private เปลี่ยนผ่าน method เท่านั้น)
 */
public abstract class Quest {
    protected int questID;
    protected String questName;
    private QuestStatus status;

    public Quest(int questID, String questName) {
        this.questID = questID;
        this.questName = questName;
        this.status = QuestStatus.NOT_STARTED;
    }

    public void updateProgress() {
        this.status = QuestStatus.IN_PROGRESS;
    }

    // ลูกต้อง implement ผลลัพธ์ตอนเควสสำเร็จของตัวเอง
    public abstract void completeQuest();

    protected void setCompleted() {
        this.status = QuestStatus.COMPLETED;
    }

    public QuestStatus getStatus() {
        return status;
    }

    public String getQuestName() {
        return questName;
    }
}

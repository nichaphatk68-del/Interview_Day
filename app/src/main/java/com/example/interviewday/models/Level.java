package com.example.interviewday.models;

/**
 * คลาสแม่: จัดเก็บข้อมูลพื้นฐานและสถานะของแต่ละด่าน
 * OOP: Abstraction (กำหนดโครงสร้างกลาง ไม่ลงรายละเอียดเนื้อหาด่านจริง)
 *      Encapsulation (status เป็น private/protected เข้าถึงผ่าน method เท่านั้น)
 */
public abstract class Level {
    protected int levelID;
    protected String levelName;
    protected LevelStatus status;

    public Level(int levelID, String levelName) {
        this.levelID = levelID;
        this.levelName = levelName;
        this.status = LevelStatus.LOCKED;
    }

    // ลูกต้อง implement เอง ว่าโหลดเนื้อหาด่านของตัวเองอย่างไร
    public abstract void loadContent();

    public void startLevel() {
        if (status == LevelStatus.LOCKED) {
            System.out.println(levelName + " ยังไม่ถูกปลดล็อก");
            return;
        }
        loadContent();
        System.out.println("เริ่มด่าน: " + levelName);
    }

    public void completeLevel() {
        this.status = LevelStatus.COMPLETED;
        System.out.println(levelName + " ผ่านเรียบร้อยแล้ว");
    }

    public void unlock() {
        this.status = LevelStatus.UNLOCKED;
    }

    public LevelStatus getStatus() {
        return status;
    }

    public int getLevelID() {
        return levelID;
    }

    public String getLevelName() {
        return levelName;
    }
}

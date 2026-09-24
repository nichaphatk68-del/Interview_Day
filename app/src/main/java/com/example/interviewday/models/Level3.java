package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการรายละเอียดและเนื้อหาของด่านที่ 3
 * OOP: Inheritance + Polymorphism (override loadContent())
 */
public class Level3 extends Level {

    private boolean isFinalLevel;

    public Level3() {
        super(3, "ห้องสัมภาษณ์งานกับทีมเทคนิคและวิศวกร");
        this.isFinalLevel = true;
    }

    @Override
    public void loadContent() {
        System.out.println("โหลดเนื้อหาด่าน 3: สัมภาษณ์งานวิศวกร (ด่านสุดท้าย)");
    }

    public boolean isFinalLevel() {
        return isFinalLevel;
    }
}

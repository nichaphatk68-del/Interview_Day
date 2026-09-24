package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการรายละเอียดและเนื้อหาของด่านที่ 2
 * OOP: Inheritance + Polymorphism (override loadContent())
 */
public class Level2 extends Level {

    private String grammarTopic;

    public Level2() {
        super(2, "ห้องเรียนเครื่องมือคอมพิวเตอร์และอุปกรณ์อิเล็กทรอนิกส์พื้นฐาน");
        this.grammarTopic = "Computer Hardware Tools";
    }

    @Override
    public void loadContent() {
        System.out.println("โหลดเนื้อหาด่าน 2: หัวข้อ " + grammarTopic);
    }
}

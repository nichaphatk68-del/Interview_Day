package com.example.interviewday.models;
/**
 * คลาสลูก: จัดการรายละเอียดและเนื้อหาของด่านที่ 1
 * OOP: Inheritance (สืบทอดจาก Level) + Polymorphism (override loadContent())
 */
public class Level1 extends Level {

    private String vocabularyTopic;

    public Level1() {
        super(1, "ห้องนอนสุดรก");
        this.vocabularyTopic = "OOP Concepts";
    }

    @Override
    public void loadContent() {
        System.out.println("โหลดเนื้อหาด่าน 1: หัวข้อ " + vocabularyTopic);
    }
}

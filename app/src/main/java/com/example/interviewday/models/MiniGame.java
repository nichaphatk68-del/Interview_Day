package com.example.interviewday.models;

/**
 * คลาสแม่: กำหนดข้อมูลและรูปแบบพื้นฐานของมินิเกม
 * OOP: Abstraction (checkAnswer เป็น abstract method ให้ลูกกำหนดวิธีตรวจเอง)
 */
public abstract class MiniGame {
    protected int gameID;
    protected String gameName;

    public MiniGame(int gameID, String gameName) {
        this.gameID = gameID;
        this.gameName = gameName;
    }

    public abstract boolean checkAnswer(String playerInput);

    public String getGameName() {
        return gameName;
    }
}

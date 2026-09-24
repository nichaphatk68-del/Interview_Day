package com.example.interviewday.models;

/**
 * คลาสลูก: มินิเกมฝึกพูดภาษาอังกฤษและตรวจสอบคำตอบจากการพูด
 * OOP: Inheritance + Polymorphism (override checkAnswer())
 */
public class SpeakingGame extends MiniGame {
    private String expectedPhrase;

    public SpeakingGame(int gameID, String gameName, String expectedPhrase) {
        super(gameID, gameName);
        this.expectedPhrase = expectedPhrase;
    }

    @Override
    public boolean checkAnswer(String playerInput) {
        boolean isCorrect = playerInput.trim().equalsIgnoreCase(expectedPhrase.trim());
        System.out.println("[Speaking] ตรวจคำตอบจากการพูด: " + (isCorrect ? "ถูกต้อง" : "ผิด"));
        return isCorrect;
    }
}

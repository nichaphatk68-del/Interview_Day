package com.example.interviewday.models;

public class Answer {

    // ===== Attributes =====
    private String answerText;
    private boolean correct;
    private double accuracy;
    private double pronunciationScore;

    // ===== Constructor =====
    public Answer(String answerText) {

        this.answerText = answerText;
        this.correct = false;
        this.accuracy = 0.0;
        this.pronunciationScore = 0.0;
    }

    // ===== Validate Answer =====

    public boolean validateAnswer(String correctAnswer) {

        if (answerText == null || correctAnswer == null) {
            correct = false;
            accuracy = 0.0;
            return false;
        }

        correct = answerText.trim()
                .equalsIgnoreCase(correctAnswer.trim());

        if (correct) {
            accuracy = 100.0;
        } else {
            accuracy = 0.0;
        }

        return correct;
    }

    // ===== Set Pronunciation Score =====

    public void setPronunciationScore(double score) {

        if (score < 0) {
            pronunciationScore = 0;
        } else if (score > 100) {
            pronunciationScore = 100;
        } else {
            pronunciationScore = score;
        }
    }

    // ===== Getters =====

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getPronunciationScore() {
        return pronunciationScore;
    }

    // ===== Setter =====

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
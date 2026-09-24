package com.example.interviewday.models;

public class Question {

    // ===== Attributes =====
    private int questionId;
    private String questionText;
    private String correctAnswer;
    private String questionType;
    private String audioFile;

    // ===== Constructor =====
    public Question(
            int questionId,
            String questionText,
            String correctAnswer,
            String questionType,
            String audioFile) {

        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = questionType;
        this.audioFile = audioFile;
    }

    // ===== Get Question =====

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getAudioFile() {
        return audioFile;
    }

    // ===== Check Answer =====

    public boolean checkAnswer(String answer) {

        if (answer == null) {
            return false;
        }

        return correctAnswer.equalsIgnoreCase(answer.trim());
    }

    // ===== Check Question Type =====

    public boolean isListeningQuestion() {
        return questionType.equalsIgnoreCase("Listening");
    }

    public boolean isSpeakingQuestion() {
        return questionType.equalsIgnoreCase("Speaking");
    }
}
package com.example.interviewday.models;

import java.util.ArrayList;
import java.util.List;

public class GameProgress  {

    // ===== Attributes =====
    private int currentLevel;
    private List<Integer> completedLevels;
    private List<Integer> completedQuests;
    private List<String> collectedItems;
    private List<String> collectedSecretItems;

    // ===== Constructor =====
    public GameProgress() {
        currentLevel = 1;
        completedLevels = new ArrayList<>();
        completedQuests = new ArrayList<>();
        collectedItems = new ArrayList<>();
        collectedSecretItems = new ArrayList<>();
    }

    // ===== Level =====

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void completeLevel(int level) {
        if (!completedLevels.contains(level)) {
            completedLevels.add(level);
        }
    }

    public boolean isLevelCompleted(int level) {
        return completedLevels.contains(level);
    }

    public List<Integer> getCompletedLevels() {
        return completedLevels;
    }

    // ===== Quest =====

    public void completeQuest(int questId) {
        if (!completedQuests.contains(questId)) {
            completedQuests.add(questId);
        }
    }

    public boolean isQuestCompleted(int questId) {
        return completedQuests.contains(questId);
    }

    public List<Integer> getCompletedQuests() {
        return completedQuests;
    }

    // ===== Item =====

    public void collectItem(String itemName) {
        if (!collectedItems.contains(itemName)) {
            collectedItems.add(itemName);
        }
    }

    public boolean hasItem(String itemName) {
        return collectedItems.contains(itemName);
    }

    public List<String> getCollectedItems() {
        return collectedItems;
    }

    // ===== Secret Item =====

    public void collectSecretItem(String itemName) {
        if (!collectedSecretItems.contains(itemName)) {
            collectedSecretItems.add(itemName);
        }
    }

    public boolean hasSecretItem(String itemName) {
        return collectedSecretItems.contains(itemName);
    }

    public List<String> getCollectedSecretItems() {
        return collectedSecretItems;
    }

    // ===== Reset =====

    public void resetProgress() {
        currentLevel = 1;
        completedLevels.clear();
        completedQuests.clear();
        collectedItems.clear();
        collectedSecretItems.clear();
    }
}
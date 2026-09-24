package com.example.interviewday.models;

import java.util.ArrayList;
import java.util.List;

public class Notebook {

    // ===== Attributes =====
    private List<String> stories;
    private List<String> discoveredItems;
    private List<String> vocabulary;
    private List<String> notes;

    // ===== Constructor =====
    public Notebook() {
        stories = new ArrayList<>();
        discoveredItems = new ArrayList<>();
        vocabulary = new ArrayList<>();
        notes = new ArrayList<>();
    }

    // ===== Story =====

    public void addStory(String story) {
        if (!stories.contains(story)) {
            stories.add(story);
        }
    }

    public List<String> getStories() {
        return stories;
    }

    // ===== Item =====

    public void addDiscoveredItem(String itemName) {
        if (!discoveredItems.contains(itemName)) {
            discoveredItems.add(itemName);
        }
    }

    public List<String> getDiscoveredItems() {
        return discoveredItems;
    }

    // ===== Vocabulary =====

    public void addVocabulary(String word) {
        if (!vocabulary.contains(word)) {
            vocabulary.add(word);
        }
    }

    public List<String> getVocabulary() {
        return vocabulary;
    }

    // ===== Note =====

    public void addNote(String note) {
        notes.add(note);
    }

    public List<String> getNotes() {
        return notes;
    }

    // ===== Clear Notebook =====

    public void clearNotebook() {
        stories.clear();
        discoveredItems.clear();
        vocabulary.clear();
        notes.clear();
    }
}
package com.example.interviewday.models;

/**
 * คลาสแม่: จัดเก็บข้อมูลพื้นฐานของไอเทมภายในเกม
 * OOP: Abstraction + Encapsulation (isCollected เป็น private เข้าถึงผ่าน method)
 */
public abstract class Item {
    protected int itemID;
    protected String itemName;
    protected String description;
    private boolean isCollected;

    public Item(int itemID, String itemName, String description) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.isCollected = false;
    }

    public void collect() {
        this.isCollected = true;
        System.out.println("เก็บไอเทม: " + itemName);
    }

    public boolean isCollected() {
        return isCollected;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }
}

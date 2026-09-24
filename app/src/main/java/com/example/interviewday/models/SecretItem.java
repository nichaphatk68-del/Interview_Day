package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการไอเทมลับที่ใช้ปลดล็อก True Ending
 * OOP: Inheritance + Encapsulation
 */
public class SecretItem extends Item {
    private String secretDetails;

    public SecretItem(int itemID, String itemName, String description, String secretDetails) {
        super(itemID, itemName, description);
        this.secretDetails = secretDetails;
    }

    public String getSecretDetails() {
        return secretDetails;
    }
}

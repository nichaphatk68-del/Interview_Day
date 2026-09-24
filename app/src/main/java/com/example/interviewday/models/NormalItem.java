package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการไอเทมทั่วไปที่ผู้เล่นสามารถค้นหาและเก็บได้
 * OOP: Inheritance (ใช้พฤติกรรมจาก Item ตรงๆ แทบไม่ปรับ)
 */
public class NormalItem extends Item {

    public NormalItem(int itemID, String itemName, String description) {
        super(itemID, itemName, description);
    }
}

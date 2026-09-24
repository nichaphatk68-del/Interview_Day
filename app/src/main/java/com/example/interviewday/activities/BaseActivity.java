package com.example.interviewday.activities;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity /*กำหนดให้คลาสนี้เป็นหน้าจอ Activity ตามมาตรฐาน Android*/ {

    // เมธอดที่ 1: ทำงานเมื่อสร้าง Activity ขึ้นมาครั้งแรก
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI(); // เรียกฟังก์ชันซ่อนแถบระบบทันทีที่เริ่มสร้างหน้าจอ
    }

    // เมธอดที่ 2: ทำงานเมื่อผู้เล่นพับจอแล้วเปิดกลับเข้ามาใหม่
    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI(); // ซ่อนแถบระบบอีกครั้งหากผู้เล่นพับจอแล้วกลับเข้ามาใหม่
    }

    // เมธอดที่ 3: เมธอดปรับการแสดงผลระบบให้ซ่อน Status Bar และ Navigation Bar
    // ฟังก์ชันสำหรับซ่อน แถบสถานะ (เวลา/แบต) และ แถบปุ่มกด Android ด้านล่าง
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }
}
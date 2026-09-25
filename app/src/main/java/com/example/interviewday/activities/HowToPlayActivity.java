package com.example.interviewday.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import com.example.interviewday.R;

public class HowToPlayActivity extends BaseActivity {
    //ATTRIBUTE
    private ImageButton btnHome; // อ้างอิงถึงปุ่มกลับหน้าหลัก

    //METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        // 1. ผูกปุ่มกดใน XML เข้ากับ Attribute
        initViews();

        // 2. ตั้งค่าเหตุการณ์เมื่อผู้เล่นกดปุ่ม
        setupListeners();
    }

    // เมธอดสำหรับค้นหาและผูกองค์ประกอบ UI จากไฟล์ XML
    private void initViews() {
        btnHome = findViewById(R.id.btnHome);
    }

    // เมธอดสำหรับจัดการคำสั่งกดปุ่ม
    private void setupListeners() {
        // กดปุ่ม Home -> ปิดหน้าคู่นี้แล้วกลับไปที่หน้า MainMenuActivity
        btnHome.setOnClickListener(v -> {
            finish(); // สั่งทำลาย Activity นี้เพื่อย้อนกลับไปหน้าเดิมที่เปิดมา
        });
    }
}
package com.example.interviewday.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import com.example.interviewday.R;

public class StageSelectionActivity extends BaseActivity {

    //ATTRIBUTES
    private ImageButton btnHome;    // ปุ่มย้อนกลับหน้าหลัก
    private ImageButton btnLevel1;  // ปุ่มเลือกด่าน 1
    private ImageButton btnLevel2;  // ปุ่มเลือกด่าน 2
    private ImageButton btnLevel3;  // ปุ่มเลือกด่าน 3

    // ตัวแปรเก็บสถานะการปลดล็อกด่าน
    private boolean isLevel2Unlocked = false;
    private boolean isLevel3Unlocked = false;

    //METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_selection);

        // 1. ผูก View ใน XML เข้ากับ Attribute
        initViews();

        // 2. ตั้งค่า Event ปุ่มกด
        setupListeners();
    }

    // เมธอดผูกองค์ประกอบ UI จากไฟล์ XML
    private void initViews() {
        btnHome = findViewById(R.id.btnHome);
        btnLevel1 = findViewById(R.id.btnLevel1);
        btnLevel2 = findViewById(R.id.btnLevel2);
        btnLevel3 = findViewById(R.id.btnLevel3);
    }

    // เมธอดจัดการ Event การคลิกปุ่ม
    private void setupListeners() {
        // กดปุ่ม Home -> ปิดหน้านี้แล้วย้อนกลับไปหน้า MainMenuActivity
        btnHome.setOnClickListener(v -> finish());

        // กดปุ่ม Level 1 -> เข้าสู่ gameplay ด่าน 1
        btnLevel1.setOnClickListener(v -> {
            openGameStage(1);
        });

        // กดปุ่ม Level 2 -> เข้าสู่ gameplay ด่าน 2 (ถ้าปลดล็อกแล้ว)
        btnLevel2.setOnClickListener(v -> {
            if (isLevel2Unlocked) {
                openGameStage(2);
            }
        });

        // กดปุ่ม Level 3 -> เข้าสู่ gameplay ด่าน 3 (ถ้าปลดล็อกแล้ว)
        btnLevel3.setOnClickListener(v -> {
            if (isLevel3Unlocked) {
                openGameStage(3);
            }
        });
    }

    // เมธอดสำหรับเปลี่ยนหน้าไปยัง StoryActivity ตามหมายเลขด่าน
    private void openGameStage(int stageNumber) {

        Intent intent = new Intent(StageSelectionActivity.this, StoryActivity.class);
        intent.putExtra("STAGE_NUMBER", stageNumber);
        startActivity(intent);
    }

    // เมธอดสำหรับให้ Controller เรียกใช้เพื่อสั่งอัปเดตการปลดล็อกด่านบนหน้าจอ
    public void updateStageStatus(boolean level2Unlocked, boolean level3Unlocked) {
        this.isLevel2Unlocked = level2Unlocked;
        this.isLevel3Unlocked = level3Unlocked;

        // อัปเดตรูปภาพปุ่ม Level 2
        if (isLevel2Unlocked) {
            btnLevel2.setImageResource(R.drawable.btn_level_2);
        } else {
            btnLevel2.setImageResource(R.drawable.btn_level_locked);
        }

        // อัปเดตรูปภาพปุ่ม Level 3
        if (isLevel3Unlocked) {
            btnLevel3.setImageResource(R.drawable.btn_level_3);
        } else {
            btnLevel3.setImageResource(R.drawable.btn_level_locked);
        }
    }
}
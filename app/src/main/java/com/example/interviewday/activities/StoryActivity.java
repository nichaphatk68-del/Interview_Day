package com.example.interviewday.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.interviewday.R;

public class StoryActivity extends BaseActivity {

    //ATTRIBUTES
    private ImageView imgBackground;       // ภาพพื้นหลังของแต่ละด่าน
    private TextView tvStoryText;          // ข้อความบรรยายเนื้อเรื่อง
    private ConstraintLayout layoutStoryBox; // กล่องข้อความ (สำหรับแตะเพื่อไปต่อ)

    private int currentStage = 1;          // หมายเลขด่านปัจจุบัน (Default = 1)

    //METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // 1. รับค่าหมายเลขด่านที่ส่งมาจาก StageSelectionActivity หรือ Controller
        currentStage = getIntent().getIntExtra("STAGE_NUMBER", 1);

        // 2. ผูก View
        initViews();

        // 3. โหลดเนื้อหาและรูปภาพประจำด่าน
        loadStoryContent(currentStage);

        // 4. ตั้งค่า Event เมื่อแตะกล่องข้อความเพื่อเข้าสู่เกม
        setupListeners();
    }

    private void initViews() {
        imgBackground = findViewById(R.id.imgBackground);
        tvStoryText = findViewById(R.id.tvStoryText);
        layoutStoryBox = findViewById(R.id.layoutStoryBox);
    }

    // เมธอดดึงข้อมูลภาพและเนื้อเรื่องตามหมายเลขด่าน
    private void loadStoryContent(int stage) {
        switch (stage) {
            case 1:
                imgBackground.setImageResource(R.drawable.bg_story_stage1);
                tvStoryText.setText("8:00 น. แล้ว! วันนี้คือวันสัมภาษณ์ขอฝึกงานครั้งแรกในชีวิตของเด็กปี 2 ตื่นเต้นจนนอนไม่ค่อยหลับเลย! ถึงจะเป็นแค่การฝึกงาน แต่บริษัทนี้รับยากมาก ก่อนออกเดินทาง ต้องรีบเช็กกระเป๋าและเก็บอุปกรณ์พร้อมผลงานโปรเจกต์รายวิชาปี 2 ไปโชว์พี่ๆ ให้ครบ!");
                break;

            case 2:
                imgBackground.setImageResource(R.drawable.bg_story_stage2);
                tvStoryText.setText("08:30 น. อีกครึ่งชั่วโมงจะถึงเวลาสัมภาษณ์! แต่พี่ HR เพิ่งไลน์มาบอกว่า พี่ๆ วิศวกรอยากดูทั้งซอร์สโค้ดและไฟล์สำรองแล็บด้วย ต้องแวะเข้าห้องแล็บคอมฯ คณะเพื่อเอาของก่อน แต่ห้องแล็บเพิ่งผ่านเซกชันแล็บฮาร์ดแวร์มา สภาพรกมาก ต้องรีบหาของตาม TO-DO LIST ให้เจอ!");
                break;

            case 3:
                imgBackground.setImageResource(R.drawable.bg_story_stage3);
                tvStoryText.setText("08:45 น. ในที่สุดก็มาถึงบริษัท! บรรยากาศดูเป็นมืออาชีพและกดดันกว่าที่คิด พี่ HR บอกว่าถึงจะเป็นเด็กปี 2 แต่พี่ๆ จะทดสอบแนวคิดการเขียนโค้ดบนกระดาน และสัมภาษณ์เป็นภาษาอังกฤษด้วย! ต้องรวบรวมอุปกรณ์เตรียมตัวให้พร้อมก่อนถูกเรียกชื่อเข้าห้องสัมภาษณ์");
                break;
        }
    }

    private void setupListeners() {
        // แตะที่กล่องข้อความเพื่อเริ่มด่านเล่นเกม ( GameStageActivity )
        layoutStoryBox.setOnClickListener(v -> {
            startGameStage();
        });
    }

    private void startGameStage() {
        // สลับไปหน้าเล่นเกมหลัก พร้อมส่งหมายเลขด่านไปด้วย
        Intent intent = new Intent(StoryActivity.this, GameStageActivity.class);
        intent.putExtra("STAGE_NUMBER", currentStage);
        startActivity(intent);
        finish();
    }
}
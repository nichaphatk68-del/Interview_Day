package com.example.interviewday.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.interviewday.R;

public class GimmickDialog extends BaseDialog {

    // ประกาศตัวแปร View ทั้งหมดให้ตรงกับ XML
    private ImageView ivQuestionBadge;
    private TextView tvInstruction;
    private LinearLayout btnListen;
    private LinearLayout btnSpeak;
    private TextView tvPlayerAnswer;
    private ImageButton btnNextInside;
    private ImageButton btnNextOutside;
    private View cardNotepad;

    // สถานะด่านและข้อ (Stage 1-3, Question 0-2)
    private int currentStage = 1;      // ด่านที่ 1, 2, หรือ 3
    private int currentQuestion = 0;   // 0 = ข้อ 1, 1 = ข้อ 2, 2 = ข้อ 3

    // ข้อความคำสั่งสอนประจำแต่ละด่าน
    private final String[] stageInstructions = {
            "ด่านที่ 1: ฟังเสียงโจทย์ แล้วกดปุ่มพูดเพื่อตอบคำถาม",
            "ด่านที่ 2: อ่านโจทย์ แล้วกดปุ่มพูดตอบคำถามให้ถูกต้อง",
            "ด่านที่ 3: ดูข้อมูลสมุดโน้ตทางขวา แล้วพูดสรุปคำตอบ"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_gimmick_dialog, container, false);

        initViews(view);
        setupListeners();
        updateUI();

        return view;
    }

    // 1. ผูก View จาก XML
    private void initViews(View view) {
        ivQuestionBadge = view.findViewById(R.id.ivQuestionBadge);
        tvInstruction = view.findViewById(R.id.tvInstruction);
        btnListen = view.findViewById(R.id.btnListen);
        btnSpeak = view.findViewById(R.id.btnSpeak);
        tvPlayerAnswer = view.findViewById(R.id.tvPlayerAnswer);
        btnNextInside = view.findViewById(R.id.btnNextInside);
        btnNextOutside = view.findViewById(R.id.btnNextOutside);
        cardNotepad = view.findViewById(R.id.cardNotepad);
    }

    // 2. จัดการการคลิกปุ่มต่างๆ
    private void setupListeners() {
        // ปุ่มฟังเสียงโจทย์
        if (btnListen != null) {
            btnListen.setOnClickListener(v -> {
                // TODO: เรียกฟังก์ชันเล่นเสียงอ่านโจทย์ (Text-to-Speech)
            });
        }

        // ปุ่มกดเพื่อเริ่มพูดตอบ
        if (btnSpeak != null) {
            btnSpeak.setOnClickListener(v -> {
                // TODO: เรียกใช้ Speech-to-Text
            });
        }

        // ปุ่มถัดไปข้างในกล่องคำตอบ (สำหรับข้อ 1 และ 2)
        if (btnNextInside != null) {
            btnNextInside.setOnClickListener(v -> nextQuestion());
        }

        // ปุ่มถัดไปนอกการ์ด (สำหรับข้อ 3)
        if (btnNextOutside != null) {
            btnNextOutside.setOnClickListener(v -> nextQuestion());
        }
    }

    // 3. ฟังก์ชันหลักในการอัปเดต View ทั้งหมดตาม State ปัจจุบัน
    public void updateUI() {
        if (getContext() == null) return;

        // --- 3.1 สลับรูปโลโก้หัวข้อ QUESTION (1, 2, 3) ---
        if (ivQuestionBadge != null) {
            switch (currentQuestion) {
                case 0:
                    ivQuestionBadge.setImageResource(R.drawable.ic_logo_1);
                    break;
                case 1:
                    ivQuestionBadge.setImageResource(R.drawable.ic_logo_2);
                    break;
                case 2:
                    ivQuestionBadge.setImageResource(R.drawable.ic_logo_3);
                    break;
            }
        }

        // --- 3.2 เปลี่ยนข้อความคำแนะนำตามด่าน ---
        if (tvInstruction != null && currentStage >= 1 && currentStage <= stageInstructions.length) {
            tvInstruction.setText(stageInstructions[currentStage - 1]);
        }

        // --- 3.3 ควบคุมการแสดงผลการ์ดสมุดโน้ต (แสดงเฉพาะด่าน 3) ---
        if (cardNotepad != null) {
            if (currentStage == 3) {
                cardNotepad.setVisibility(View.VISIBLE);
            } else {
                cardNotepad.setVisibility(View.GONE);
            }
        }

        // --- 3.4 รีเซ็ตข้อความคำตอบและซ่อนปุ่มถัดไปก่อน ---
        if (tvPlayerAnswer != null) {
            tvPlayerAnswer.setText("กดปุ่มไมค์แล้วเริ่มพูดคำตอบ...");
        }
        if (btnNextInside != null) {
            btnNextInside.setVisibility(View.GONE);
        }
        if (btnNextOutside != null) {
            btnNextOutside.setVisibility(View.GONE);
        }
    }

    // 4. เรียกฟังก์ชันนี้เมื่อผู้เล่นพูดตอบเสร็จแล้ว เพื่อโชว์คำตอบและปุ่มถัดไป
    public void onSpeechResult(String recognizedText) {
        if (tvPlayerAnswer != null) {
            tvPlayerAnswer.setText(recognizedText);
        }

        // แสดงปุ่มถัดไปตามข้อที่เล่น
        if (currentQuestion == 2) {
            // หากเป็นข้อ 3 ให้โชว์ปุ่มถัดไปนอกการ์ด
            if (btnNextOutside != null) btnNextOutside.setVisibility(View.VISIBLE);
            if (btnNextInside != null) btnNextInside.setVisibility(View.GONE);
        } else {
            // หากเป็นข้อ 1 หรือ 2 ให้โชว์ปุ่มถัดไปในกล่องคำตอบ
            if (btnNextInside != null) btnNextInside.setVisibility(View.VISIBLE);
            if (btnNextOutside != null) btnNextOutside.setVisibility(View.GONE);
        }
    }

    // 5. ระบบเลื่อนข้อ / เลื่อนด่าน
    private void nextQuestion() {
        if (currentQuestion < 2) {
            currentQuestion++; // เปลี่ยนเป็นข้อถัดไป (1 -> 2 หรือ 2 -> 3)
            updateUI();
        } else {
            // หากทำครบ 3 ข้อในด่านนั้นแล้ว
            if (currentStage < 3) {
                currentStage++;     // ขึ้นด่านใหม่
                currentQuestion = 0; // รีเซ็ตไปเริ่มข้อ 1 ของด่านใหม่
                updateUI();
            } else {
                dismiss(); // หากเล่นครบหมดทั้ง 3 ด่านแล้ว ให้ปิด Dialog
            }
        }
    }

    // ฟังก์ชันสำหรับกำหนด Stage และ Question จากภายนอกก่อนสั่ง show()
    public void setStageAndQuestion(int stage, int question) {
        this.currentStage = stage;
        this.currentQuestion = question;
    }
}

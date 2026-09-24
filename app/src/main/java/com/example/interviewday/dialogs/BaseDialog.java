package com.example.interviewday.dialogs;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class BaseDialog extends DialogFragment /*คลาสพื้นฐานสำหรับสร้างหน้าต่างป๊อปอัพเด้งซ้อน*/{

    // เมธอดที่ 1: กำหนดสไตล์และคุณสมบัติพื้นฐานของ Dialog
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ลบแถบ Title Bar ดั้งเดิมของระบบ Android ออก เพื่อใช้ดีไซน์ป๊อปอัพที่เราวาดเอง
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    // เมธอดที่ 2: ทำงานตอนสั่งแสดงผล Dialog ขึ้นมาบนจอ
    @Override
    public void onStart() {
        super.onStart();
        // ปรับขนาดกรอบ Dialog ให้ขยายเต็มพื้นที่จอ เพื่อจัดเลย์เอาต์ป๊อปอัพได้ง่าย
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
        }
    }
}

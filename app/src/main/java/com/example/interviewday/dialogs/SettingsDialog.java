package com.example.interviewday.dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.interviewday.R;

public class SettingsDialog extends DialogFragment {

    public interface SettingsDialogListener {
        void onSaveSettings(boolean sfxOn, int sfxVol, boolean bgmOn, int bgmVol);
        void onCancelSettings();
    }

    private SettingsDialogListener listener;
    private boolean isSfxOn = true;
    private boolean isBgmOn = true;

    public static SettingsDialog newInstance() {
        return new SettingsDialog();
    }

    public void setListener(SettingsDialogListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_settings_dialog, container, false);

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        ImageButton btnSfxOn = view.findViewById(R.id.btnSfxOn);
        ImageButton btnSfxOff = view.findViewById(R.id.btnSfxOff);
        ImageButton btnBgmOn = view.findViewById(R.id.btnBgmOn);
        ImageButton btnBgmOff = view.findViewById(R.id.btnBgmOff);
        SeekBar seekbarSfx = view.findViewById(R.id.seekbarSfx);
        SeekBar seekbarBgm = view.findViewById(R.id.seekbarBgm);
        ImageButton btnCancel = view.findViewById(R.id.btnCancel);
        ImageButton btnOk = view.findViewById(R.id.btnOk);

        btnSfxOn.setOnClickListener(v -> isSfxOn = true);
        btnSfxOff.setOnClickListener(v -> isSfxOn = false);
        btnBgmOn.setOnClickListener(v -> isBgmOn = true);
        btnBgmOff.setOnClickListener(v -> isBgmOn = false);

        btnCancel.setOnClickListener(v -> {
            if (listener != null) listener.onCancelSettings();
            dismiss();
        });

        btnOk.setOnClickListener(v -> {
            if (listener != null) {
                listener.onSaveSettings(isSfxOn, seekbarSfx.getProgress(), isBgmOn, seekbarBgm.getProgress());
            }
            dismiss();
        });

        return view;
    }
}
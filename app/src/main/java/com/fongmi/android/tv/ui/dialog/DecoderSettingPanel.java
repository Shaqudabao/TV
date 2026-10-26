package com.fongmi.android.tv.ui.dialog;

import android.view.View;

import androidx.media3.common.C;
import androidx.media3.common.DecoderMode;

import com.fongmi.android.tv.R;
import com.fongmi.android.tv.databinding.DialogDecoderModeBinding;
import com.fongmi.android.tv.databinding.ViewDecoderModeRowBinding;
import com.fongmi.android.tv.player.PlayerManager;
import com.fongmi.android.tv.setting.PlayerSetting;
import com.google.android.material.button.MaterialButton;

import java.util.List;

final class DecoderSettingPanel {

    private final DialogDecoderModeBinding binding;
    private final PlayerManager player;
    private int trackType = C.TRACK_TYPE_VIDEO;

    DecoderSettingPanel(DialogDecoderModeBinding binding, PlayerManager player) {
        this.binding = binding;
        this.player = player;
    }

    void bind() {
        binding.auto.title.setText(R.string.decoder_mode_auto);
        binding.auto.summary.setText(R.string.decoder_mode_auto_detail);
        binding.hardware.getRoot().setVisibility(View.GONE);
        binding.software.getRoot().setVisibility(View.GONE);
        binding.ffmpeg.getRoot().setVisibility(View.GONE);
        boolean mpv = player.getEngine() == PlayerSetting.ENGINE_MPV;
        binding.tabGroup.setVisibility(mpv ? View.GONE : View.VISIBLE);
        trackType = C.TRACK_TYPE_VIDEO;
        if (!mpv) {
            SettingPanelViews.bindTabs(binding.tabGroup, getTabs(), index -> {
                trackType = index == 0 ? C.TRACK_TYPE_VIDEO : C.TRACK_TYPE_AUDIO;
                showModes();
            });
            PlaybackDialogFocus.selectFirstTab(binding.getRoot(), binding.tabGroup, binding.tabVideo);
        }
        showModes();
        if (mpv) PlaybackDialogFocus.request(binding.getRoot(), binding.auto.getRoot());
    }

    void release() {
        binding.tabGroup.clearOnButtonCheckedListeners();
        binding.auto.getRoot().setOnClickListener(null);
    }

    private MaterialButton[] getTabs() {
        return new MaterialButton[]{binding.tabVideo, binding.tabAudio};
    }

    private void showModes() {
        List<DecoderMode> modes = player.getSupportedDecoderModes(trackType);
        DecoderMode selected = player.getDecoderMode(trackType);
        binding.unavailable.setVisibility(modes.isEmpty() ? View.VISIBLE : View.GONE);
        bindMode(binding.auto, DecoderMode.AUTO, modes, selected);
        binding.hardware.getRoot().setVisibility(View.GONE);
        binding.software.getRoot().setVisibility(View.GONE);
        binding.ffmpeg.getRoot().setVisibility(View.GONE);
    }

    private void bindMode(ViewDecoderModeRowBinding row, DecoderMode mode, List<DecoderMode> modes, DecoderMode selected) {
        row.getRoot().setVisibility(modes.contains(mode) ? View.VISIBLE : View.GONE);
        row.getRoot().setSelected(mode == selected);
        row.getRoot().setContentDescription(row.title.getText() + ", " + row.summary.getText());
        row.getRoot().setOnClickListener(view -> selectMode(mode));
    }

    private void selectMode(DecoderMode mode) {
        if (player.isReleased() || mode == player.getDecoderMode(trackType)) return;
        player.setDecoderMode(trackType, mode);
        showModes();
    }
}

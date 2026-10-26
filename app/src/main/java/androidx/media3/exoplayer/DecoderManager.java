package androidx.media3.exoplayer;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.trackselection.DecodeTrackSelector;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 DecoderManager 在 1.11.0 标准 aar 中已移除。
 * 本实现仅保留 AUTO 解码模式语义：创建 DecodeTrackSelector 并将解码偏好设为硬件优先。
 * 运行时切换解码模式会通过 DecodeTrackSelector.setRendererDecodePreferences 生效。
 */
public final class DecoderManager {

    private final DecoderMode audioMode;
    private final DecoderMode videoMode;
    @Nullable private DecodeTrackSelector trackSelector;

    public DecoderManager(DecoderMode audioMode, DecoderMode videoMode) {
        this.audioMode = audioMode;
        this.videoMode = videoMode;
    }

    public void attach(ExoPlayer player) {
        // no-op in degraded implementation
    }

    public void detach() {
        // no-op in degraded implementation
    }

    public DecoderMode getAudioMode() {
        return audioMode;
    }

    public DecoderMode getVideoMode() {
        return videoMode;
    }

    public void selectAudioDecoder(DecoderMode mode) {
        apply(mode, videoMode);
    }

    public void selectVideoDecoder(DecoderMode mode) {
        apply(audioMode, mode);
    }

    public void setDecoderModes(DecoderMode audioMode, DecoderMode videoMode) {
        apply(audioMode, videoMode);
    }

    private void apply(DecoderMode audioMode, DecoderMode videoMode) {
        if (trackSelector != null) {
            trackSelector.setRendererDecodePreferences(toCDecodeMode(audioMode), toCDecodeMode(videoMode));
        }
    }

    public DecodeTrackSelector createTrackSelector(Context context) {
        DecodeTrackSelector trackSelector = new DecodeTrackSelector(context);
        trackSelector.setRendererDecodePreferences(toCDecodeMode(audioMode), toCDecodeMode(videoMode));
        this.trackSelector = trackSelector;
        return trackSelector;
    }

    private static int toCDecodeMode(@Nullable DecoderMode mode) {
        if (mode == null) return C.DECODE_HARDWARE;
        switch (mode) {
            case SW:
            case FFMPEG:
                return C.DECODE_SOFTWARE;
            case HW:
            case AUTO:
            default:
                return C.DECODE_HARDWARE;
        }
    }
}

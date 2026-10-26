package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.DecoderMode;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 androidx.media3.exoplayer.DecoderMode
 * 在 1.11.0 标准 aar 中已移除。仅用于桥接 common.DecoderMode 与解码选择逻辑。
 */
public enum DecoderMode {
    AUTO,
    SW,
    HW,
    FFMPEG;

    @Nullable
    public androidx.media3.common.DecoderMode toCommonDecoderMode() {
        switch (this) {
            case HW:
                return androidx.media3.common.DecoderMode.HARDWARE;
            case SW:
                return androidx.media3.common.DecoderMode.SOFTWARE;
            case FFMPEG:
                return androidx.media3.common.DecoderMode.FFMPEG;
            case AUTO:
            default:
                return androidx.media3.common.DecoderMode.AUTO;
        }
    }

    @Nullable
    public static DecoderMode fromCommonDecoderMode(@Nullable androidx.media3.common.DecoderMode mode) {
        if (mode == null) return AUTO;
        switch (mode) {
            case HARDWARE:
                return HW;
            case SOFTWARE:
                return SW;
            case FFMPEG:
                return FFMPEG;
            case AUTO:
            default:
                return AUTO;
        }
    }
}

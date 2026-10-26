package androidx.media3.exoplayer.iso;

import androidx.media3.common.MediaItem;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 IsoDiscPreparation 在 1.11.0 标准 aar 中已移除。
 * 本工程不需要光盘(ISO/BDMV)播放，isIso 固定返回 false。
 */
public final class IsoDiscPreparation {
    public static boolean isIso(MediaItem mediaItem) {
        return false;
    }
}

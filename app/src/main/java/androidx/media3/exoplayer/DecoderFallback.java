package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.PlaybackException;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 DecoderFallback 在 1.11.0 标准 aar 中已移除。
 * 降级实现不做解码回退重试。
 */
public final class DecoderFallback {

    @SuppressWarnings("unused")
    private final DecoderManager decoderManager;

    public DecoderFallback(DecoderManager decoderManager) {
        this.decoderManager = decoderManager;
    }

    public void reset(@C.TrackType int trackType) {
        // no-op in degraded implementation
    }

    public boolean retry(PlaybackException error) {
        return false;
    }
}

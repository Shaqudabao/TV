package androidx.media3.exoplayer.hls;

import android.net.Uri;

import androidx.annotation.Nullable;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 CmgConfiguration 在 1.11.0 标准 aar 中已移除。
 * 本项目不使用 CMG 专有点播，fromMediaUri 始终返回 null（即按普通 ExoPlayer 处理）。
 */
public final class CmgConfiguration {

    private CmgConfiguration() {
    }

    @Nullable
    public static CmgConfiguration fromMediaUri(Uri uri) {
        return null;
    }
}

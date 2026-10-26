package androidx.media3.exoplayer.iso;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.source.MediaSource;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 IsoNavigationPlayerController 在 1.11.0 标准 aar 中已移除。
 * 本工程不需要光盘(ISO/BDMV)导航，直接持有并透传底层 Player，不包装任何 ISO 媒体源。
 */
public final class IsoNavigationPlayerController {

    private final Player player;

    public IsoNavigationPlayerController(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public MediaSource prepareMediaSource(Context context, MediaSource mediaSource, DataSource.Factory dataSourceFactory) {
        return mediaSource;
    }

    public boolean isStarted() {
        return false;
    }

    public void close() {
        // no-op
    }
}

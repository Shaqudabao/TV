package androidx.media3.exoplayer.text;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.text.SubtitleContent;
import androidx.media3.exoplayer.ExoPlayer;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 SubtitleTranscriptSession 在 1.11.0 标准 aar 中已移除。
 * 字幕转录功能已精简，本类仅保留 TV 调用的空操作接口，标准字幕由 media3 自身渲染。
 */
public final class SubtitleTranscriptSession {

    public SubtitleTranscriptSession() {
    }

    public void setLoader(SubtitleContentLoader loader) {
        // no-op in degraded implementation
    }

    public void setPlayer(ExoPlayer player) {
        // no-op in degraded implementation
    }

    public SubtitleTranscript forMediaItem(MediaItem mediaItem) {
        return new SubtitleTranscript();
    }

    public void setPreloadMediaItem(@Nullable MediaItem mediaItem) {
        // no-op in degraded implementation
    }

    public void close() {
        // no-op in degraded implementation
    }

    public SubtitleContent getContent(Format format, long offsetMs) {
        return SubtitleContent.UNSUPPORTED;
    }

    public void setContentEnabled(boolean enabled) {
        // no-op in degraded implementation
    }

    public boolean canRetryContent(Format format) {
        return false;
    }

    public void retryContent(Format format) {
        // no-op in degraded implementation
    }
}

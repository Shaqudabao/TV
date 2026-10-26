package androidx.media3.exoplayer.libass;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.text.SubtitleTranscript;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.SubtitleParser;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 LibassPlaybackSession 在 1.11.0 标准 aar 中已移除。
 * isAvailable() 固定返回 false，使 TV 自动走标准字幕（SubtitleTranscriptSession）降级路径。
 */
public final class LibassPlaybackSession {

    public static final class MediaComponents {
        public final ExtractorsFactory extractorsFactory;
        public final SubtitleParser.Factory subtitleParserFactory;

        public MediaComponents(ExtractorsFactory extractorsFactory, SubtitleParser.Factory subtitleParserFactory) {
            this.extractorsFactory = extractorsFactory;
            this.subtitleParserFactory = subtitleParserFactory;
        }
    }

    private final LibassConfiguration configuration;
    private final boolean enabled;

    public LibassPlaybackSession(LibassConfiguration configuration, boolean enabled) {
        this.configuration = configuration;
        this.enabled = enabled;
    }

    public boolean isAvailable() {
        return false;
    }

    @Nullable
    public MediaComponents createMediaComponents(MediaItem mediaItem, ExtractorsFactory extractorsFactory, SubtitleTranscript transcript) {
        return null;
    }

    public void setPreloadMediaItem(@Nullable MediaItem mediaItem) {
        // no-op
    }

    public void close() {
        // no-op
    }

    @Nullable
    public Renderer createClockRenderer() {
        return null;
    }

    public void setBottomPositionFraction(float fraction) {
        // no-op
    }

    public void setSecondaryBottomPositionFraction(float fraction) {
        // no-op
    }

    public void setFontScale(float scale, boolean applyToAll) {
        // no-op
    }
}

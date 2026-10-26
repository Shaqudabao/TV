package androidx.media3.exoplayer.libass;

import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.text.SubtitleSelectionState;
import androidx.media3.exoplayer.text.SecondaryTextOutput;
import androidx.media3.exoplayer.trackselection.SecondaryTextTrackSelector;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 LibassSubtitleController 在 1.11.0 标准 aar 中已移除。
 * 副字幕选择状态返回 EMPTY，其余调用为空操作。标准字幕由 media3 自身的 SubtitleView 渲染。
 */
public final class LibassSubtitleController {

    public LibassSubtitleController(Player player, LibassPlaybackSession libassPlaybackSession,
                                    SecondaryTextTrackSelector.Factory secondaryTextTrackSelectorFactory,
                                    SecondaryTextOutput secondaryTextOutput) {
        // no-op
    }

    public void close() {
        // no-op
    }

    public SubtitleSelectionState getSubtitleSelectionState() {
        return SubtitleSelectionState.EMPTY;
    }

    public void setSecondaryTextTrackSelectionOverride(@Nullable TrackSelectionOverride selection) {
        // no-op
    }

    public void setSecondaryTextTrackAutoSelectionEnabled(boolean enabled) {
        // no-op
    }
}

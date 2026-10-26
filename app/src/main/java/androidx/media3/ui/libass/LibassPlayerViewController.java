package androidx.media3.ui.libass;

import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.libass.LibassPlaybackSession;
import androidx.media3.exoplayer.libass.LibassSubtitleController;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;

import java.util.function.Consumer;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 LibassPlayerViewController 在 1.11.0 标准 aar 中已移除。
 * setStyleOverride 首参用 Object 以兼容 TV 调用传入的 SubtitleSetting.getStyle() 类型，避免强耦合。
 */
public final class LibassPlayerViewController {

    public LibassPlayerViewController(Player player, LibassPlaybackSession libassPlaybackSession,
                                      LibassSubtitleController libassSubtitleController) {
        // no-op
    }

    public void close() {
        // no-op
    }

    public void bind(PlayerView playerView) {
        // no-op
    }

    public void setStyleOverride(@Nullable Object style, @Nullable String fontFamily) {
        // no-op
    }

    public void setSecondarySubtitleViewConfigurator(Consumer<SubtitleView> configurator) {
        // no-op
    }
}

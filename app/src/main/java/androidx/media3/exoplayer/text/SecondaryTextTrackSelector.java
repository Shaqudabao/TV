package androidx.media3.exoplayer.text;

import android.content.Context;

import androidx.media3.exoplayer.trackselection.TrackSelector;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 SecondaryTextTrackSelector 在 1.11.0 标准 aar 中已移除。
 * Factory 仅委托给被包装的 TrackSelector.Factory，使标准字幕轨道选择照常工作。
 */
public final class SecondaryTextTrackSelector {

    public static final class Factory implements TrackSelector.Factory {

        private final TrackSelector.Factory delegate;

        public Factory(TrackSelector.Factory delegate) {
            this.delegate = delegate;
        }

        @Override
        public TrackSelector createTrackSelector(Context context) {
            return delegate.createTrackSelector(context);
        }
    }
}

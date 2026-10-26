package androidx.media3.exoplayer.text;

import androidx.media3.common.text.CueGroup;
import androidx.media3.exoplayer.text.TextOutput;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 SecondaryTextOutput 在 1.11.0 标准 aar 中已移除。
 * 作为 TextOutput 的空实现，副字幕渲染交由标准 media3 文本渲染器处理。
 */
public final class SecondaryTextOutput implements TextOutput {

    @Override
    public void onCues(CueGroup cueGroup) {
        // no-op in degraded implementation
    }
}

package androidx.media3.common.util;

import androidx.media3.common.MediaItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 LocalClearKeyLicense 在 1.11.0 标准 aar 中已移除。
 * 降级实现返回空列表，表示无本地 clearkey（交由标准 DRM 流程处理）。
 */
public final class LocalClearKeyLicense {

    private LocalClearKeyLicense() {
    }

    public static List<?> parse(String key) {
        return new ArrayList<>();
    }

    public static List<?> parse(MediaItem.DrmConfiguration drmConfiguration) {
        return new ArrayList<>();
    }
}

package androidx.media3.datasource;

import android.net.Uri;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 IsoUri 在 1.11.0 标准 aar 中已移除。
 * 本项目不使用 ISO 光盘，直接返回原 Uri。
 */
public final class IsoUri {

    private IsoUri() {
    }

    public static Uri withEditionIndex(Uri uri, int editionIndex) {
        return uri;
    }
}

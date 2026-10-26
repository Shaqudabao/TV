package androidx.media3.exoplayer.libass;

import androidx.annotation.Nullable;
import java.io.File;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 LibassFontFile 在 1.11.0 标准 aar 中已移除。
 */
public final class LibassFontFile {
    @Nullable
    public static String getFamilyName(File file) {
        return null;
    }
}

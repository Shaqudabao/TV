package androidx.media3.exoplayer.iso;

import android.app.Application;
import android.os.CancellationSignal;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 BdjRuntime 在 1.11.0 标准 aar 中已移除。
 * 本工程不需要蓝光光盘(BD-J)运行时，prepare/getStatus 为空操作，restartRequired 固定 false。
 */
public final class BdjRuntime {

    public static final class Status {
        public boolean restartRequired;
    }

    public static void prepare(Application application, CancellationSignal signal) {
        // no-op
    }

    public static Status getStatus(Application application) {
        return new Status();
    }
}

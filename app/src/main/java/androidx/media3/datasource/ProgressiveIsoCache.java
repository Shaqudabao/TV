package androidx.media3.datasource;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 ProgressiveIsoCache 在 1.11.0 标准 aar 中已移除。
 * 本项目不使用 ISO 光盘缓存，直接透传原始 DataSource.Factory（磁盘缓存由 CacheDataSource 提供）。
 */
public final class ProgressiveIsoCache {

    private ProgressiveIsoCache() {
    }

    public static DataSource.Factory withDiskCache(DataSource.Factory factory, Cache cache) {
        return factory;
    }
}

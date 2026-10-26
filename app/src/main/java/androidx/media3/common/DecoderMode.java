package androidx.media3.common;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 androidx.media3.common.DecoderMode
 * 在 1.11.0 标准 aar 中已移除。TV 仅使用 AUTO 解码模式，其余常量保留以便编译。
 */
public enum DecoderMode {
    AUTO,
    HARDWARE,
    SOFTWARE,
    FFMPEG
}

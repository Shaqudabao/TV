package androidx.media3.exoplayer.libass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 补齐类（降级空实现）：FongMi 定制 media3 1.8.0 的 LibassConfiguration 在 1.11.0 标准 aar 中已移除。
 * 本工程不依赖 libass 字幕（片源自带字幕），此处仅提供匹配 TV 调用的空实现，使编译通过。
 */
public final class LibassConfiguration {

    public static final class Builder {
        private String fontConfig;
        private String fontsDirectory;
        private String defaultFontFamily;
        private int maximumRenderPixels;
        private int maximumGlyphCount;
        private int maximumBitmapCacheSizeMb;

        @NonNull
        public Builder setFontConfig(@Nullable String fontConfig) {
            this.fontConfig = fontConfig;
            return this;
        }

        @NonNull
        public Builder setFontsDirectory(@Nullable String fontsDirectory) {
            this.fontsDirectory = fontsDirectory;
            return this;
        }

        @NonNull
        public Builder setDefaultFontFamily(@Nullable String defaultFontFamily) {
            this.defaultFontFamily = defaultFontFamily;
            return this;
        }

        @NonNull
        public Builder setMaximumRenderPixels(int maximumRenderPixels) {
            this.maximumRenderPixels = maximumRenderPixels;
            return this;
        }

        @NonNull
        public Builder setMaximumGlyphCount(int maximumGlyphCount) {
            this.maximumGlyphCount = maximumGlyphCount;
            return this;
        }

        @NonNull
        public Builder setMaximumBitmapCacheSizeMb(int maximumBitmapCacheSizeMb) {
            this.maximumBitmapCacheSizeMb = maximumBitmapCacheSizeMb;
            return this;
        }

        @NonNull
        public LibassConfiguration build() {
            return new LibassConfiguration(this);
        }
    }

    private final String fontConfig;
    private final String fontsDirectory;
    private final String defaultFontFamily;
    private final int maximumRenderPixels;
    private final int maximumGlyphCount;
    private final int maximumBitmapCacheSizeMb;

    private LibassConfiguration(Builder builder) {
        this.fontConfig = builder.fontConfig;
        this.fontsDirectory = builder.fontsDirectory;
        this.defaultFontFamily = builder.defaultFontFamily;
        this.maximumRenderPixels = builder.maximumRenderPixels;
        this.maximumGlyphCount = builder.maximumGlyphCount;
        this.maximumBitmapCacheSizeMb = builder.maximumBitmapCacheSizeMb;
    }
}

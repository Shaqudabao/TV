package com.fongmi.android.tv.player.mpv;

import com.github.catvod.utils.Path;

import java.io.File;

/**
 * 最小占位实现：原 MpvConfigFile 依赖 androidx.media3.mpvplayer.MpvConfigFileInspector（mpv 原生，
 * 已移除）。字幕外部字体目录与 mpv 字体目录一致，直接复用 Path.mpv("fonts")。
 */
public final class MpvConfigFile {

    public static File getSubtitleFontsDirectory() {
        return Path.mpv("fonts");
    }
}

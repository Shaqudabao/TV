package com.fongmi.android.tv.player.mpv;

import androidx.annotation.Nullable;

/**
 * 最小占位实现：原 MpvScriptSession 依赖 androidx.media3.mpvplayer.MpvPlayer（mpv 原生引擎，
 * 本项目已移除 mpv 播放引擎，仅保留 ExoPlayer）。用户脚本按钮的 UI 仍引用 Status / State 两个
 * 嵌套类型，这里提供自洽的最小 API 使其可编译；运行时 mpv 脚本状态恒为 null（详见 PlayerManager）。
 */
public final class MpvScriptSession {

    public enum State {
        IDLE,
        LOADING,
        LOADED,
        RUNNING,
        DONE,
        ERROR,
        TIMEOUT
    }

    public static final class Status {
        private final State state;
        private final String error;

        public Status() {
            this(State.IDLE, "");
        }

        public Status(State state, String error) {
            this.state = state;
            this.error = error;
        }

        public State state() {
            return state;
        }

        @Nullable
        public String error() {
            return error;
        }
    }
}

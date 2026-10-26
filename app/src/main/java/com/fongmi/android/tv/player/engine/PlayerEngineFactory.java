package com.fongmi.android.tv.player.engine;

import static com.fongmi.android.tv.player.engine.PlayerEngine.Type.EXO;

import androidx.media3.common.Player;
import androidx.media3.exoplayer.hls.CmgConfiguration;

import com.fongmi.android.tv.player.exo.ExoPlayerEngine;
import com.fongmi.android.tv.player.media.MediaItemFactory;
import com.fongmi.android.tv.player.media.PlaySpec;
import com.github.catvod.utils.UriUtil;

public final class PlayerEngineFactory {

    public static PlayerEngine create(Player.Listener listener) {
        return create(resolve(), listener);
    }

    public static PlayerEngine create(PlaySpec spec, Player.Listener listener) {
        return create(resolve(spec), listener);
    }

    public static PlayerEngine create(PlayerEngine.Type type, Player.Listener listener) {
        return switch (type) {
            case EXO, MPV -> new ExoPlayerEngine(listener);
        };
    }

    public static boolean matches(PlayerEngine engine, PlaySpec spec) {
        return engine != null && engine.getType() == resolve(spec) && !engine.needsRebuild();
    }

    public static boolean canPreload(PlaySpec spec) {
        return !isCmg(spec);
    }

    private static PlayerEngine.Type resolve(PlaySpec spec) {
        return EXO;
    }

    private static PlayerEngine.Type resolve() {
        return EXO;
    }

    static boolean requiresExo(PlaySpec spec) {
        return isCmg(spec) || "smb".equals(UriUtil.scheme(spec.getUrl()));
    }

    private static boolean isCmg(PlaySpec spec) {
        return CmgConfiguration.fromMediaUri(spec.getUri()) != null;
    }
}

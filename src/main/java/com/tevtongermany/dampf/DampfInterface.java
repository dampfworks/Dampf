package com.tevtongermany.dampf;

import com.codedisaster.steamworks.*;

public class DampfInterface implements SteamUserStatsCallback {
    @Override
    public void onUserStatsReceived(long l, SteamID steamID, SteamResult steamResult) {

    }

    @Override
    public void onUserStatsStored(long l, SteamResult steamResult) {

    }

    @Override
    public void onUserStatsUnloaded(SteamID steamID) {

    }

    @Override
    public void onUserAchievementStored(long l, boolean b, String s, int i, int i1) {

    }

    @Override
    public void onLeaderboardFindResult(SteamLeaderboardHandle steamLeaderboardHandle, boolean b) {

    }

    @Override
    public void onLeaderboardScoresDownloaded(SteamLeaderboardHandle steamLeaderboardHandle, SteamLeaderboardEntriesHandle steamLeaderboardEntriesHandle, int i) {

    }

    @Override
    public void onLeaderboardScoreUploaded(boolean b, SteamLeaderboardHandle steamLeaderboardHandle, int i, boolean b1, int i1, int i2) {

    }

    @Override
    public void onNumberOfCurrentPlayersReceived(boolean b, int i) {

    }

    @Override
    public void onGlobalStatsReceived(long l, SteamResult steamResult) {

    }

    // ... application-specific implementation
}
package com.tevtongermany.dampf;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking;
import com.codedisaster.steamworks.SteamMatchmakingCallback;
import com.codedisaster.steamworks.SteamResult;
import org.apache.logging.log4j.Logger;

class DampfMatchmaking implements SteamMatchmakingCallback {

    private static Logger logger = Dampf.getLogger();

    @Override
    public void onFavoritesListChanged(int i, int i1, int i2, int i3, int i4, boolean b, int i5) {

    }

    @Override
    public void onLobbyInvite(SteamID steamID, SteamID steamID1, long l) {
        logger.info("Lobby invite received from " + steamID.getAccountID() + " to " + steamID1.getAccountID() + " with id " + l);
    }

    @Override
    public void onLobbyEnter(SteamID steamID, int i, boolean b, SteamMatchmaking.ChatRoomEnterResponse chatRoomEnterResponse) {
        logger.info("Lobby entered with id " + steamID.getAccountID() + " and response " + chatRoomEnterResponse.toString());

    }

    @Override
    public void onLobbyDataUpdate(SteamID steamID, SteamID steamID1, boolean b) {
        logger.info("Lobby data updated with id " + steamID.getAccountID() + " and id " + steamID1.getAccountID() + " and bool " + b);

    }

    @Override
    public void onLobbyChatUpdate(SteamID steamID, SteamID steamID1, SteamID steamID2, SteamMatchmaking.ChatMemberStateChange chatMemberStateChange) {
        logger.info("Lobby chat updated with id " + steamID.getAccountID() + " and id " + steamID1.getAccountID() + " and id " + steamID2.getAccountID() + " and state " + chatMemberStateChange.toString());

    }

    @Override
    public void onLobbyChatMessage(SteamID steamID, SteamID steamID1, SteamMatchmaking.ChatEntryType chatEntryType, int i) {
        logger.info("Lobby chat message received with id " + steamID.getAccountID() + " and id " + steamID1.getAccountID() + " and type " + chatEntryType.toString() + " and int " + i);

    }

    @Override
    public void onLobbyGameCreated(SteamID steamID, SteamID steamID1, int i, short i1) {
        logger.info("Lobby game created with id " + steamID.getAccountID() + " and id " + steamID1.getAccountID() + " and int " + i + " and short " + i1);

    }

    @Override
    public void onLobbyMatchList(int i) {
        logger.info("Lobby match list received with int " + i);

    }

    @Override
    public void onLobbyKicked(SteamID steamID, SteamID steamID1, boolean b) {
        logger.info("Lobby kicked with id " + steamID.getAccountID() + " and id " + steamID1.getAccountID() + " and bool " + b);

    }

    @Override
    public void onLobbyCreated(SteamResult steamResult, SteamID steamID) {
        logger.info("Lobby created with result " + steamResult.toString() + " and id " + steamID.getAccountID());

    }

    @Override
    public void onFavoritesListAccountsUpdated(SteamResult steamResult) {
        logger.info("Favorites list accounts updated with result " + steamResult.toString());

    }
}
package com.tevtongermany.dampf;

import com.codedisaster.steamworks.*;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = Dampf.MODID)
public class Handler {
    private static  Logger logger = Dampf.getLogger();

    private static boolean wasOpenToLAN = false;

    private static boolean IsLobbyOpen = false;


    public Handler() {
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (SteamAPI.isSteamRunning()) {
            SteamAPI.runCallbacks();
        }
    }


    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load event) {

        logger.info("World loaded opening lobby");
        if (IsLobbyOpen) {
            logger.info("Lobby already open");
            return;
        }
        SteamMatchmaking Lobby = new SteamMatchmaking(new dampfmatchmakingcallback());
        Lobby.createLobby(SteamMatchmaking.LobbyType.Public, 16);

        // boolean server = SteamGameServerAPI.init((127 << 24) + 1, (short) 27016, (short) 27017, SteamGameServerAPI.ServerMode.NoAuthentication, "1");


        //if (server) {
        //logger.info("SteamGameServerAPI init success");
        //IsLobbyOpen = true;
        //} else {
        //logger.error("SteamGameServerAPI init failed");
        //}

    }

    @SubscribeEvent
    public static void onWorldUnload(WorldEvent.Unload event) {
        logger.info("World unloaded closing lobby");
        SteamGameServerAPI.shutdown();
    }





}

class dampfmatchmakingcallback implements SteamMatchmakingCallback {

    @Override
    public void onFavoritesListChanged(int i, int i1, int i2, int i3, int i4, boolean b, int i5) {

    }

    @Override
    public void onLobbyInvite(SteamID steamID, SteamID steamID1, long l) {

    }

    @Override
    public void onLobbyEnter(SteamID steamID, int i, boolean b, SteamMatchmaking.ChatRoomEnterResponse chatRoomEnterResponse) {

    }

    @Override
    public void onLobbyDataUpdate(SteamID steamID, SteamID steamID1, boolean b) {

    }

    @Override
    public void onLobbyChatUpdate(SteamID steamID, SteamID steamID1, SteamID steamID2, SteamMatchmaking.ChatMemberStateChange chatMemberStateChange) {

    }

    @Override
    public void onLobbyChatMessage(SteamID steamID, SteamID steamID1, SteamMatchmaking.ChatEntryType chatEntryType, int i) {

    }

    @Override
    public void onLobbyGameCreated(SteamID steamID, SteamID steamID1, int i, short i1) {

    }

    @Override
    public void onLobbyMatchList(int i) {

    }

    @Override
    public void onLobbyKicked(SteamID steamID, SteamID steamID1, boolean b) {

    }

    @Override
    public void onLobbyCreated(SteamResult steamResult, SteamID steamID) {

    }

    @Override
    public void onFavoritesListAccountsUpdated(SteamResult steamResult) {

    }
}

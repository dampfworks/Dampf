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

    private static boolean IsLobbyOpen = false;

    private static final SteamMatchmaking Matchmaking = new SteamMatchmaking(new DampfMatchmaking());


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

        Matchmaking.createLobby(SteamMatchmaking.LobbyType.Public, 16);
        logger.info("Lobby created");


        IsLobbyOpen = true;


    }

    @SubscribeEvent
    public static void onWorldUnload(WorldEvent.Unload event) {
        logger.info("World unloaded closing lobby");
        SteamGameServerAPI.shutdown();
    }


}



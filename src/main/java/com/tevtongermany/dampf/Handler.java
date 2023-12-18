package com.tevtongermany.dampf;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamGameServerAPI;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = Dampf.MODID)
public class Handler {
    private static  Logger logger = Dampf.getLogger();


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
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        keybinds.customKeybind.isPressed(); {
            logger.info("Keybind pressed");
            try {
                SteamGameServerAPI.loadLibraries();
                if (!SteamGameServerAPI.init( 50 , (short) 27016, (short) 27017,
                        SteamGameServerAPI.ServerMode.NoAuthentication, "0.0.1")) {
                    logger.error("SteamGameServerAPI init failed");
                }
            } catch (SteamException e) {
                logger.error("SteamGameServerAPI init failed", e);
            }
        }
    }

    @SubscribeEvent
    public static void onWorldUnload(WorldEvent.Unload event) {
        if (event.getWorld().isRemote) {
            // Client-side, do nothing
            return;
        }

        boolean isLANWorld = event.getWorld().getMinecraftServer().isSinglePlayer() &&
                event.getWorld().getMinecraftServer().isDedicatedServer();

        if (isLANWorld) {
            logger.info("Lan world unloaded, stopping lobby");
            SteamGameServerAPI.shutdown();
        }
    }


}

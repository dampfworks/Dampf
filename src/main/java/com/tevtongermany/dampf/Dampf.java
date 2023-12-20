package com.tevtongermany.dampf;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamGameServerAPI;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Mod(modid = Dampf.MODID, name = Dampf.NAME, version = Dampf.VERSION)
public class Dampf
{
    public static final String MODID = "dampf";
    public static final String NAME = "Dampf";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    public void createSteamAppId() {
        File steamappid = new File("steam_appid.txt");
        if (!steamappid.exists()) {
            try {
                steamappid.createNewFile();
                FileWriter writer = new FileWriter(steamappid);
                writer.write("480");
                writer.close();
            } catch (IOException e) {
                logger.error("Failed to create steam_appid.txt", e);
            }
        }
    }
    public void loadSteamAPI() {
        try {
            SteamAPI.loadLibraries();
            SteamGameServerAPI.loadLibraries();
            if (!SteamAPI.init()) {
                logger.error("SteamAPI init failed");
            } else {
                logger.info("SteamAPI init success");
            }
        } catch (SteamException e) {
            logger.error("SteamAPI init failed", e);

        }
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        logger = event.getModLog();
        new Handler();
        createSteamAppId();
        loadSteamAPI();
    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Pre initializing");
        logger.info("Initializing");
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());


    }

    @EventHandler 
    public void shutdown(FMLInitializationEvent event)
    {
        logger.info("Shutting down steam");
        SteamAPI.shutdown();
        logger.info("Shutting down");
    }


}


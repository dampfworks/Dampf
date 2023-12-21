package com.tevtongermany.dampf;

import com.codedisaster.steamworks.*;
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
    // Minecraft Mod
    public static final String MODID = "dampf";
    public static final String NAME = "Dampf";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    // Steam API

    private SteamUserStats stats;

    private SteamFriends friends;

    public SteamUserStats getStats() {
        return stats;
    }

    public SteamFriends getFriends() {
        return friends;
    }

    public void loadFriendsInterface(){
        SteamFriendsCallback callback = new DampfFriends();

        friends = new SteamFriends(callback);
    }

    private void createSteamAppId() {
        File steamappid = new File("steam_appid.txt");
        if (!steamappid.exists()) {
            try {
                steamappid.createNewFile();
                FileWriter writer = new FileWriter(steamappid);
                writer.write("480");
                writer.close();
            } catch (IOException e) {
                logger.info("Failed to create steam_appid.txt", e);
            }
        }
    }

    private void loadSteamInterface(){
        SteamUserStatsCallback callback = new DampfInterface();

        stats = new SteamUserStats(callback);

    }

    private void loadSteamAPI() {
        try {
            SteamAPI.loadLibraries();
            SteamGameServerAPI.loadLibraries();
            if (!SteamAPI.init()) {
                logger.info("SteamAPI init failed");
            } else {
                logger.info("SteamAPI init success");
            }

        } catch (SteamException e) {
            logger.info("SteamAPI init failed", e);

        }
    }

    // Minecraft Handlers
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        logger = event.getModLog();
        new Handler();
        createSteamAppId();
        loadSteamAPI();
        loadSteamInterface();
        loadFriendsInterface();
    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Initialized");


    }
    @EventHandler 
    public void shutdown(FMLInitializationEvent event)
    {
        logger.info("Shutting down steam");
        SteamAPI.shutdown();
        stats.dispose();
        friends.dispose();

        logger.info("Shutting down");
    }


}


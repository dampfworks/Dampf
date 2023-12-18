package com.tevtongermany.dampf;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class keybinds {
    public static KeyBinding customKeybind;



    public static void init() {
        customKeybind = new KeyBinding("key.customkeybind", 19, "key.categories.dampf");
        ClientRegistry.registerKeyBinding(customKeybind);
    }



}

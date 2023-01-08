package com.msgprograms.skyhytab;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class SkyHyTabMain implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("msg-skyhytab");
    public static Cnf cnf;

    public static KeyBinding playerTgl;
    public static KeyBinding genericTgl;
    public static KeyBinding mapTgl;
    public static KeyBinding defaultTgl;

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        AutoConfig.register(Cnf.class, GsonConfigSerializer::new);
        cnf = AutoConfig.getConfigHolder(Cnf.class).getConfig();

        playerTgl = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.skyhytab.playerTgl",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_LEFT_SHIFT,
                        "key.category.first.skyhytab"));
        genericTgl = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.skyhytab.genericTgl",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_LEFT_CONTROL,
                        "key.category.first.skyhytab"));
        mapTgl = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.skyhytab.mapTgl",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_LEFT_ALT,
                        "key.category.first.skyhytab"));
        defaultTgl = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.skyhytab.defaultTgl",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_B,
                        "key.category.first.skyhytab"));

    }
}

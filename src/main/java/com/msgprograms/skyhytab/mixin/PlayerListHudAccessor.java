package com.msgprograms.skyhytab.mixin;

import java.util.Comparator;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;

@Mixin(PlayerListHud.class)
public interface PlayerListHudAccessor {
    
    @Accessor("client")
    public MinecraftClient getClient();

    @Accessor("ENTRY_ORDERING")
    public static Comparator<PlayerListEntry> getOrdering() {
        throw new AssertionError(); 
    }
}

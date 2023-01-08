package com.msgprograms.skyhytab.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.msgprograms.skyhytab.SkyHyTabMain;
import com.msgprograms.skyhytab.screens.Screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {

    @Shadow
    private Text footer;

    boolean ok = true;

    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V", cancellable = true)
    public void init(MatrixStack ms, int i, Scoreboard sb, ScoreboardObjective sbo, CallbackInfo info) {

        if (!SkyHyTabMain.cnf.enabled || SkyHyTabMain.defaultTgl.isPressed()) {
            return;
        }

        ClientPlayNetworkHandler nwH = ((PlayerListHudAccessor)(Object)this).getClient().getNetworkHandler();
        if (nwH == null) {
            return;
        }
        List<PlayerListEntry> list = nwH.getListedPlayerListEntries().stream().sorted(PlayerListHudAccessor.getOrdering()).toList();

        if (footer == null || list.size() < 80) {
            return;
        }

        // if (ok) {

        //     for (int j = 0; j < list.size(); j++) {
        //         PlayerListEntry ple = list.get(j);
        //         System.out.printf("dname %s, dname str %s, len %d, profile %s\n", ple.getDisplayName(),
        //         (ple.getDisplayName() == null) ? "---": ple.getDisplayName().getString(),
        //         (ple.getDisplayName() != null && ple.getDisplayName().getString() == null) ? -1 : ple.getDisplayName().getString().length(),
        //         (ple.getProfile() == null) ? "null" : "not");
        //     }
        //     System.out.println();
        //     ok = false;
        // }

        int w = MinecraftClient.getInstance().getWindow().getScaledWidth();
        int h = MinecraftClient.getInstance().getWindow().getScaledHeight();

        try {

            Screen screen = Screen.getCorrect(w, h, list, footer);
            if (screen != null) {
                screen.render(ms);
                info.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
            SkyHyTabMain.cnf.enabled = false;
            MinecraftClient.getInstance().player.sendMessage(Text.of("SkyHyTab has crashed, see log! :("));
        }

    }

}

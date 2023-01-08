package com.msgprograms.skyhytab.widget.component;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PlayerComponent extends Component {

    private static final int SKIN_ICO_DIM = 8;

    private String name;
    private Identifier tex;

    public PlayerComponent(PlayerListEntry ple) {

        name = ple.getProfile().getName();
        tex = ple.getSkinTexture();

        this.width = txtRend.getWidth(name) + PAD_S + SKIN_ICO_DIM;
        this.height = txtRend.fontHeight;
    }

    @Override
    public void render(MatrixStack ms, int x, int y) {
        RenderSystem.setShaderTexture(0, tex);
        PlayerSkinDrawer.draw(ms, x, y, SKIN_ICO_DIM);
        txtRend.draw(ms, name, x + SKIN_ICO_DIM + PAD_S, y, 0xffffffff);
    }

}

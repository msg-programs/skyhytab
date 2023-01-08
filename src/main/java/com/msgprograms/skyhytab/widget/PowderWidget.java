package com.msgprograms.skyhytab.widget;

import java.util.List;

import com.msgprograms.skyhytab.util.Ico;
import com.msgprograms.skyhytab.util.StrMan;
import com.msgprograms.skyhytab.widget.component.IcoTextComponent;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

// this widget shows how much mithril and gemstone powder you have

public class PowderWidget extends Widget {

    private static final MutableText TITLE = Text.literal("Powders").formatted(Formatting.DARK_AQUA,
            Formatting.BOLD);

    public PowderWidget(List<PlayerListEntry> list) {
        super(TITLE, Formatting.DARK_AQUA.getColorValue());

        Text amtMith = StrMan.stdEntry(list, 46, "Mithril:", Formatting.AQUA);
        IcoTextComponent mith = new IcoTextComponent(Ico.MITHRIL, amtMith);
        this.addComponent(mith);

        Text amtGem = StrMan.stdEntry(list, 47, "Gemstone:", Formatting.DARK_PURPLE);
        IcoTextComponent gem = new IcoTextComponent(Ico.EMERALD, amtGem);
        this.addComponent(gem);
        this.pack();

    }

}

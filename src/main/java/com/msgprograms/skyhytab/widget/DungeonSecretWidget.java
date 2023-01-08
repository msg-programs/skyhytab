package com.msgprograms.skyhytab.widget;

import java.util.List;

import com.msgprograms.skyhytab.util.Ico;
import com.msgprograms.skyhytab.util.StrMan;
import com.msgprograms.skyhytab.widget.component.IcoTextComponent;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

// this widget shows info about secrets of the dungeon

public class DungeonSecretWidget extends Widget {

    private static final MutableText TITLE = Text.literal("Discoveries").formatted(Formatting.DARK_PURPLE,
            Formatting.BOLD);

    public DungeonSecretWidget(List<PlayerListEntry> list) {
        super(TITLE, Formatting.DARK_PURPLE.getColorValue());

        Text secrets = StrMan.stdEntry(list, 31, "Secrets:", Formatting.YELLOW);
        IcoTextComponent sec = new IcoTextComponent(Ico.CHEST, secrets);
        this.addComponent(sec);

        Text crypts = StrMan.stdEntry(list, 32, "Crypts:", Formatting.YELLOW);
        IcoTextComponent cry = new IcoTextComponent(Ico.SKULL, crypts);
        this.addComponent(cry);

        this.pack();
    }

}

package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.PlayerListWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class PlayerListScreen extends Screen {

    public PlayerListScreen(int w, int h, List<PlayerListEntry> ple, Text footer) {
        super(w, h);
        PlayerListWidget plw = new PlayerListWidget(ple);
        this.center(plw);
        this.addWidget(plw);
    }

}

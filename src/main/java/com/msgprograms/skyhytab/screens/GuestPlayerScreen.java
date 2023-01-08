package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.IslandGuestsWidget;
import com.msgprograms.skyhytab.widget.IslandOwnersWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class GuestPlayerScreen extends Screen{

    public GuestPlayerScreen(int w, int h, List<PlayerListEntry> list, Text footer) {
        super(w, h);
        IslandGuestsWidget igw = new IslandGuestsWidget(list);
        IslandOwnersWidget iow = new IslandOwnersWidget(list);
        this.centerH(iow);
        this.centerH(igw);
        this.stackWidgetsW(igw, iow);
        this.addWidgets(iow, igw);
    }

}

package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.EssenceWidget;
import com.msgprograms.skyhytab.widget.ServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class DungeonHubScreen extends Screen{

    public DungeonHubScreen(int w, int h, List<PlayerListEntry> list, Text footer) {
        super(w, h);
        ServerWidget sw = new ServerWidget(list);
        EssenceWidget ew = new EssenceWidget(list);
        centerW(sw);
        centerW(ew);
        stackWidgetsH(sw, ew);
        this.addWidget(ew);
        this.addWidget(sw);
    }

}

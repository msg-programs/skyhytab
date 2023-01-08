package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.GuestServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class GuestServerScreen extends Screen{

    public GuestServerScreen(int w, int h, List<PlayerListEntry> list, Text footer) {
        super(w, h);
        GuestServerWidget gsw = new GuestServerWidget(list);
        this.center(gsw);
        this.addWidget(gsw);
    }

}

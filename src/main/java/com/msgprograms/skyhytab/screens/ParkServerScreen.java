package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.ParkServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class ParkServerScreen extends Screen{

    public ParkServerScreen(int w, int h, List<PlayerListEntry> ple, Text footer) {
        super(w, h);
        ParkServerWidget sw = new ParkServerWidget(ple);
        this.center(sw);
        this.addWidget(sw);
    }

}

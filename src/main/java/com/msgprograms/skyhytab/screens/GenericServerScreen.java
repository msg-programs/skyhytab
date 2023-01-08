package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.ServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class GenericServerScreen extends Screen {

    public GenericServerScreen(int w, int h, List<PlayerListEntry> ple, Text footer) {
        super(w, h);
        ServerWidget sw = new ServerWidget(ple);
        this.center(sw);
        this.addWidget(sw);
    }

}

package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.FireSaleWidget;
import com.msgprograms.skyhytab.widget.ServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class HubServerScreen extends Screen {

    public HubServerScreen(int w, int h, List<PlayerListEntry> ple, Text footer) {
        super(w, h);
        ServerWidget sw = new ServerWidget(ple);
        FireSaleWidget fsw = new FireSaleWidget(ple);
        this.centerW(sw);
        this.centerW(fsw);
        this.stackWidgetsH(sw, fsw);
        this.addWidgets(sw, fsw);
    }

}

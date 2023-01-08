package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.ServerWidget;
import com.msgprograms.skyhytab.widget.TrapperWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class FarmingServerScreen extends Screen{

    public FarmingServerScreen(int w, int h, List<PlayerListEntry> list, Text footer) {
        super(w, h);
        ServerWidget sw = new ServerWidget(list);
        TrapperWidget tw = new TrapperWidget(list);
        centerW(sw);
        centerW(tw);
        stackWidgetsH(sw, tw);
        this.addWidgets(tw, sw);
    }

}

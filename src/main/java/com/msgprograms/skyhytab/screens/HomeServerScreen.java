package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.IslandServerWidget;
import com.msgprograms.skyhytab.widget.MinionWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class HomeServerScreen extends Screen {

    public HomeServerScreen(int w, int h, List<PlayerListEntry> list, Text footer) {
        super(w, h);

        IslandServerWidget isw = new IslandServerWidget(list);
        MinionWidget mw = new MinionWidget(list);
        this.centerH(isw);
        this.centerH(mw);
        this.stackWidgetsW(isw, mw);
        this.addWidgets(isw, mw);
    }

}

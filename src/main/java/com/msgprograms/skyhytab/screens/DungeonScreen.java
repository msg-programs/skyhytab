package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.DungeonDeathWidget;
import com.msgprograms.skyhytab.widget.DungeonDownedWidget;
import com.msgprograms.skyhytab.widget.DungeonPuzzleWidget;
import com.msgprograms.skyhytab.widget.DungeonSecretWidget;
import com.msgprograms.skyhytab.widget.DungeonServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class DungeonScreen extends Screen {

    public DungeonScreen(int w, int h, List<PlayerListEntry> ple, Text footer) {
        super(w, h);
        DungeonDownedWidget ddow = new DungeonDownedWidget(ple);
        DungeonDeathWidget ddew = new DungeonDeathWidget(ple);
        DungeonSecretWidget dscw = new DungeonSecretWidget(ple);
        DungeonServerWidget dsrw = new DungeonServerWidget(ple);
        DungeonPuzzleWidget dpuw = new DungeonPuzzleWidget(ple);

        offCenterL(ddow);
        offCenterL(ddew);
        offCenterL(dscw);
        offCenterR(dsrw);
        offCenterR(dpuw);

        stackWidgetsH(ddow, ddew, dscw);
        stackWidgetsH(dsrw, dpuw);

        addWidgets(ddow, ddew, dscw, dsrw, dpuw);

    }

}

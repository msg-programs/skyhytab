package com.msgprograms.skyhytab.screens;

import java.util.List;

import com.msgprograms.skyhytab.widget.CommsWidget;
import com.msgprograms.skyhytab.widget.ForgeWidget;
import com.msgprograms.skyhytab.widget.PowderWidget;
import com.msgprograms.skyhytab.widget.ServerWidget;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

public class MineServerScreen extends Screen{

    public MineServerScreen(int w, int h, List<PlayerListEntry> list, Text footer) {
        super(w, h);
        ServerWidget sw = new ServerWidget(list);
        PowderWidget pw = new PowderWidget(list);
        CommsWidget cw = new CommsWidget(list);
        ForgeWidget fw = new ForgeWidget(list);
        stackWidgetsH(sw, pw, cw);
        centerH(fw);
        offCenterL(sw);
        offCenterL(pw);
        offCenterL(cw);
        offCenterR(fw);
        this.addWidgets(fw, cw, pw, sw);
    }

}

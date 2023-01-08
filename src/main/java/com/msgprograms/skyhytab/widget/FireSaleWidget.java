package com.msgprograms.skyhytab.widget;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.msgprograms.skyhytab.util.Ico;
import com.msgprograms.skyhytab.util.StrMan;
import com.msgprograms.skyhytab.widget.component.PlainTextComponent;
import com.msgprograms.skyhytab.widget.component.ProgressComponent;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

// TODO: untested with active fire sales
// this widget shows info about fire sales when in the hub
// or not, if there isn't one going on

public class FireSaleWidget extends Widget {

    private static final MutableText TITLE = Text.literal("Fire Sale").formatted(Formatting.DARK_AQUA,
            Formatting.BOLD);

    // matches a fire sale item
    // group 1: item name
    // group 2: # items bought
    // group 1: # items available in total (1 digit + "k")
    private static final Pattern FIRE_PATTERN = Pattern.compile(" (.*): (\\d*)/(\\d)k");

    public FireSaleWidget(List<PlayerListEntry> list) {
        super(TITLE, Formatting.DARK_AQUA.getColorValue());

        boolean found = false;

        for (int i = 46;; i++) {
            Matcher m = StrMan.regexAt(list, i, FIRE_PATTERN);
            if (m == null ||!m.matches()) {
                break;
            }
            found = true;
            Text a = Text.literal(m.group(1));
            Text b = Text.literal(m.group(2) + "/" + m.group(3) + "000");
            float pcnt = 1 - (Float.parseFloat(m.group(2)) / (Float.parseFloat(m.group(3)) * 1000));
            ProgressComponent pc = new ProgressComponent(Ico.GOLD, a, b, pcnt, Formatting.LIGHT_PURPLE.getColorValue());
            this.addComponent(pc);
        }
        if (!found) {
            this.addComponent(new PlainTextComponent(Text.literal("No Fire Sale!").formatted(Formatting.GRAY)));
        }
        this.pack();

    }

}

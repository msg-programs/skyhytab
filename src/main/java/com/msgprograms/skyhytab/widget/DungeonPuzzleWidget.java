package com.msgprograms.skyhytab.widget;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.msgprograms.skyhytab.util.Ico;
import com.msgprograms.skyhytab.util.StrMan;
import com.msgprograms.skyhytab.widget.component.IcoTextComponent;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

// this widget shows info about all puzzeles in the dungeon (name and status)
// TODO: if puzzle was failed, show player name

public class DungeonPuzzleWidget extends Widget {

    private static final MutableText TITLE = Text.literal("Puzzles").formatted(Formatting.DARK_PURPLE,
            Formatting.BOLD);

    // match a puzzle entry
    // group 1: name
    // group 2: status
    // yes, that " ?" is needed. 
    // the teleport maze has a trailing whitespace that messes with the regex
    private static final Pattern PUZZLE_PATTERN = Pattern.compile(" (.*): \\[(.*)\\] ?");

    public DungeonPuzzleWidget(List<PlayerListEntry> list) {
        super(TITLE, Formatting.DARK_PURPLE.getColorValue());

        int pos = 48;

        while (pos < 60) {
            Matcher m = StrMan.regexAt(list, pos, PUZZLE_PATTERN);
            if (m == null) {
                break;
            }
            Text t = Text.literal(m.group(1) + ": ").append(Text.literal("[").formatted(Formatting.GRAY))
                    .append(m.group(2)).append(Text.literal("]").formatted(Formatting.GRAY));
            IcoTextComponent itc = new IcoTextComponent(Ico.SIGN, t);
            this.addComponent(itc);
            pos++;
        }
        this.pack();

    }

}

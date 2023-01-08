package com.msgprograms.skyhytab.widget;

import com.msgprograms.skyhytab.util.Ico;
import com.msgprograms.skyhytab.widget.component.IcoFatTextComponent;
import com.msgprograms.skyhytab.widget.component.IcoTextComponent;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

// this widgte shows, how many active effects you have
// it also shows one of those in detail

public class EffectWidget extends Widget {

    private static final MutableText TITLE = Text.literal("Effect Info").formatted(Formatting.DARK_PURPLE,
            Formatting.BOLD);

    public EffectWidget(String footertext) {
        super(TITLE, Formatting.DARK_PURPLE.getColorValue());

        String interesting = footertext.split("Active Effects")[1];
        String[] lines = interesting.split("\n");

        if (lines[1].startsWith("No")) {
            Text txt = Text.literal("No effects active").formatted(Formatting.GRAY);
            this.addComponent(new IcoTextComponent(Ico.POTION, txt));
        } else {
            String number = lines[1].substring("You have ".length());
            number = number.substring(0, number.indexOf(' '));
            Text active = Text.literal("Active Effects: ").append(Text.literal(number).formatted(Formatting.YELLOW));

            IcoFatTextComponent iftc = new IcoFatTextComponent(Ico.POTION, active,
                    Text.literal(lines[3]).formatted(Formatting.AQUA));
            this.addComponent(iftc);
        }
        this.pack();
    }

}

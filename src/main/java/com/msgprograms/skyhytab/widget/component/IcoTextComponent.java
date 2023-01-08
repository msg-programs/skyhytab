package com.msgprograms.skyhytab.widget.component;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class IcoTextComponent extends Component {
    
    private ItemStack ico;
    private Text text;

    public IcoTextComponent(ItemStack ico, Text text) {
        this.ico = ico;
        this.text = text;

        this.width = ICO_DIM + PAD_L + txtRend.getWidth(text) + PAD_S;
        this.height = ICO_DIM;
    }

    @Override
    public void render(MatrixStack ms, int x, int y) {
        itmRend.renderGuiItemIcon(ico, x, y);
        txtRend.draw(ms, text, x + ICO_DIM + PAD_L, y + 5, 0xffffffff);
    }

}

package com.msgprograms.skyhytab.widget.component;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class IcoFatTextComponent extends Component {

    private static final int ICO_OFFS = 1;

    private ItemStack ico;
    private Text l1, l2;

    public IcoFatTextComponent(ItemStack ico, Text l1, Text l2) {
        this.ico = ico;
        this.l1 = l1;
        this.l2 = l2;

        this.width = ICO_DIM + PAD_L + Math.max(txtRend.getWidth(l1), txtRend.getWidth(l2)) + PAD_S;
        this.height = txtRend.fontHeight * 2 + PAD_S;
    }

    @Override
    public void render(MatrixStack ms, int x, int y) {
        itmRend.renderGuiItemIcon(ico, x, y + ICO_OFFS);
        txtRend.draw(ms, l1, x + ICO_DIM + PAD_L, y, 0xffffffff);
        txtRend.draw(ms, l2, x + ICO_DIM + PAD_L, y + txtRend.fontHeight + PAD_S, 0xffffffff);
    }

}

package Fantasy_World.mod.gui.aoi_chest.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Fantasy_World.mod.gui.aoi_chest.container.aoi_container;
import Fantasy_World.mod.gui.aoi_chest.tileentity.aoi_tileentity;

public class aoi_gui extends GuiContainer {

	private aoi_tileentity tileEntity;
	// GUIのテクスチャの場所を指定する。今回はバニラのラージチェストと同じものを使う。
	private static final ResourceLocation GUITEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");

	public aoi_gui(EntityPlayer player, aoi_tileentity tileEnttiy) {
		super(new aoi_container(player, tileEnttiy));
		this.tileEntity = tileEnttiy;
		ySize = 222;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()), 8, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float tick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(GUITEXTURE);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

}

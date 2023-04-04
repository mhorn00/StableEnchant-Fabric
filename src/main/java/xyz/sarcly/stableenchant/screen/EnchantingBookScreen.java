package xyz.sarcly.stableenchant.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.BookScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import xyz.sarcly.stableenchant.StableEnchant;

@Environment(value=EnvType.CLIENT)
public class EnchantingBookScreen extends Screen {
	private static final Identifier ENCHANTING_BOOK_TEXTURE = new Identifier(StableEnchant.MODID, "textures/gui/enchanting_book.png");
	private final PlayerEntity player;
	private final ItemStack bookStack;
	
	public EnchantingBookScreen(PlayerEntity ply, ItemStack book) {
		super(NarratorManager.EMPTY);
		this.player = ply;
		this.bookStack = book;
	}

	@Override
	protected void init() {
		//TODO: add button widgets and stuff
	}
	
	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, ENCHANTING_BOOK_TEXTURE);
        EnchantingBookScreen.drawTexture(matrices, (this.width-283)/2, 10, this.getZOffset(), 0.0f, 0.0f, 283, 180, 512, 256);
        super.render(matrices, mouseX, mouseY, delta);
	}
	
}

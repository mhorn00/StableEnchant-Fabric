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
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.sarcly.stableenchant.StableEnchant;

@Environment(value=EnvType.CLIENT)
public class EnchantingBookScreen extends Screen {
	private static final Identifier ENCHANTING_BOOK_TEXTURE = new Identifier(StableEnchant.MODID, "textures/gui/enchanting_book.png");
	private static final Identifier FONT_ID = new Identifier("minecraft", "alt");
    private static final Style STYLE = Style.EMPTY.withFont(FONT_ID);
	private String bookTitle = "Enchanting Book";
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
        int xPos = (this.width-146)/2;
        int yPos = (this.height-240)/2;
        this.drawTexture(matrices, xPos, yPos, 0, 0, 146, 180);
        this.textRenderer.drawTrimmed(generateEnchantingText("this is test text"), xPos+36, yPos+30,this.textRenderer.getWidth("this is test text") ,0);
        this.textRenderer.draw(matrices, bookTitle, (float)xPos+36, (float)yPos+40, 0);
        super.render(matrices, mouseX, mouseY, delta);
	}
	
	private StringVisitable generateEnchantingText(String text) {
		return this.textRenderer.getTextHandler().trimToWidth(Text.literal(text).fillStyle(STYLE), this.textRenderer.getWidth(text), Style.EMPTY);
	}
	
}

package xyz.sarcly.stableenchant.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.sarcly.stableenchant.StableEnchant;

@Environment(value=EnvType.CLIENT)
public class EnchantingBookScreen extends Screen {
	private static final Identifier ENCHANTING_BOOK_TEXTURE = new Identifier(StableEnchant.MODID, "textures/gui/enchanting_book.png");
	private static final Identifier FONT_ID = new Identifier("minecraft", "alt");
    private static final Style STYLE = Style.EMPTY.withFont(FONT_ID);
	private final PlayerEntity player;
	private final ItemStack bookStack;
	private final int LINE_HEIGHT = 9;
    private final int MAX_TEXT_WIDTH = 114;
	private int xTextPos = 0;
	private int yTextPos = 0;
	private String bookTitle = "Enchanting Book";
	private boolean isNew = true;
	
	public EnchantingBookScreen(PlayerEntity ply, ItemStack book) {
		super(NarratorManager.EMPTY);
		this.player = ply;
		this.bookStack = book;
		if (this.bookStack.getNbt() != null) {
			this.isNew = false;
		}
	}

	@Override
	protected void init() {
		//TODO: add button widgets and stuff
	}
	
	@Override
	public void removed() {
		if (this.isNew) {
			NbtCompound nbt = new NbtCompound();
			nbt.putUuid("Owner", player.getUuid());
			nbt.put("DiscoveredEnchantments", new NbtCompound());
			this.bookStack.setNbt(nbt);
		}
	}
	
	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, ENCHANTING_BOOK_TEXTURE);
        int xPos = (this.width-146)/2;
        int yPos = (this.height-240)/2;
        xTextPos = xPos+15;
        yTextPos = yPos+16;
        this.drawTexture(matrices, xPos, yPos, 0, 0, 146, 180);
        this.drawText(bookTitle, 0, 0);
        this.drawEnchantmentText("among us sus", 1, 0);
        this.drawEnchantmentText("amogus", 3, 0);
        super.render(matrices, mouseX, mouseY, delta);
	}
	
	private void drawEnchantmentText(String text, int line, int color) {
		this.textRenderer.drawTrimmed(this.textRenderer.getTextHandler().trimToWidth(Text.literal(text).fillStyle(STYLE), this.textRenderer.getWidth(text), Style.EMPTY), xTextPos, yTextPos+(LINE_HEIGHT*line), MAX_TEXT_WIDTH, color);
	}
	
	private void drawText(String text, int line, int color) {
		this.textRenderer.drawTrimmed(Text.literal(text), xTextPos, yTextPos+(LINE_HEIGHT*line), MAX_TEXT_WIDTH, color);
	}
	
}

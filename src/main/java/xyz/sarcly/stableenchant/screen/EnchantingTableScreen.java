package xyz.sarcly.stableenchant.screen;

import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.gui.widget.ScrollableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.sarcly.stableenchant.StableEnchant;
import xyz.sarcly.stableenchant.screen.handler.EnchantingTableScreenHandler;

@Environment(value=EnvType.CLIENT)
public class EnchantingTableScreen extends HandledScreen<EnchantingTableScreenHandler> {
	private static final Identifier TEXTURE = new Identifier(StableEnchant.MODID, "textures/gui/container/enchanting_table.png");
	private static final Text UiTitle = Text.translatable("ui.stableenchant.container.enchanting_table");
	private final List<IEnchantingTableWidget> widgets = Lists.newArrayList();
	
	//Following int[] are of the form {x pos, y pos, texture x, texture y, texture width, texture height, alt texture x, alt texture y}
	private static final int[] STABILITY_BAR= {6  ,14,  181, 0,  5,66,  176, 0};
	private static final int[] STORE_XP_BAR = {165,14,  191, 0,  5,58,  186, 0};
	private static final int[] ADD_XP_BTN =   {164,73,  176,73,  7, 7};
	private static final int[] MINUS_BTN =    {15 ,16,  176,66,  7, 7};
	private static final int[] PLUS_BTN =     {49 ,16,  176,73,  7, 7};
	//private static final int[] SCROLL_BAR =   {49 ,24,  176,80,  7,17};
	private static final int[] CONFIRM_BTN =  {59 ,64,  0,176,  16,16};
	
	public EnchantingTableScreen(EnchantingTableScreenHandler handler, PlayerInventory inv, Text title) {
		super(handler, inv, UiTitle);
		this.backgroundWidth = 176;
		this.backgroundHeight = 176;
		this.playerInventoryTitleY = this.backgroundHeight - 94;
	}
	
	@Override
    protected void init() {
		super.init();
		this.widgets.clear();
		this.addWidget(new EnchantingTableButton(this.x  + CONFIRM_BTN[0], this.y + CONFIRM_BTN[1], CONFIRM_BTN[2], CONFIRM_BTN[3], CONFIRM_BTN[4], CONFIRM_BTN[5], this::confrimPress, this::confrimTick)); //confirm button
		this.addWidget(new EnchantingTableButton(this.x  + ADD_XP_BTN[0], this.y + ADD_XP_BTN[1], ADD_XP_BTN[2], ADD_XP_BTN[3], ADD_XP_BTN[4], ADD_XP_BTN[5], this::xpAddPress, this::xpAddTick)); //store xp button
		this.addWidget(new EnchantingTableButton(this.x  + MINUS_BTN[0], this.y + MINUS_BTN[1], MINUS_BTN[2], MINUS_BTN[3], MINUS_BTN[4], MINUS_BTN[5], this::levelRemovePress, this::levelRemoveTick)); //minus level button
		this.addWidget(new EnchantingTableButton(this.x  + PLUS_BTN[0], this.y + PLUS_BTN[1], PLUS_BTN[2], PLUS_BTN[3], PLUS_BTN[4], PLUS_BTN[5], this::levelAddPress, this::levelAddTick)); //plus level button
		//this.addWidget(new EnchantingTableScrollable(this.x  + SCROLL_BAR[0], this.y + SCROLL_BAR[1], SCROLL_BAR[4], SCROLL_BAR[5])); 
	}
	
	@Override
	public void handledScreenTick() {
		super.handledScreenTick();
		this.widgets.forEach(w -> w.tick());
	}

	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight); //Draw base texture
        //Draw stability bar
        drawTexture(matrices, x+STABILITY_BAR[0], y+STABILITY_BAR[1], STABILITY_BAR[2], STABILITY_BAR[3], STABILITY_BAR[4], STABILITY_BAR[5]); //Draw filled bar
        drawTexture(matrices, x+STABILITY_BAR[0], y+STABILITY_BAR[1], STABILITY_BAR[6], STABILITY_BAR[7], STABILITY_BAR[4], STABILITY_BAR[5]-15); //Draw base bar over it
        //Draw xp storage Bar
        drawTexture(matrices, x+STORE_XP_BAR[0], y+STORE_XP_BAR[1], STORE_XP_BAR[2], STORE_XP_BAR[3], STORE_XP_BAR[4], STORE_XP_BAR[5]); //Draw filled bar
        drawTexture(matrices, x+STORE_XP_BAR[0], y+STORE_XP_BAR[1], STORE_XP_BAR[6], STORE_XP_BAR[7], STORE_XP_BAR[4], STORE_XP_BAR[5]-24); //Draw base bar over it
	}

	@Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
		super.drawForeground(matrices, mouseX, mouseY);
	}
	
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
    
    private <T extends ClickableWidget> void addWidget(T widget) {
        this.addDrawableChild(widget);
        this.widgets.add((IEnchantingTableWidget)((Object)widget));
    }
    
    private void confrimPress() {}
    private void confrimTick() {}
    
    private void levelAddPress() {}
    private void levelAddTick() {}
    
    private void levelRemovePress() {}
    private void levelRemoveTick() {}
    
    private void xpAddPress() {}
    private void xpAddTick() {}
    
    

    //=================[Widget Classes]=================
    
    @Environment(value=EnvType.CLIENT)
    static interface IEnchantingTableWidget {
        public void tick();
    }
    
    @Environment(value=EnvType.CLIENT)
    interface IPressableAction {
    	public void onPress();
    }
    
    @Environment(value=EnvType.CLIENT)
    interface IPressableTick {
    	public void onTick();
    }
    
    class EnchantingTableScrollable extends ScrollableWidget implements IEnchantingTableWidget{

		public EnchantingTableScrollable(int x, int y, int width, int height) {
			super(x, y, width, height, ScreenTexts.EMPTY);
			
		}
		
		@Override
		protected void renderOverlay(MatrixStack matrices) {
			super.renderOverlay(matrices);
		}

		@Override
		protected void renderContents(MatrixStack matricies, int mouseX, int mouseY, float delta) {
	        RenderSystem.setShader(GameRenderer::getPositionTexShader);
	        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	        RenderSystem.setShaderTexture(0, TEXTURE);
		}
		
		@Override
		public void tick() {

		}
		
		@Override
		public void appendNarrations(NarrationMessageBuilder builder) {
			this.appendDefaultNarrations(builder);
		}

		@Override
		protected int getContentsHeight() {
			return 54;
		}

		@Override
		protected boolean overflows() {
			return true;
		}

		@Override
		protected double getDeltaYPerScroll() {
			return 1;
		}
    }
    
    @Environment(value=EnvType.CLIENT)
    class EnchantingTableButton extends EnchantingTableWidget {
    	private IPressableAction action;
    	private IPressableTick tick;

		public EnchantingTableButton(int x, int y, int u, int v, int width, int height, IPressableAction pressAction, IPressableTick pressTick) {
			super(x, y, u, v, width, height);
			this.action = pressAction;
			this.tick = pressTick;
		}
		
		@Override
		protected void renderExtra(MatrixStack matrices) {} //do nothing

		@Override
		public void tick() {
			tick.onTick();
		}

		@Override
		public void onPress() {
			action.onPress();
		}	
    }
    
    @Environment(value=EnvType.CLIENT)
    static abstract class EnchantingTableWidget extends PressableWidget implements IEnchantingTableWidget {
		private int textureOffsetX;
		private int textureOffsetY;
		private boolean isDisabled;
    	
    	protected EnchantingTableWidget(int x, int y, int u, int v, int width, int height) {
			super(x, y, width, height, ScreenTexts.EMPTY);
			textureOffsetX = u;
			textureOffsetY = v;
		}
    	
		protected EnchantingTableWidget(int x, int y, int u, int v, int width, int height, Text text) {
			super(x, y, width, height, text);
			textureOffsetX = u;
			textureOffsetY = v;
		}
		
		@Override
		public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, TEXTURE);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            int i = this.isHovered() ? 2 : (this.isDisabled ? 1 : 0);
            this.drawTexture(matrices, this.x, this.y, textureOffsetX+i*this.width, textureOffsetY, this.width, this.height);
            this.renderExtra(matrices);
		}
		
        protected abstract void renderExtra(MatrixStack matricies);

		@Override
		public void appendNarrations(NarrationMessageBuilder builder) {
			this.appendDefaultNarrations(builder);
		}
    }
}

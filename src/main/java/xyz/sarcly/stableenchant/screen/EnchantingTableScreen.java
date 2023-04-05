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
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.NarratorManager;
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
	private final List<IEnchantingTableWidget> widgets = Lists.newArrayList();
	
	public EnchantingTableScreen(EnchantingTableScreenHandler handler, PlayerInventory inv, Text title) {
		super(handler, inv, NarratorManager.EMPTY);
		this.backgroundWidth = 284;
		this.backgroundHeight = 279;
		this.playerInventoryTitleX = this.backgroundWidth - 223;
		this.playerInventoryTitleY = this.backgroundHeight - 94;
		
	}
	
	@Override
    protected void init() {
		super.init();
		this.widgets.clear();
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
        EnchantingTableScreen.drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight, 512, 512); //Draw base texture
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

      

    //=================[Widget Classes]=================  
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
    
    @Environment(value=EnvType.CLIENT)
    static interface IEnchantingTableWidget {
        public void tick();
    }
}

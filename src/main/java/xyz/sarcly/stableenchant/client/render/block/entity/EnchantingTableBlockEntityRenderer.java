package xyz.sarcly.stableenchant.client.render.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import xyz.sarcly.stableenchant.block.entity.EnchantingTableBlockEntity;

@Environment(value=EnvType.CLIENT)
public class EnchantingTableBlockEntityRenderer implements BlockEntityRenderer<EnchantingTableBlockEntity>{

	@SuppressWarnings("deprecation")
	public static final SpriteIdentifier BOOK_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("entity/enchanting_table_book"));
    private final BookModel book;
	
    public EnchantingTableBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.book = new BookModel(ctx.getLayerModelPart(EntityModelLayers.BOOK));
    }
    
    @Override
    public void render(EnchantingTableBlockEntity enchantingTableBlockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
    	if (enchantingTableBlockEntity.hasBook) {
	    	float h;
	        matrixStack.push();
	        matrixStack.translate(0.5, 0.75, 0.5);
	        float g = (float)enchantingTableBlockEntity.ticks + tickDelta;
	        matrixStack.translate(0.0, 0.1f + MathHelper.sin(g * 0.1f) * 0.01f, 0.0);
	        for (h = enchantingTableBlockEntity.bookRotation - enchantingTableBlockEntity.lastBookRotation; h >= (float)Math.PI; h -= (float)Math.PI * 2) {
	        }
	        while (h < (float)(-Math.PI)) {
	            h += (float)Math.PI * 2;
	        }
	        float k = enchantingTableBlockEntity.lastBookRotation + h * tickDelta;
	        matrixStack.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(-k));
	        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(80.0f));
	        float l = MathHelper.lerp(tickDelta, enchantingTableBlockEntity.pageAngle, enchantingTableBlockEntity.nextPageAngle);
	        float m = MathHelper.fractionalPart(l + 0.25f) * 1.6f - 0.3f;
	        float n = MathHelper.fractionalPart(l + 0.75f) * 1.6f - 0.3f;
	        float o = MathHelper.lerp(tickDelta, enchantingTableBlockEntity.pageTurningSpeed, enchantingTableBlockEntity.nextPageTurningSpeed);
	        this.book.setPageAngles(g, MathHelper.clamp(m, 0.0f, 1.0f), MathHelper.clamp(n, 0.0f, 1.0f), o);
	        VertexConsumer vertexConsumer = BOOK_TEXTURE.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntitySolid);
	        this.book.renderBook(matrixStack, vertexConsumer, light, overlay, 1.0f, 1.0f, 1.0f, 1.0f);
	        matrixStack.pop();
        }
    }
}

package xyz.sarcly.stableenchant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.sarcly.stableenchant.block.EnchantingTableBlock;
import xyz.sarcly.stableenchant.block.entity.EnchantingTableBlockEntity;
import xyz.sarcly.stableenchant.client.render.block.entity.EnchantingTableBlockEntityRenderer;
import xyz.sarcly.stableenchant.item.EnchantingBookItem;
import xyz.sarcly.stableenchant.screen.EnchantingTableScreen;
import xyz.sarcly.stableenchant.screen.handler.EnchantingTableScreenHandler;

public class StableEnchant implements ModInitializer, ClientModInitializer {

	public static final String MODID = "stableenchant";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	//Items
	public static final Item ENCHANTING_BOOK = new EnchantingBookItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1));
	
	//Blocks
	public static final Block ENCHANTING_TABLE_BLOCK = new EnchantingTableBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f).requiresTool());
	
	//BlockEntities
	public static final BlockEntityType<EnchantingTableBlockEntity> ENCHANTING_TABLE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(EnchantingTableBlockEntity::new, ENCHANTING_TABLE_BLOCK).build();
	
	//BlockItems
	public static final BlockItem ENCHANTING_TABLE_BLOCK_ITEM = new BlockItem(ENCHANTING_TABLE_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS));
	
	//ScreenHandler
	public static final ScreenHandlerType<EnchantingTableScreenHandler> ENCHANTING_TABLE_SCREEN_HANDLER = new ExtendedScreenHandlerType<EnchantingTableScreenHandler>(EnchantingTableScreenHandler::new);
	
	@Override
	public void onInitialize() {
		//Items
		Registry.register(Registry.ITEM, new Identifier(MODID, "enchanting_book"), ENCHANTING_BOOK);
		
		//Blocks
		Registry.register(Registry.BLOCK, new Identifier(MODID, "enchanting_table"), ENCHANTING_TABLE_BLOCK);
		
		//BlockEntities
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID, "enchanting_table_block_entity"), ENCHANTING_TABLE_BLOCK_ENTITY);
		
		//BlockItems
		Registry.register(Registry.ITEM, new Identifier(MODID, "enchanting_table"), ENCHANTING_TABLE_BLOCK_ITEM);
		
		//ScreenHandler
		Registry.register(Registry.SCREEN_HANDLER, new Identifier(MODID, "enchanting_table_screen_handler"), ENCHANTING_TABLE_SCREEN_HANDLER);
	}


	@Override
	public void onInitializeClient() {
		HandledScreens.register(ENCHANTING_TABLE_SCREEN_HANDLER, EnchantingTableScreen::new);
		BlockEntityRendererRegistry.register(ENCHANTING_TABLE_BLOCK_ENTITY, EnchantingTableBlockEntityRenderer::new);
	}
}

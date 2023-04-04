package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.util.Hand;
import xyz.sarcly.stableenchant.StableEnchant;
import xyz.sarcly.stableenchant.screen.EnchantingBookScreen;

@Mixin(net.minecraft.client.network.ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity{

	@Final @Shadow protected MinecraftClient client;
	
	@Inject(at = @At("HEAD"), method = "useBook(Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/Hand;)V")
    private void onUseBook(ItemStack book, Hand hand, CallbackInfo info) {
        if (book.isOf(StableEnchant.ENCHANTING_BOOK)) {
        	client.setScreen(new EnchantingBookScreen(this, book));
        }
    }

	public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile, PlayerPublicKey publicKey) {
		super(world, profile, publicKey);//required to implement this constructor for the this instance
	}
	
}

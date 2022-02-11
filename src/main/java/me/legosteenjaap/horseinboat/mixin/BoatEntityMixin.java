package me.legosteenjaap.horseinboat.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(BoatEntity.class)
public class BoatEntityMixin {

	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getWidth()F", ordinal = 0))
	private float makeExceptionForHorse(Entity entity) {
		if (entity instanceof HorseBaseEntity) return 0;
		return entity.getWidth();
	}

}


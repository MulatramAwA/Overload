package io.github.MulatramAwA.overload.mixin;

import com.mojang.authlib.GameProfile;
import io.github.MulatramAwA.overload.features.GForceAccessor;
import io.github.MulatramAwA.overload.features.GForceManager;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin extends AbstractClientPlayer implements GForceAccessor {
    @Unique protected GForceManager gForceManager=new GForceManager();

    public LocalPlayerMixin(ClientLevel p_250460_, GameProfile p_249912_) {
        super(p_250460_, p_249912_);
    }

    @Unique
    public GForceManager getGForceManager() {
        return this.gForceManager;
    }
}

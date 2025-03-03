package io.github.MulatramAwA.overload.gui;

import io.github.MulatramAwA.overload.Overload;
import io.github.MulatramAwA.overload.features.GForceAccessor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static io.github.MulatramAwA.overload.Overload.LOGGER;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class InGameGuiEvent {
    @SubscribeEvent
    public static void onOverlayRender(RenderGuiOverlayEvent event) {
        InGameGui inGameGui = new InGameGui();
        double f = 0;
        if (Minecraft.getInstance().player != null) {
            f = ((GForceAccessor) Minecraft.getInstance().player).getGForceManager()
                    .checkGForce(Overload.gForceOnTick.a /10.0D);
        }
        inGameGui.renderGForce(event.getGuiGraphics(),Math.round(Overload.gForceOnTick.a)/10.0D);
        if(f*Math.signum(Overload.gForceOnTick.a)>=0.75D) inGameGui.redout((float) (f-0.75D));
        if(f*Math.signum(Overload.gForceOnTick.a)<=-0.75D) inGameGui.blackout((float) (-f+0.75D));
    }
}

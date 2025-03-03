package io.github.MulatramAwA.overload.features;

import io.github.MulatramAwA.overload.Overload;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class onTickEvent {
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event){
        if(event.phase == TickEvent.Phase.START){
            Overload.gForceOnTick.onTick();
        }
    }
}

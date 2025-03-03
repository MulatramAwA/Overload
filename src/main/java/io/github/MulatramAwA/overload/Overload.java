package io.github.MulatramAwA.overload;

import com.mojang.logging.LogUtils;
import io.github.MulatramAwA.overload.features.GForceOnTick;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Overload.MODID)
public class Overload {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "overload";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static GForceOnTick gForceOnTick = new GForceOnTick();;
    public Overload(){
        MinecraftForge.EVENT_BUS.register(this);
    }
}
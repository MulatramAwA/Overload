package io.github.MulatramAwA.overload.features;

import net.minecraft.client.Minecraft;

import static io.github.MulatramAwA.overload.Overload.LOGGER;

public class GForceOnTick {
    private int t;
    public double xOld,yOld,zOld,vOld,a=0.0F;
    public GForceOnTick(){
        flush();
    }
    public void flush(){
        if (Minecraft.getInstance().player != null) {
            this.xOld = Minecraft.getInstance().player.getX();
            this.yOld = Minecraft.getInstance().player.getY();
            this.zOld = Minecraft.getInstance().player.getZ();
        }
    }
    private double distance(double x,double y,double z,double x1,double y1,double z1){
        return Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2)+Math.pow(z-z1,2));
    }
    public void onTick(){
        this.t++;
        if(this.t<20) return;
        t=0;
        double dis = 0.0D;
        if(Minecraft.getInstance().player!=null){
            double x=Minecraft.getInstance().player.getX(),
                   y=Minecraft.getInstance().player.getY(),
                   z=Minecraft.getInstance().player.getZ();
            //获取位移数据
            dis=distance(x,y,z,this.xOld,this.yOld,this.zOld);
        }
        flush();
        this.a=dis-this.vOld;
        this.vOld=dis;
        LOGGER.info(String.format("dis:%f a:%f vOld:%f",dis,this.a,this.vOld));
    }
}

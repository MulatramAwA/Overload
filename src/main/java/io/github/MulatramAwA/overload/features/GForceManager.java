package io.github.MulatramAwA.overload.features;

public class GForceManager {
    private double maxGForce=2.0D;
    public double checkGForce(double GForce){
        double ans=Math.exp(GForce)/(Math.exp(GForce)+Math.exp(this.maxGForce/10.0D));
        this.maxGForce=this.maxGForce+(GForce-this.maxGForce)*0.002D;
        return ans;
    }
}

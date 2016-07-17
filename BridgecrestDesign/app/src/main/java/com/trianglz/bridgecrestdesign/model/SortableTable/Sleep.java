package com.trianglz.bridgecrestdesign.model.SortableTable;

/**
 * Created by wakeel on 14/07/16.
 */
public class Sleep {
    private final String day;
    private final int quality;
    private final double interrupts;
    private final double totalSlept;

    public Sleep(String name, int quality, double totalSlept, double interrupts){
        this.day = name;
        this.quality = quality;
        this.interrupts = interrupts;
        this.totalSlept = totalSlept;
    }

    public void setDay(String name){
        name = name;
    }

    public String getDay(){
        return day;
    }

    public void setQuality(int quality){
        quality = quality;
    }

    public int getQuality(){
        return quality;
    }

    public void setInterrupts(double interrupts){
        interrupts = interrupts;
    }

    public double getInterrupts(){
        return interrupts;
    }

    public void setTotalSlept(double totalSlept){
        totalSlept = totalSlept;
    }

    public double getTotalSlept(){
        return totalSlept;
    }

}

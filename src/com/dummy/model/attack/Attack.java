package com.dummy.model.attack;

import com.dummy.model.character.Stats;

public class Attack {

    public String name;
    public Stats stats;
    public boolean isAvailable;

    public Attack(Stats stats){
        this.name = "Attack";
        this.stats = stats;
    }

    public int calculate(){
        int result;

        boolean[] hitCritArray = isHitAndCrit();

        boolean isHitVar = hitCritArray[0];
        boolean isCritVar = hitCritArray[1];

        if (isHitVar && isCritVar){
            System.out.println("Crit!");
            result = getCritDamageValue();
        } else if (isHitVar){
            System.out.println();
            result =  getDamageValue();
        } else {
            System.out.println("Miss!");
            result =  0;
        }

        return result;
    }

    public boolean[] isHitAndCrit(){
        boolean[] resultArray = new boolean[2];
        resultArray[0] = stats.isHit();
        resultArray[1] = stats.isCrit();
        return resultArray;
    }

    public int getDamageValue(){
        return stats.getAp();
    }

    public int getCritDamageValue(){
        return (getDamageValue() * stats.getCritDamage()) / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

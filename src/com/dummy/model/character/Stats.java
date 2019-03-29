package com.dummy.model.character;

import java.util.concurrent.ThreadLocalRandom;

public class Stats {

    int ap;
    int sp;
    int crit;
    int hit;
    int critDamage;

    public Stats(int ap, int sp, int crit, int hit, int critDamage) {
        this.ap = ap;
        this.sp = sp;
        this.crit = crit;
        this.hit = hit;
        this.critDamage = critDamage;
    }

    public Stats(){
        this.ap = 100;
        this.sp = 100;
        this.crit = 10;
        this.hit = 90;
        this.critDamage = (int) 1.5;
    }

    public boolean isCrit(){
        return randNum(0, 100) <= crit;
    }

    public boolean isHit(){
        return randNum(0, 100) <= hit;
    }

    public static int randNum(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }
}

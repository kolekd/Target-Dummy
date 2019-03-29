package com.dummy.model;

public class Target {

    public int hp;

    public Target(int hp) {
        this.hp = hp;
    }

    public Target() {
        this.hp = 1000;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

package com.dummy.model.attack;

import com.dummy.model.character.Stats;

public class BasicAttack extends Attack {

    public BasicAttack(Stats stats) {
        super(stats);
        this.name = "Basic Attack";
        this.isAvailable = true;
    }
}

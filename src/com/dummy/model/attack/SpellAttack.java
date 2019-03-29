package com.dummy.model.attack;

import com.dummy.model.character.Stats;

public class SpellAttack extends Attack{

    public SpellAttack(Stats stats) {
        super(stats);
        this.name = "Spell Attack";
    }

    @Override
    public int getDamageValue() {
        return stats.getSp();
    }
}

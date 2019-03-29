package com.dummy.model.attack.heroClass.mage;

import com.dummy.model.attack.SpellAttack;
import com.dummy.model.character.Stats;

public class Fireball extends SpellAttack {

    public Fireball(Stats stats) {
        super(stats);
        this.name = "Fireball";
        this.isAvailable = true;
    }

}

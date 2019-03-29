package com.dummy.model.attack.heroClass.rogue;

import com.dummy.model.attack.Attack;
import com.dummy.model.character.Stats;

public class SinisterStrike extends Attack {

    public SinisterStrike(Stats stats) {
        super(stats);
        this.name = "Sinister Strike";
        this.isAvailable = true;
    }



    @Override
    public int getDamageValue() {
        return super.getDamageValue() + 80;
    }

}

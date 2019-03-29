package com.dummy.model.attack.heroClass.paladin;

import com.dummy.model.attack.Attack;
import com.dummy.model.buff.seal.Seal;
import com.dummy.model.character.Stats;

public class Judgement extends Attack {

    Seal seal;

    public Judgement(Stats stats, Seal seal) {
        super(stats);
        this.name = "Judgement";
        this.seal = seal;
        if(!seal.name.equals("No Seal")){
            isAvailable = true;
        }
    }

    @Override
    public int getDamageValue() {
        int damage = seal.getBuffedDamage();
        return damage;
    }
}

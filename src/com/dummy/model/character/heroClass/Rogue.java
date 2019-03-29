package com.dummy.model.character.heroClass;

import com.dummy.model.attack.heroClass.rogue.SinisterStrike;
import com.dummy.model.character.Hero;
import com.dummy.model.character.Stats;

public class Rogue extends Hero {

    public Rogue() {
        super();
        this.heroClass = "Rogue";
        this.stats = new Stats(120, 0, 20, 90, 200);
        this.attackSet.add(new SinisterStrike(stats));
    }


}

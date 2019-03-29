package com.dummy.model.character.heroClass;

import com.dummy.model.attack.heroClass.mage.Fireball;
import com.dummy.model.character.Hero;
import com.dummy.model.character.Stats;

public class Mage extends Hero {

    public Mage(){
        super();
        this.heroClass = "Mage";
        this.stats = new Stats(20,300, 20, 90, 150);
        this.attackSet.add(new Fireball(stats));
    }
}

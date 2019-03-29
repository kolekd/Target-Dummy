package com.dummy.model.character.heroClass;

import com.dummy.model.attack.heroClass.paladin.Judgement;
import com.dummy.model.buff.seal.Seal;
import com.dummy.model.buff.seal.SealOfRighteousness;
import com.dummy.model.character.Hero;
import com.dummy.model.character.Stats;

public class Paladin extends Hero {

    public Seal seal;
    public Judgement judgement;

    public Paladin(){
        super();
        this.heroClass = "Paladin";
        this.stats = new Stats(100, 50, 15, 90, 150);
        this.seal = new Seal(stats.getAp());
        this.judgement = new Judgement(stats, seal);
        this.attackSet.add(judgement);
        this.buffSet.add(new SealOfRighteousness(stats.getAp()));
    }

    public Seal getSeal() {
        return seal;
    }

    public void setSeal(Seal newSeal) {
        this.attackSet.remove(judgement);
        this.seal = newSeal;
        this.judgement = new Judgement(stats, seal);
        this.attackSet.add(judgement);
    }
}

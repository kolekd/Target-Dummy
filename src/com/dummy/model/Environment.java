package com.dummy.model;

import com.dummy.model.attack.identifier.AbilityIdentifier;
import com.dummy.model.character.Hero;
import com.dummy.model.character.heroClass.Mage;
import com.dummy.model.character.heroClass.Paladin;
import com.dummy.model.character.heroClass.Rogue;

public class Environment {

    public Hero hero;
    public Target target;

    public Environment() {
        this.hero = new Hero();
        this.target = new Target(10000);
    }

    public Environment(Target target) {
        this.target = target;
    }

    public void heroAttackTarget(String attackName){
        if (attackName.length() > 0) {
            hero.attackTarget(AbilityIdentifier.identify(attackName, hero), target);
        }
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setHeroButton(String className) {
        if (className.equals("Rogue")) {
            setHero(new Rogue());
        } else if (className.equals("Mage")) {
            setHero(new Mage());
        } else if (className.equals("Paladin")) {
            setHero(new Paladin());
        } else {
            setHero(new Hero());
        }
    }
}

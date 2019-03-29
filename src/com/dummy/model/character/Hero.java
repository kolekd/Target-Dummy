package com.dummy.model.character;

import com.dummy.model.Target;
import com.dummy.model.attack.Attack;
import com.dummy.model.attack.BasicAttack;
import com.dummy.model.attack.identifier.AbilityIdentifier;
import com.dummy.model.buff.Buff;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    public String heroClass;
    public Stats stats;
    public List<Attack> attackSet;
    public List<Buff> buffSet;

    public Hero(){
        this.heroClass = "Hero";
        this.stats = new Stats(100, 100, 10,90, 150);
        this.attackSet = new ArrayList<>();
        this.buffSet = new ArrayList<>();
        this.attackSet.add(new BasicAttack(stats));
    }

    public Hero(Stats stats, List<Attack> attackSet) {
        this.stats = stats;
        this.attackSet = attackSet;
    }

    public void attackTarget(int result, Target target){
        System.out.println("Before attack: " + target.hp + " HP"); System.out.println();
        System.out.println("Attack: " + result); System.out.println();

        target.hp -= result;

        System.out.println("After attack: " + target.hp + " HP"); System.out.println();
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Attack> getAttackSet() {
        return attackSet;
    }

    public void setAttackSet(List<Attack> attackSet) {
        this.attackSet = attackSet;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public List<Buff> getBuffSet() {
        return buffSet;
    }

    public void setBuffSet(List<Buff> buffSet) {
        this.buffSet = buffSet;
    }
}

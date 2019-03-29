package com.dummy.model.attack.identifier;

import com.dummy.model.attack.BasicAttack;
import com.dummy.model.attack.heroClass.mage.Fireball;
import com.dummy.model.attack.heroClass.paladin.Judgement;
import com.dummy.model.attack.heroClass.rogue.SinisterStrike;
import com.dummy.model.buff.Buff;
import com.dummy.model.buff.seal.Seal;
import com.dummy.model.buff.seal.SealOfRighteousness;
import com.dummy.model.character.Hero;
import com.dummy.model.character.Stats;
import com.dummy.model.character.heroClass.Paladin;

public class AbilityIdentifier {

    public static int identify(String attackName, Hero hero){
        int attackDamage = 0;
        if (attackName.equals("Basic Attack")){
            attackDamage = new BasicAttack(hero.stats).calculate();
        } else if (attackName.equals("Sinister Strike")){
            attackDamage = new SinisterStrike(hero.stats).calculate();
        } else if (attackName.equals("Fireball")){
            attackDamage = new Fireball(hero.stats).calculate();
        } else if (attackName.equals("Judgement")){
            attackDamage = new Judgement(hero.stats, ((Paladin) hero).seal).calculate();
            ((Paladin) hero).setSeal(new Seal(hero.stats.getAp()));
        }
        return attackDamage;
    }

    public static void identifyBuff(String buffName, Hero hero){
        if(buffName.equals("Seal of Righteousness")){
            ((Paladin)hero).setSeal(new SealOfRighteousness(hero.stats.getAp()));
        }
    }

    public static boolean isAttack(String string){
        boolean result = false;
        if(string.equals("Basic Attack")    ||
           string.equals("Sinister Strike") ||
           string.equals("Fireball")        ||
           string.equals("Judgement")){
            result = true;
        }
        return result;
    }

    public static boolean isBuff(String string){
        boolean result = false;
        if(string.equals("Seal of Righteousness")){
            result = true;
        }
        return result;
    }
}

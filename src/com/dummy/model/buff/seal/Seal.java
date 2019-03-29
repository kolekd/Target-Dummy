package com.dummy.model.buff.seal;

import com.dummy.model.buff.Buff;

public class Seal extends Buff {

    int unbuffedDamage;

    public Seal(int unbuffedDamage) {
        this.unbuffedDamage = unbuffedDamage;
        this.name = "No Seal";
    }

    public int getBuffedDamage(){
        return unbuffedDamage;
    }
}

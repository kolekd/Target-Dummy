package com.dummy.model.buff.seal;

public class SealOfRighteousness extends Seal {

    public SealOfRighteousness(int unbuffedDamage) {
        super(unbuffedDamage);
        this.name = "Seal of Righteousness";
    }

    @Override
    public int getBuffedDamage() {
        return super.getBuffedDamage() + 50;
    }
}

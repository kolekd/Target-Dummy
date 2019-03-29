package com.dummy.model.factory;

import java.util.ArrayList;
import java.util.List;

public class ClassFactory {

    public static List<String> createAllClasses(){
        List<String> classList = new ArrayList<>();
        classList.add("Warrior");
        classList.add("Rogue");
        classList.add("Mage");
        classList.add("Warlock");
        classList.add("Priest");
        classList.add("Hunter");
        classList.add("Shaman");
        classList.add("Paladin");
        classList.add("Druid");
        return classList;
    }

}

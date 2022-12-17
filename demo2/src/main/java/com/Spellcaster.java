package com;

public abstract class Spellcaster extends Hero {
    protected static int manapoints;

    public void drinkManapotion(Potion potion){
        manapoints+=200;
    }
}

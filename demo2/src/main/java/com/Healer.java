package com;

public class Healer extends Spellcaster{
    {
        health=500;
        armor=200;
        damage=0;
        manapoints=300;
    }

    @Override
    public void attack(Enemy ennemy) {
        ennemy.health-=Healer.damage;
        Healer.manapoints-=0;
    }

    public void Heal(Hero hero){
        System.out.println("Let's heal my bros");
        hero.health += 100;
    }

}

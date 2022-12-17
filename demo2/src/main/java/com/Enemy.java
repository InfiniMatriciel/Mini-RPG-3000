package com;

public abstract class Enemy extends Combattant{

    public void attack(Hero hero){
        System.out.println(this +" attack +"+ hero);
        if(hero.armor>0){
            hero.armor -= damage;
        }
        else { hero.health -= damage;}
    }
}

package com;

public class Mage extends Spellcaster{

    {
        health=500;
        armor=200;
        damage=100;
        manapoints=300;
    }

    @Override
    public void attack(Enemy ennemy) {
        System.out.println("Une Potion ? 1(OUI) 2(NON) : ");
        int n = sc.nextInt();
        if(n == 1){
            this.usePotion();
            ennemy.health -= damage;

        }
        else{
            ennemy.health -= damage;
        }
    }
}

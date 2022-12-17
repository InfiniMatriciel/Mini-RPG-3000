package com;

public class Warrior extends Hero{

    {
        health=500;
        damage=80;
        armor=200;
    }

    @Override
    public void attack(Enemy ennemy) {
        System.out.println(this+" attack "+ ennemy);
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

package com;

public class Hunter extends Hero{
    protected int arrows;


    {
        health=500;
        damage=80;
        armor=200;
        arrows=20;
    }

    @Override
    public void attack(Enemy ennemy) {
        System.out.println("Une Potion ? 1(OUI) 2(NON) : ");
        int n = sc.nextInt();
        if(n == 1){
            this.usePotion();
            ennemy.health -= damage;
            arrows-=1;
            System.out.println(this+" dispose de " +arrows+" flèches");
        }
        else{
            ennemy.health -= damage;
            arrows-=1;
            System.out.println(this+" dispose de " +arrows+" flèches");
        }

    }


}

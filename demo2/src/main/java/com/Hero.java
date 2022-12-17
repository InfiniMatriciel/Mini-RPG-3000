package com;

import java.util.Scanner;

public abstract class Hero extends Combattant{
    protected int armor;

    public Scanner sc = new Scanner(System.in);

    public void attack(Enemy ennemy) {

    }


    public void usePotion(){
        health+=200;
    }


}

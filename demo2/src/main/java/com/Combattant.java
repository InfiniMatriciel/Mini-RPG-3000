package com;

public abstract class Combattant {
    protected int health;
    protected static int damage;


    public boolean isDead(){
        return this.health <= 0;
    }

}

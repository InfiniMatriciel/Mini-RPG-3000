package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Combat {
    public List<Hero> heroes;
    public List<Enemy> enemies;
    public int playerTurn;

    public Random rand = new Random();

    private final Game game;

    public Combat(Game game) {
        this.heroes = game.heroes;
        this.enemies = game.enemies;
        this.game = game;
    }

    public void startFight() {
        playerTurn = ThreadLocalRandom.current().nextInt(0,1);
        while(game.round<5){
            if(enemies.isEmpty()){
                game.chooseEnemies();
                this.play();
            }
            else {this.play();}
        }
        game.finalBoss();
        this.play();
    }
    public void play(){

     //   if(enemies.isEmpty()){game.chooseEnemies();}

        if(playerTurn == 0){// Tour de l'ennemi


            if(!enemies.isEmpty()) {
                int randomEnemy = rand.nextInt(0, enemies.size());
                int randomHero = rand.nextInt(0, heroes.size());
                if (enemies.size() == 1) {
                    enemies.get(0).attack(heroes.get(randomHero));
                } else {
                    enemies.get(randomEnemy).attack(heroes.get(randomHero));
                }

                if (heroes.get(randomHero).isDead()) {
                    heroes.remove(randomHero);
                }

            }
                List pvListes = new ArrayList();
                for (int k = 0; k < heroes.size(); k++) {
                    pvListes.add(heroes.get(k).health);
                }

                List armorListes = new ArrayList();
                for (int k = 0; k < heroes.size(); k++) {
                    armorListes.add(heroes.get(k).armor);
                }

                System.out.println("liste des heros : " + heroes);
                System.out.println("Liste des PV :       "+pvListes);
                System.out.println("Liste des Armures :       "+armorListes);


            if(enemies.isEmpty()){
                System.out.println("Les Héros ont gagnés le round "+game.round);
                game.updateRound();

            }

            if(heroes.isEmpty()){
                System.out.println("Les ennemis ont gagné");
            }
            playerTurn = 1;
        }
        else {

            if(!heroes.isEmpty()){
                int randomEnemy = ThreadLocalRandom.current().nextInt(0,enemies.size());
                int randomHero = ThreadLocalRandom.current().nextInt(0, heroes.size());
                int randomHero2 = rand.nextInt(0, heroes.size());
                if(!(heroes.get(randomHero) instanceof Healer)) {
                    heroes.get(randomHero).attack(enemies.get(randomEnemy));
                    if (enemies.get(randomEnemy).isDead()) {
                        enemies.remove(randomEnemy);
                    }
                }
                else {
                    ((Healer) heroes.get(randomHero)).Heal(heroes.get(randomHero2));
                }
            }

            List pvListes = new ArrayList();
            for (int k = 0; k < enemies.size(); k++) {
                pvListes.add(enemies.get(k).health);
            }

            System.out.println("liste des enemies : " + enemies);
            System.out.println("Liste des PV :       "+ pvListes);


            if(enemies.isEmpty()){
                System.out.println("Les Héros ont gagnés le round "+game.round);
                game.updateRound();
            }

            if(heroes.isEmpty()){
                System.out.println("Les ennemis ont gagné");
            }
            playerTurn = 0;
            }

    }

    public List<Hero> getHeroes() {
        return heroes;
    }




}

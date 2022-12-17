package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    public int numHero;
    public int round = 1;
    private final Scanner sc = new Scanner(System.in);
    public List<Hero> heroes;
    public List<Enemy> enemies;
    private List<Consumable> consumables;
    public Game() {
        this.heroes = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.consumables = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addConsumable(Consumable consumable) {
        consumables.add(consumable);
    }

    public void startGame() {
        // Code pour commencer la partie
        System.out.println("Choisir le nombre d'héros :");
        numHero = sc.nextInt();
        chooseHeroes();
        chooseEnemies();

    }



    private int doInput(int index) {

        System.out.format("Veuillez choisir votre héros n° %d: Hunter(1); Warrior(2); Mage(3); Healer(4): ", index +1);
        return sc.nextInt();
    }

    private void chooseHeroes() {
        heroes.addAll(IntStream.range(0, numHero)
                .boxed()
                .map(this::doInput)
                .map(this::createHero)
                .collect(Collectors.toList()));

    }

    private Hero createHero(int index) {
        Hero hero = null;
        switch (index) {
            case 1 -> hero = new Hunter();
            case 2 -> hero = new Warrior();
            case 3 -> hero = new Mage();
            case 4 -> hero = new Healer();
            default -> {
            }
        }
        if(Objects.isNull(hero)) {
            System.out.println("Vous avez choisi un mauvais numéro: Veuillez choisir un numéro entre 1 à 4");
            return createHero(doInput(0));
        }
        return hero;
    }

    public void chooseEnemies() {
        enemies.addAll(IntStream.range(0, numHero).boxed().map(unused -> new BasicEnemy()).collect(Collectors.toList()));
    }

    public void finalBoss(){
        System.out.println("Combat Final");
        enemies.add(new Boss());
    }

    public void updateRound(){
        round += 1;
    }


    public void healAll() {
        for(int k = 0; k< this.heroes.size(); k++){
            heroes.get(k).health += 100;
        }
    }
}


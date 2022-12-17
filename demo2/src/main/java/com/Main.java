package com;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Game mapartie = new Game();
        Combat moncombat = new Combat(mapartie);
        mapartie.startGame();
        moncombat.startFight();
        moncombat.startFight();

    }
}

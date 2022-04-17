package com.example.java;

public class Status {

    public static void gameOver() {
        PlayerComputer playerComputer = new PlayerComputer();
        //System.out.println("Your ships: " + playerComputer.pShips + " | Computer ships: " + playerComputer.cShips);
        if(playerComputer.pShips > 0 && playerComputer.cShips <= 0)
            System.out.println("Hooray! You win the battle :)");
        else
            System.out.println("Sorry, you lose the battle");
        System.out.println();
    }
}

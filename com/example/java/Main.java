package com.example.java;

public class Main {

    public static void main(String[] args) {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        System.out.println();

        PlayerComputer playerComputer = new PlayerComputer();
        playerComputer.OceanTable();
        playerComputer.playerShips();
        playerComputer.computerShips();

        do {
            playerComputer.battle();
        } while (playerComputer.pShips != 0 && playerComputer.cShips != 0);

        Status status = new Status();
        status.gameOver();
    }
}

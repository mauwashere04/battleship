package com.example.java;

import java.util.Scanner;

public class PlayerComputer {
    public static int row = 10;
    public static int col = 10;
    public static String[][] multi = new String[row][col];
    public static String[][] computerSlots = new String[row][col];
    public static int[][] computerGuess = new int[row][col];
    public static int cShips;
    public static int pShips;

    void OceanTable() {

        System.out.print("  ");
        for(int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 10; j++) {
                multi[i][j] = " ";
                System.out.print(multi[i][j]);
            }
            System.out.print("|" + i);
            System.out.println();
        }

        System.out.print("  ");
        for(int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }


    public void playerShips() {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        PlayerComputer.pShips = 5;
        for (int i = 1; i <= PlayerComputer.pShips;)
        {
            System.out.print("Enter x coordinate for your " + i + " ship: ");
            int x = sc.nextInt();
            System.out.print("Enter y coordinate for your " + i + " ship: ");
            int y = sc.nextInt();

            if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && (multi[x][y] ==" ")) {
                multi[x][y] = "@";
                i++;
            }
            else if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && multi[x][y] == "@") {
                System.out.println("You can NOT place two or more ships on the same location.");
            } else if ((x < 0 || x >= 10) || (y < 0 || y >= 10)) {
                System.out.println("You can't place ships outside the 10 by 10 grid.");
            }

        }
        System.out.println(" ");
       printTable();

    }

    public static void computerShips() {
        System.out.println();
        System.out.println("Computer is deploying ships");

        PlayerComputer.cShips = 5;
        for (int i = 1; i <= PlayerComputer.cShips; ) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && multi[x][y] == " ") {
                computerSlots[x][y] = "c";
                System.out.println(i + ". ship DEPLOYED");
                i++;
            }
           else if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && multi[x][y] == "@") {
                System.out.println("Can't overwrite");

            }
            else if ((x < 0 || x >= 10) || (y < 0 || y >= 10)) {
                System.out.println("Outside the grid");
            }
        }
        System.out.println(" ");
    }

    public static void battle(){
        playerTurn();
        computerTurn();

        printTable();

        System.out.println(" ");
        System.out.println("Your ships: " + PlayerComputer.pShips + " | Computer ships: " + PlayerComputer.cShips);


    }

    public static void playerTurn() {
        System.out.println(" ");
        System.out.println("YOUR TURN");
        int x = -1, y = -1;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = sc.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = sc.nextInt();

            if ((x >= 0 && x < 10) && (y >= 0 && y < 10)) {
                if (computerSlots[x][y] == "c") {
                    System.out.println("Boom! You sunk the ship!");
                    multi[x][y] = "!";
                    --PlayerComputer.cShips;
                } else if (multi[x][y] == " ") {
                    System.out.println("Sorry, you missed");
                    multi[x][y] = "-";
                } else if (multi[x][y] == "@") {
                    System.out.println("Oh no, you sunk your own ship :(");
                    multi[x][y] = "x";
                    --PlayerComputer.pShips;
                }
            } else {
                System.out.println("You can't place ships outside the grid");
            }
        } while ((x < 0 || x >= 10) || (y < 0 || y >= 10));
        System.out.println(" ");
    }


    public static void computerTurn() {
        System.out.println(" ");
        System.out.println("COMPUTER'S TURN");
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

                if (multi[x][y] == "@") {
                    System.out.println("The Computer sunk one of your ships!");
                    multi[x][y] = "x";
                    --PlayerComputer.pShips;
                }  else if (computerSlots [x][y] == "c") {
                    System.out.println("The Computer sunk one of its own ships");
                    multi[x][y] = "!";
                    --PlayerComputer.cShips;
                } else  {
                    System.out.println("Computer missed");
                    //Saving missed guesses for computer
                    if(computerGuess[x][y] != 1)
                        computerGuess[x][y] = 1;
                }

        } while ((x < 0 || x >= 10) || (y < 0 || y >= 10));
        System.out.println(" ");
    }


    public static void printTable() {


        System.out.print("  ");
        for(int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 10; j++) {
                System.out.print(multi[i][j]);
            }
            System.out.print("|" + i);
            System.out.println();
        }

        System.out.print("  ");
        for(int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

}

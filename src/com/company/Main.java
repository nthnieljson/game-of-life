package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world");
        Board gameBoard = new Board(10, 10);

        // receive input from user
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;

        while (x != -1 && y != -1) {
            System.out.println("Input the coordinate that you want to toggle, or input -1 to start playing");
            System.out.print("x: ");
            x = sc.nextInt();
            System.out.print("y: ");
            y = sc.nextInt();

            if (x >= 0 && x < gameBoard.getCol() && y >= 0 && y < gameBoard.getRow()) {
                gameBoard.toggleCell(x, y);
                System.out.println(gameBoard.getLifeNeighborCount(x, y));
                gameBoard.print();
            }
        }


        // start playing
        System.out.println("----- STARTING SIMULATION -----");
        while (true) {
            gameBoard.print();
            gameBoard.nextGeneration();
            System.out.println("\n+++++++++++++++++++++++++++++++++++++\n");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }

    }
}

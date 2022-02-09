package com.revature;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
        int cpu = 0;
        int win = 0;
        int lose = 0;
        int draw = 0;
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        do {
            System.out.println("\n------------------------------");
            System.out.println("Welcome to Rock Paper Scissor!");
            System.out.println("------------------------------");
            System.out.println("\nChoose your weapon: Rock (r) Paper (p) Scissor (s) [x to exit]");

            input = scan.next().charAt(0);

            switch (input) {
                case 'r':
                    cpu = rand.nextInt(3);
                    System.out.println();

                    if (cpu == 0) {
                        System.out.println("CPU pick Rock!");
                        System.out.println("\nIT'S A DRAW!");

                        draw++;
                    } else if (cpu == 1) {
                        System.out.println("CPU pick Paper!");
                        System.out.println("\nYOU LOSE!");

                        lose++;
                    } else if (cpu == 2) {
                        System.out.println("CPU pick Scissor!");
                        System.out.println("\nYOU WIN!");

                        win++;
                    }

                    break;
                case 'p':
                    cpu = rand.nextInt(3);
                    System.out.println();

                    if (cpu == 0) {
                        System.out.println("CPU pick Rock!");
                        System.out.println("\nYOU WIN!");

                        win++;
                    } else if (cpu == 1) {
                        System.out.println("CPU pick Paper!");
                        System.out.println("\nIT'S A DRAW!");

                        draw++;
                    } else if (cpu == 2) {
                        System.out.println("CPU pick Scissor!");
                        System.out.println("\nYOU LOSE!");

                        lose++;
                    }

                    break;
                case 's':
                    cpu = rand.nextInt(3);
                    System.out.println();

                    if (cpu == 0) {
                        System.out.println("CPU pick Rock!");
                        System.out.println("\nYOU LOSE!");

                        lose++;
                    } else if (cpu == 1) {
                        System.out.println("CPU pick Paper!");
                        System.out.println("\nIT'S A WIN!");

                        win++;
                    } else if (cpu == 2) {
                        System.out.println("CPU pick Scissor!");
                        System.out.println("\nIT'S A DRAW!");

                        draw++;
                    }

                    break;
                case 'x':
                    exit = true;

                    System.out.println("\nHere's your record!");
                    System.out.println();
                    System.out.println("wins: " + win);
                    System.out.println("Loses: " + lose);
                    System.out.println("Draws: " + draw);

                    break;
                default:
                    System.out.println("\nInvalid input");
                    break;
            }

        } while (!exit);
    }
}

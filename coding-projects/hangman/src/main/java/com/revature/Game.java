package com.revature;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
        int life = 6;
        char[] guess = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char input;
        String word = getWord();
        String hidden = hideWord(word);
        Scanner scan = new Scanner(System.in);

        System.out.println("\n--------------------");
        System.out.println("Welcome to Hangman!");
        System.out.println("--------------------");

        while (life >= 0) {
            System.out.println("\nWord: " + hidden);
            System.out.println("Life: " + life);
            System.out.print("Your guess: ");
            printArr(guess);

            System.out.print("\n\nGuess: ");
            input = scan.next().charAt(0);

            if (checkChar(word, input)) {
                hidden = updateWord(word, hidden, input);
                life = addToGuessBank(life, guess, input);

                if (word.equals(hidden)) {
                    System.out.println("You win!");
                    break;
                }
            } else {
                life = addToGuessBank(life, guess, input);
            }
        }

        if (life == 0) {
            System.out.println("You lose!");
        }
    }

    private void printArr(char[] guess) {
        for (char c : guess) {
            if (c == ' ') {
                break;
            } else {
                System.out.print(c);
                System.out.print(' ');
            }
        }
    }

    private String getWord() {
        String[] arr = {"java", "api", "react", "linux", "git"};
        Random rand = new Random();

        return arr[rand.nextInt(5)];
    }

    private String hideWord(String word) {
        String hidden = "";
        for (int i = 0; i < word.length(); i++) {
            hidden += "*";
        }

        return hidden;
    }

    private boolean checkChar(String word, char input) {
        for (char c : word.toCharArray()) {
            if (input == c) {
                return true;
            }
        }

        return false;
    }

    private String updateWord(String word, String hidden, char input) {
        StringBuilder sb = new StringBuilder(hidden);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                sb.setCharAt(i, input);
            }
        }

        return sb.toString();
    }

    private int addToGuessBank(int life, char[] guess, char input) {
        if (checkGuessBank(guess, input)) {
            System.out.println("You already picked this character");
        } else {
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == ' ') {
                    guess[i] = input;
                    life--;
                    break;
                }
            }
        }

        return life;
    }

    private boolean checkGuessBank(char[] guess, char input) {
        for (char c : guess) {
            if (c == input) {
                return true;
            }
        }

        return false;
    }
}

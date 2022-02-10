package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

import static java.lang.Character.isAlphabetic;

public class Game {
    public void start() {
        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);
        Scanner scan = new Scanner(System.in);
        //     Char[] guesses = {};

        while (life >= 0) {
            System.out.println("Welcome to Hangman!");
            System.out.println("Word to guess: " + hidden);
            System.out.println("Life: " + life);

            System.out.print("Guess: ");
            input = scan.nextLine().charAt(0);

            if (validation(word, input)) {
                StringBuilder editHidden = new StringBuilder(hidden);
                for (int i = 0; i < word.length(); i++) {
                    if(input == word.charAt(i)) {
                        editHidden.replace(i, i+1, String.valueOf(input));
                    }

                }
                hidden = editHidden.toString();

            char[] guessList = new char[word.length()];
            for (int i = 0; i < guessList.length; i++) {
                guessList[i] = ' ';
            }

            for (int i = 0; i < hidden.length(); i++) {
                int j = 0;
                if (isAlphabetic(hidden.charAt(i))) {
                    Arrays.sort(guessList);
                    j = Arrays.binarySearch(guessList, hidden.charAt(i));
                }
                if (j >= 0) {
                    continue;
                }
                for (int k = 0; k < guessList.length; k++) {
                    if(guessList[k] == ' '){
                        guessList[k] = hidden.charAt(i);
                        break;
                    }
                }
            }




                System.out.println("Current Guesses: " + Arrays.toString(guessList));
                if(hidden.equals(word)) {
                    System.out.println("You won!");
                    System.out.println("Word to Guess: " + word);
                    break;
                }
            } else {
                System.out.println("Guess Again!");
                life = life - 1;
                if (life == 0){
                    System.out.println("Better Luck Next time!");
                    break;
                }
            }
        }
    }

    private String getWord() {
        String[] arr = {"java", "wezley", "bao", "intellij", "revature"};

        Random rand = new Random();

        int index = rand.nextInt(5);

        return arr[index];
    }

    private String hideWord(String word) {
        String hidden = "";

        for (int i = 0; i < word.length(); i++) {
            hidden += '*';
        }

        return hidden;
    }

    private Boolean validation(String word, char input) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                return true;
            }
        }

        return false;
    }
}

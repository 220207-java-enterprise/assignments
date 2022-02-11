package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;

public class Game {
    // initialize variables for game
    int guesses = 6;

    String word = getWord();
    String hidden = hideWord(word);
    char userInput = ' ';

    Scanner scan = new Scanner(System.in);

    // starts the hangman game
    public void start() {
        System.out.println("Welcome to Hangman!");

        // while the player has guesses remaining, loop through game logic
        while(validateLife(guesses)) {
            System.out.println("Word to guess: " + hidden);
            System.out.println("You have " + guesses + " guesses remaining.");
            System.out.print("Your guess: ");

            userInput = scan.nextLine().charAt(0);
            // set user input to lower case
            userInput = Character.toLowerCase(userInput);

            if (validateInput()) updateHidden();
            else {
                guesses--;
            }

            if (guesses == 0) System.out.println("You lose!");

            if (!hidden.contains("*")) {
                System.out.println("The word was: " + hidden);
                System.out.println("You won!");
                return;
            };
        }

        if (life == 0) {
            System.out.println("You lose!");
        }
    }

    // randomly selects a word from the wordsArr
    private String getWord() {
        String[] wordsArr = {"java", "wezley", "bao", "intellij", "revature"};

        Random rand = new Random();
        // randomly select a number between 0 and 4
        int chosenWordIdx = rand.nextInt(5);

        return wordsArr[chosenWordIdx];
    }

    private String hideWord(String word) {
        String hidden = "";

        for (int i = 0; i < word.length(); i++) {
            hidden += "*";
        }

        return hidden;
    }

    private Boolean validateLife(int guesses) {
        if (guesses > 0) {
            return true;
        }
        return false;
    }

    private Boolean validateInput() {
        boolean inputMatch = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == userInput) {
                inputMatch = true;
                break;
            }
        }

        return inputMatch;
    }

    private void updateHidden() {
        int index;
        String updatedWord = hidden;

        // loop through the word
        for (int i = 0; i < word.length(); i++) {
            // if the user input matches the given character
            if (word.charAt(i) == userInput) {
                updatedWord = updatedWord.substring(0, i) + word.charAt(i) + updatedWord.substring(i + 1);
            }
        }

        hidden = updatedWord;
    }
}
package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
<<<<<<< HEAD
        //ask user if they want to play again?

=======
>>>>>>> main
        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);
<<<<<<< HEAD
        String guesses = "";

        Scanner scan = new Scanner(System.in);

        while (life >= 0 && !word.equals(hidden)) {
=======
        Scanner scan = new Scanner(System.in);

        while (life > 0) {
>>>>>>> main
            System.out.println("Welcome to Hangman!");
            System.out.println("Word to guess: " + hidden);
            System.out.println("Life: " + life);

            System.out.print("Guess: ");
            input = scan.nextLine().charAt(0);

<<<<<<< HEAD
            guesses += input;
            //System.out.println(guesses);

            if (validation(word, input)) {
                System.out.println("Yay!");
                hidden = updateHiddenWord(hidden, word, input);
            }
            else {
                life--;
            }
        }
        if (word.equals(hidden))
            System.out.println("Congratulations you've reached the end!");
        else
            System.out.println("Sorry you lost...");

=======
            if (validation(word, input)) {
                hidden = updateWord(word, hidden, input);

                System.out.println(hidden);
            } else {
                life--;
            }
        }

        if (life == 0) {
            System.out.println("You lose!");
        }
>>>>>>> main
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

<<<<<<< HEAD
    private String updateHiddenWord(String hiddenWord, String word, char input) {
        String newHidden = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                newHidden += input;
            }
            else {
                newHidden += hiddenWord.charAt(i);
            }
        }
        return newHidden;
=======
    private String updateWord(String word, String hidden, char input) {
        StringBuilder sb = new StringBuilder(hidden);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                sb.setCharAt(i, input);
            }
        }

        return sb.toString();
>>>>>>> main
    }
}

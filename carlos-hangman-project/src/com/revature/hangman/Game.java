package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;

//Already Implemented:
//- Life counter goes down when user input is incorrect
//- Game is over once life counter = 0

//TO-DO:
//1. Show correct letter when user input = word[i]
//2. Have counter for guessed words
    //-When word= correct ==> show word and add to counter
    //-When word= incorrect==> remain hidden and add to counter
//3. When full word is guessed, end the game and print "Congratulations! You won!"


public class Game {

    public void start() {
        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);
        Scanner scan = new Scanner(System.in);

        while (life > 0) {
            System.out.println("Welcome to Hangman!");
            System.out.println("Word to guess: " + hidden);
            System.out.println("Life: " + life);

            System.out.print("Guess: ");
            input = scan.nextLine().charAt(0);

            if (validation(word, input)) {
                hidden = updateWord(word, hidden, input);
                System.out.println("Yay!");

                System.out.println(hidden);
            } else {
                life--;
                System.out.println("Boo!");

            }
        }

        if (life == 0) {
            System.out.println("You lose!");
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

    private String updateWord(String word, String hidden, char input) {
        StringBuilder sb = new StringBuilder(hidden);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                sb.setCharAt(i, input);
            }
        }

        return sb.toString();
    }
}

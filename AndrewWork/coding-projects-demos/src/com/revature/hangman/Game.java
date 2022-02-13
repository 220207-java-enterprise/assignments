package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);
        Scanner scan = new Scanner(System.in);

        while (life >= 0) {
            System.out.println("Welcome to Hangman!");
            System.out.println("Word to guess: " + hidden);
            System.out.println("Life: " + life);

            System.out.print("Guess: ");
            input = scan.nextLine().charAt(0);

            if (validation(word, input)) {
                hidden = revealLetter(hidden, word, input);
                System.out.println("Yay!");
                if (hidden.equals(word)){
                    winCondition(word);
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

    private String revealLetter(String hidden, String word, char input){
        StringBuilder revealWord = new StringBuilder(hidden);
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == input){
                revealWord.setCharAt(i, input);
            }
        }
        return revealWord.toString();
    }

    private void winCondition(String word){
        System.out.println("You guessed the word: " + word);
        System.out.println("You Win!!!");

    }
}

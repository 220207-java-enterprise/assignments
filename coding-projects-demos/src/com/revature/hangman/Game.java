package com.revature.hangman;


import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Game {
    String hidden;
    String[] Guesses = new String[26];
    int life = 6;


    public void start() {
        System.out.println(Guesses);
        char input = ' ';
        int turn = 0;


        String word = getWord();
        if (turn == 0) {
            System.out.println("First Guess.");
            hidden = hideWord(word);
        }



        try (Scanner scan = new Scanner(System.in)) {
            while (life >= 0 && end(hidden)) {
                System.out.println("Turn: " + turn);
                System.out.println("Life: " + life);
//System.out.println(word);
                if (turn == 0) {
                    System.out.println("Word to guess: " + hidden);
                    System.out.println("Welcome to Hangman!");
                    System.out.print("Guess: ");
                    input = scan.nextLine().charAt(0);
                }


//System.out.println(unHash(word, 'e', hidden));
                if (turn == 1) {
                    System.out.println("Word to guess: " + hidden);
                    System.out.print("Guess again: ");
                    input = scan.nextLine().charAt(0);
                }

                if (turn > 1) {
                    System.out.println("Word to guess: " + hidden);
                    System.out.print("Guess again: ");
                    input = scan.nextLine().charAt(0);
                }


                if (validation(word, input)) {
                    System.out.println("Word to guess: " + unHash(word, input));
                    System.out.println("Yay!");
                    turn++;
                } else {
                    System.out.println("Wrong guess kid.");
                    turn++;
                }
            }
        }

    }

    private boolean end(String word) {
        boolean var = false;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == '*') {
                    var=true;
                }

                else {
                    var=false;
                }
            }
        return var;
    }

    private String getWord() {
        String[] arr = {"java", "wezley", "bao", "intellij", "revature"};

        Random rand = new Random();

        int index = rand.nextInt(5);

        return arr[index];
    }

    private String hideWord(String word) {
        hidden = "";

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
        life--;
        return false;
    }


    // turning **'s back into the letter that you guessed if the letter you guessed is correct.'


    private String unHash(String word, char input) {
        char[] wordChar = word.toCharArray();
        char[] hiddenChar = hidden.toCharArray();
        StringBuilder lessHidden = new StringBuilder(hidden);
        int ting = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                lessHidden.setCharAt(i, input);
                ting = i;
            }

        }

//        System.out.println(word);
//        System.out.println("this is current hidden: " + hidden);

        hidden = lessHidden.toString();
        return (lessHidden.toString());
    }

    // add a funciton that adds each guess to an array of guesssed letters then pass that to unHash to redefine hidden each time. Also for "guessed charachters thing in future.
}

package com.revature.hangman;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.*;

public class Game {
    public void start() {
        System.out.println("Welcome to Hangman!");

        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);

        char[] letterBank = new char[26];
        int letterCounter = 0;

        Scanner scan = new Scanner(System.in);

        while (life >= 0) {
            System.out.println("Word to guess: " + hidden);
            System.out.println("Life: " + life);

            System.out.print("Guess: ");
            input = scan.nextLine().charAt(0);

            if (validation(word, input)) {
                String updateWord = updateWord(input, hidden, word);
                hidden = updateWord;
            } else {
                life--;
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

    private String updateWord(char c, String hidden, String word) {
        char[] wordArray = word.toCharArray();
        char[] hiddenArray = hidden.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            if (c == wordArray[i]) {
                hiddenArray[i] = c;
            }
        }

        hidden = hiddenArray.toString();
        System.out.println(hiddenArray);

        return hidden;
    }

    /*
    private char[] updateLetterBank(char c, char[] charArr, int letterCounter) {
        charArr


        String updatedWord;

        return updatedWord;
    }

    private int updateCounter(char c, char[] charArr, int letterCounter) {
        charArr


        String updatedWord;

        return updatedWord;
    }
    */
}

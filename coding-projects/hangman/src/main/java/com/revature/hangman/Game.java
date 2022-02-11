package com.revature.hangman;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;
import java.util.Scanner;

public class Game {
    int life = 6;
    public void start(){

        char input = ' ';
        String word = getWord();
        System.out.println(word);
        String hiddenWord = hideWord(word);

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        while (!isGameOver(word, hiddenWord)){
            System.out.println("Life: " + life);
            System.out.println("Word to guess: " + hiddenWord);

            System.out.println("What is your guess? ");
            input = scan.nextLine().charAt(0);

            System.out.println();
            if (isValid(word, input)){
                System.out.println("Correct!");
                hiddenWord = updateWord(word, hiddenWord, input);
            } else{
                life--;
                System.out.println("Wrong Guess! Try again.");
            }
            guesses = storeGuess(input);
        }
    }

    // function that returns a word
    private String getWord(){
        String[] arr = {"java", "wezley", "intellij", "revature", "bao"};

        Random rand = new Random();
        int index = rand.nextInt(5);
        return arr[index];
    }

    // function that hides the word
    private String hideWord(String word){
        String hidden = "";
        for (int i=0; i<word.length(); i++) {
            hidden += "*";
        }
        return hidden;
    }

    // function that validates
    private boolean isValid(String word, char input){

        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c == input) {
                return true;
            }
        }
        return false;
    }

    String guesses = "";
    // function that stores guesses
    private String storeGuess(char input){
        guesses += input +" ";
        System.out.println("You have guessed--> " + guesses);
        return guesses;
    }

    // function that uncovers correct guess
    public String updateWord(String word, String hidden, char input){
        StringBuilder sb = new StringBuilder(hidden);
        for (int i=0; i<word.length(); i++){
            if(word.charAt(i)==input){
                sb.setCharAt(i, input);
            }
        }

        return sb.toString();
    }

    public Boolean isGameOver(String word, String hiddenWord){
        if (word.equals(hiddenWord)){
            System.out.println("You have finished this level");
            return true;
        } else if(life == 0){
            System.out.println("You ran out of lives");
            return true;
        } else{
            return false;
        }
    }
}
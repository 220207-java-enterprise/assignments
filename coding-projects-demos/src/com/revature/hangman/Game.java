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
        int life = 6;//starting lives
        char input = ' ';//input from user
        String word = getWord();//string word is set to method getWord()
        String hidden = hideWord(word);//hidden is set to hideWord(word)
        Scanner scan = new Scanner(System.in);//scanner system installed
        String counter = counter();

        while (life > 0) {//while life is greater than or equal to 0
            System.out.println("Welcome to Hangman!");//print
            System.out.println("Word to guess: " + hidden);//print
            System.out.println("Life: " + life);//print + life

            System.out.print("Guess: ");//print
            input = scan.nextLine().charAt(0);//takes input and set equal to user input first character

            if (validation(word, input)) { //if validation is equal to both word and input true   (if validation(word, input) == true)
                //switch hidden letter with correct guessed letter
                for (int i = 0; i < word.length(); i++) { //check
                    hidden[i] = input;
                    }
                System.out.println("Yay!");//print Yay! if validation true?
            } else { //else if user input not correct
                life--;//decrease life counter by 1 unit every time user guess is incorrect
                System.out.println("Boo!");//else print Boo! if letter is incorrect
            }
        } if (life == 0) {
            System.out.println("You lost! Game over!");
        }
    }

    private String getWord() { //creates String method getWord()
        String[] arr = {"java", "wezley", "bao", "intellij", "revature"}; //array with different words to guess from

        Random rand = new Random(); //invokes Random rand(imported above)

        int index = rand.nextInt(5);//rand.nextInt bound = generate random integer up to 5 (0,1,2,3,4)

        return arr[index];//return array with index(index will be a random value from 0-5(only 0,1,2,3,4)
    }

    private String hideWord(String word) { //creates String method hideWord
        String hidden = "";//creates empty String named hidden

        for (int i = 0; i < word.length(); i++) { //loop through word length
            hidden += '*'; //replaces word with asteriks
        }

        return hidden; //return hidden word
    }

    private Boolean validation(String word, char input) { //creates Boolean method validation with parameters (String word, char input)
        for (int i = 0; i < word.length(); i++) { //loop through word length
            if (word.charAt(i) == input) { //if word character at index i(0 through word length) is equal to the user input, then...

                return true; //return true, "validates" the method 'validate' as true
            }
        }
        return false;//otherwise return false
    }

    private String counter(String word, char input) {
        String counter = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                counter = counter + input;

            }
        }
        return counter;
    }

}

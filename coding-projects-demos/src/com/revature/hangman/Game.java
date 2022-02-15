package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;

<<<<<<< HEAD
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
        char input = ' ';//char with space
        String word = getWord();//string word is set to method getWord()
        String hidden = hideWord(word);//hidden is set to hideWord(word)
        Scanner scan = new Scanner(System.in);//scanner system installed
//        String guessedLettersBox = guessedLettersBox(word, input);


        while (life > 0) {//while life is greater than 0
            System.out.println("Welcome to Hangman!");//print
//            System.out.println(guessedLettersBox(word, input));
            System.out.println("Word to guess: " + hidden);//print
            System.out.println("Life: " + life);//print + life

            System.out.print("Guess: ");//print
            input = scan.nextLine().charAt(0);//takes input and set equal to user input first character

            if (validation(word, input)) { //if validation is equal to both word and input true   (if validation(word, input) == true)
                //switch hidden letter with correct guessed letter
                //create updateHiddenWord method/function
                System.out.println("Yay!");//print Yay! if validation true?

            } else { //else if user input not correct
                life--;//decrease life counter by 1 unit every time user guess is incorrect
                System.out.println("Boo!");//else print Boo! if letter is incorrect
            }
        }
        if (life == 0) {
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
        StringBuilder hidden = new StringBuilder();//creates String hidden using StringBuilder

        for (int i = 0; i < word.length(); i++) { //loop through word length
            hidden.append('*'); //adds asteriks to hidden String using StringBuilder
        }

        return hidden.toString(); //return hidden word to a string value
    }

    private Boolean validation(String word, char input) { //creates Boolean method validation with parameters (String word, char input)
        for (int i = 0; i < word.length(); i++) { //loop through word length
            if (word.charAt(i) == input) { //if word character at index i(0 through word length) is equal to the user input, then...

                return true; //return true, "validates" the method 'validate' as true
            }
        }
        return false;//otherwise, return false
    }

    private String guessedLettersBox(String word, char input) {
        StringBuilder guessedLetters = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            guessedLetters.replace(0, word.length(), ",");
            if (word.charAt(i) == input) {
                guessedLetters.setCharAt(i, input);
            }
        }
        return guessedLetters.toString();
    }

}

//    private String updateWord(String word, char input) {
//        StringBuilder lessHidden = new StringBuilder(hidden);
//        char [] wordChar = word.toCharArray();
//        char [] hiddenChar = hidden.toCharArray();
//    }
//



=======
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

                System.out.println(hidden);
            } else {
                life--;
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
>>>>>>> 8f42dedb9fb210ce7f9e7aa55db28fd0c0a4f5a2

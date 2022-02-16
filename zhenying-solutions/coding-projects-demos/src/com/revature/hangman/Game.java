package com.revature.hangman;

import java.util.Stack;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);
        Stack<Character> answer = setUpAnswer(word);
        Scanner scan = new Scanner(System.in);
        Stack<Character> finds = new Stack<>();

        System.out.println("Welcome to Hangman!");
        while (life >= 0) {
            if (answer.size() == finds.size()){
                System.out.println("You won, you figure out the correct word: "+ word);
                break;
            }
            System.out.println("Word to guess: " + hidden);
            System.out.println("Life: " + life);

            System.out.print("Guess: ");
            input = scan.nextLine().charAt(0);

            if (validation(input, finds, answer)) {
                hidden = upDateHidden(word,finds);
                System.out.println("Yay!");
            }else{
                life--;
            }
        }
    }

    private String upDateHidden(String word, Stack<Character> finds) {
        String hidden = "";
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (finds.search(c) == -1){
                hidden += '*';
            }else{
                hidden += c;
            }
        }
        return hidden;
    }

    private  Stack<Character> setUpAnswer(String word) {
        Stack<Character> ans = new Stack<>();
        for(int i=0; i<word.length(); i++){
            Character c = word.charAt(i);
            if (ans.search(c) == -1){
                ans.push(c);
            }
        }
        return ans;
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

    private Boolean validation(char input, Stack<Character> finds, Stack<Character> ans) {
        //check if the character is already finds
        for(char c:finds){
            if(input == c){
                System.out.println("You already guess this one, try something else");
                return false;
            }
        }
        Character c = input;
        if (ans.search(c) != -1 && finds.search(c) == -1){
            finds.push(c);
            return  true;
        }
        return false;
    }
}

/*
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
}*/

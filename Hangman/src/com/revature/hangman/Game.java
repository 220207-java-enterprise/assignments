package com.revature.hangman;

import java.util.Random;

public class Game {
    public void start() {
        String word = getWord();
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
        return (hidden.toString());
    }
}

package hangmanReal;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void start() {
        int life = 6;
        char input = ' ';
        String word = getWord();
        String hidden = hideWord(word);
       
        
        try (Scanner scan = new Scanner(System.in)) {
            while (life >= 0) {
                System.out.println("Welcome to Hangman!");
                System.out.println("Word to guess: " + hidden);
                System.out.println("Life: " + life);
System.out.println("test");
System.out.println(word);
System.out.println(unHash(word, 'e', hidden));
                System.out.print("Guess: ");
                input = scan.nextLine().charAt(0);

                if (validation(word, input)) {
                    System.out.println("Word to guess: " + unHash(word, input, hidden));
                    System.out.println("Yay!");
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


    // turning **'s back into the letter that you guessed if the lettter you guessed is correct.'
   

    private String unHash(String word, char input, String hidden) {
        char[] wordChar = word.toCharArray();
        char[] hiddenChar = hidden.toCharArray();
        String lessHidden = hidden;
        int ting = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                hiddenChar[i] = wordChar[i];
                ting = i;
            } 
            
        }
        System.out.println(word.charAt(ting));
        System.out.println(word);
        lessHidden = (hiddenChar.toString());
        return (lessHidden);
    }
}

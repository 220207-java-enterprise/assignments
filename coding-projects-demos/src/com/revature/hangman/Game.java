import java.util.Random;
import java.util.Scanner;


class Game{

    private String [] words = {"r", "ba"};

   
    private Scanner scan = new Scanner(System.in);
    private char userCharacter;
    private Random ran = new Random();
    private int random = 
    ran.nextInt(words.length - 1);
	
    private String word = words[random];
    private String hidden = "";
    // private int life = word.length();

    public void start(){

	int life = word.length();
	for (int i = 0; i < word.length(); i++){
	    hidden += "*";
	}

	while (life != 0){
	    System.out.println("Life: " + life);
	    System.out.println("Guess the hidden word: " + hidden);
	    System.out.print("Enter a letter: ");
	    userCharacter = scan.next().charAt(0);
	    if(isValidCharacter(word, userCharacter)){
		hidden = 	
		life++;
	    }
	life--;
	}
 
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
>>>>>>> 8b15e69f5c15e29c2289399db13bc5b569e0bafb
    }

    private boolean isValidCharacter(String word, char input){

	for (int i = 0; i < word.length(); i++){
	    if (input == word.charAt(i))
		return true;
	    return false;
	}
    }

<<<<<<< HEAD
=======
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
>>>>>>> 8b15e69f5c15e29c2289399db13bc5b569e0bafb
}

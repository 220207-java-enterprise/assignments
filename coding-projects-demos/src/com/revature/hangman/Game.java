import java.util.Random;
import java.util.Scanner;

class Game{

    private String [] words = {"rat", "ba"}; 

   
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
 
    }

    private boolean isValidCharacter(String word, char input){

	for (int i = 0; i < word.length(); i++){
	    if (input == word.charAt(i))
		return true;
	    return false;
	}
    }

}

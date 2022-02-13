import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class Game {

    private String randomWord = getRandomWord();
    private String hiddenWord = getHiddenWord(randomWord);
    final Scanner scan = new Scanner(System.in);
    private char userVal;

    private StringBuffer sb = new StringBuffer(hiddenWord);
    private String hintWords[];

    public void start() {

        System.out.println("Welcome to HangMan\nRules:");
        System.out.println("No time constraints.\n1 Letter, 1 guess.");
        System.out.println("Each wrong guess will reduce life.\nOnce it reaches 0, game ends");

        userChoice();
    }

    private void userChoice(){

        char userChoice = '\0';

        while(true){

            System.out.println("Please enter P to play or Q to quit");
            userChoice = scan.next().charAt(0);

            switch (userChoice){
                case 'P':
                case 'p':
                    System.out.println("Hints:" + Arrays.toString(hintWords));
                    System.out.println("Please guess the word: " + hiddenWord);
                    playGame();
                    break;
                case 'Q':
                case 'q':
                    System.out.println("You have chosen to quit.\nGood Bye");
                    break;
                default:
                    System.out.println("Wrong choice!!");
            }
            if (userChoice == 'Q' || userChoice == 'q')
                break;
        }
    }

    private void playGame() {

        int life = hiddenWord.length();

        while (life != 0) {

            System.out.println("Remaining Life: " + life);
            System.out.print("Enter a letter to guess:");
            userVal = scan.next().charAt(0);

            if (isValidCharacter())
                System.out.println("correct");
            else {
                System.out.println("Wrong");
                life--;
            }
            hiddenWord = sb.toString();
            System.out.println("After guess: " + hiddenWord);

            if (hiddenWord.equals(randomWord)) {
                System.out.println("YOU WON!");
                break;
            }
            if (life == 0) {
                System.out.println("YOU LOST! \nGAME OVER!");
                break;
            }
        }
    }

    public String getRandomWord() {

        String[] words = {"Revature", "Intellij", "Guitara", "Princer",
                            "Magica", "Chairh", "Fouro", "TimeT",
                            "Fixi", "Zoo", "Alzebra", "Physics"};

        Random ran = new Random();
        int ranNum = 0;

        hintWords = new String[words.length/3];

        for (int i = 0; i < hintWords.length; i++){
            ranNum = ran.nextInt(words.length);
            hintWords[i] = words[ranNum];
        }
        for (int i = 0; i < hintWords.length; i++){
            ranNum = ran.nextInt(hintWords.length);
        }
        return hintWords[ranNum];
    }

    public String getHiddenWord(String hiddenWord) {
        hiddenWord = "";
        for (int i = 0; i < randomWord.length(); i++)
            hiddenWord += "#";
        return hiddenWord;
    }

    private boolean isValidCharacter() {

        boolean valid = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (userVal == randomWord.charAt(i)) {
                sb.setCharAt(i, userVal);
                valid = true;
                continue;
            }
        }
        return valid;
    }

}

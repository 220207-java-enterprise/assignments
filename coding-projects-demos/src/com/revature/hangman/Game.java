import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class Game {

    private String randomWord = getRandomWord();
    private String hiddenWord = getHiddenWord();
    final Scanner scan = new Scanner(System.in);
    private char userVal;

    private StringBuffer sb = new StringBuffer(hiddenWord);
    private String hintWords[];

    /*
        Start method is called by the main driver program which
        starts the games.
        Method call: userChoice();
        For detail, see userChoice method declaration
    * */
    public void start() {

        System.out.println("Welcome to HangMan\nRules:");
        System.out.println("No time constraints.\n1 Letter, 1 guess.");
        System.out.println("Each wrong guess will reduce life.\nOnce it reaches 0, game ends");

        userChoice();
    }

    /*
        The user choice method is gives user to choose from
        options to play or quit.
        Method call: playGame(), getRandomWord(), getHiddenWord()
        For details see methods declarations
     */
    private void userChoice(){

        char userChoice = '\0';

        while(true){

            System.out.println("Please enter P to play or Q to quit");
            userChoice = scan.next().charAt(0);

            switch (userChoice){
                case 'P':
                case 'p':
                    randomWord = getRandomWord();
                    hiddenWord = getHiddenWord();
                    sb = new StringBuffer(hiddenWord);
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

    /*
        playGame method is used to track the life and user
        input character guess in the randomly selected string.
        method used: isValidCharacter() for details see isValidCharacter
        classes used: @Arrays https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
        @String https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
        @StringBuffer https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html
        methods used: length(), toString(), next(), charAt(),
     */
    private void playGame() {

        int life = hiddenWord.length();

        while (life != 0) {

            System.out.println("Hints:" + Arrays.toString(hintWords));
            System.out.println("Please guess the word: " + hiddenWord);

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
    /*
        getRandomWord is returns a random word from a randomized
        array and the returned value is stored in randomWord variable
        Class used: @Random https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        @Scanner https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
        Data Structure used: @Array
     */
    private String getRandomWord() {

        String[] words = {"Revature", "Intellij", "Guitar", "Princer",
                            "Magic", "Chair", "Four", "Time",
                            "Fix", "Zoo", "Alzebra", "Physics"};

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

    /*
        GetHidden method returns a string with # char set
        with the length of randomWord
     */
    private String getHiddenWord() {
        hiddenWord = "";
        for (int i = 0; i < randomWord.length(); i++)
            hiddenWord += "#";
        return hiddenWord;
    }

    /*
        isValidCharacter method checks if the userVal is
        present in the randomWord.
        If it finds the character, it invokes setCharAt of
        StringBuffer class to set the current index to the
        userVal. The loop continues until the condition
        becomes false.
     */
    private boolean isValidCharacter() {

        boolean valid = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (userVal == randomWord.charAt(i)){

                sb.setCharAt(i, userVal);
                valid = true;
                continue;
            }
        }
        return valid;
        }
    }



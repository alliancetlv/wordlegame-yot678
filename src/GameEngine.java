/**
 * This task was created by Niv Seker (https://github.com/sekerniv)
 *
 * For any questions or further assistance, feel free to reach out!
 */

// Leave this import as it is. You'll need it
import assignmentfiles.*;
public class GameEngine {
    private String targetWord;
    private int attemptsLeft;
    private boolean isWin;
    public GameEngine(String targetWord) {
        this.targetWord = targetWord;
        this.attemptsLeft = 6;
        this.isWin = false;
    }




    public static void main(String[] args) {
        WordLoader wordLoader = new WordLoader();
        String word = wordLoader.getRandomWord();
        GameEngine GE = new GameEngine(word);
        GameUI gui = new GameUI();
        System.out.println(word);
        while (!GE.isGameOver()) {
            String guess = gui.readUserGuess();
            gui.displayResult(GE.playGuess(guess), guess, GE.getAttemptsLeft());
        }
        if(GE.isWin()){
            gui.displayWin();
        }else {
            gui.displayLoss(word);
        }


    }

    /**
     * Compares the player's guess to the target word and returns feedback.
     * For each character in the guess:
     * - '*' if the character is in the correct position.
     * - '+' if the character is in the target word but in the wrong position.
     * - '-' if the character is not in the target word.
     *
     * The comparison is done up to the length of the shorter word, ignoring any extra characters.
     * Example:
     * targetWord = "taper", guess = "water"
     * Returns: "-*+**"
     **/
    public static String evaluateGuess(String targetWord, String guess){
        String endString = "";
        for(int i = 0; i < guess.length(); i++) {
            if (targetWord.indexOf(guess.charAt(i)) == -1) {
                endString += '-';
            } else if (guess.charAt(i) == targetWord.charAt(i)) {
                endString += "*";
            } else {
                endString += "+";
            }


        }

        return endString;
    }

    public boolean isGameOver() {
        return this.attemptsLeft == 0 || this.isWin;
    }
    public String playGuess(String guess) {
        this.attemptsLeft--;
        String s = evaluateGuess(this.targetWord, guess);
        if(s.indexOf('-') == -1 && s.indexOf('+') == -1 && s.length() == 5){
            this.isWin = true;
        }
        return s;
    }

    public boolean isWin() {
        return isWin;
    }
    public String getTargetWord(){
        return this.targetWord;
    }

    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }
}

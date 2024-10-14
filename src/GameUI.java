import java.util.*;
public class GameUI {
    Scanner input = new Scanner(System.in);
    public GameUI(){
        Scanner input = new Scanner(System.in);
    }
    public String readUserGuess(){
        return this.input.next();
    }
    public void displayResult(String endString, String guess, int attemptsLeft){
        System.out.println("You have "+attemptsLeft+" attempts left.");
        System.out.println("Your guess: " + guess);
        System.out.println("Feedback: " + endString);

    }
    public void displayWin(){
        System.out.println("Congratulations, YOU WIN!");
    }
    public void displayLoss(String TargetWord){
        System.out.println("Game over! The word was: "+TargetWord);
    }
}

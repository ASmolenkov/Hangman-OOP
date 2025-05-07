import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {

    private final Scanner SCANNER;
    private String answer;
    private int tryCount;
    private final Set <String> enteredLetters;

    public Player(){
        SCANNER = new Scanner(System.in);
        tryCount = 0;
        enteredLetters = new HashSet<>();
    }

    public String getAnswer() {
        return answer;
    }

    public int getTryCount() {
        return tryCount;
    }

    public Set<String> getEnteredLetters() {
        return enteredLetters;
    }

    public void setTryCount() {
        this.tryCount++;
    }

    public void playerAnswer() {
        answer = SCANNER.nextLine();
    }
    public void setEnteredLetters(String answer){
        enteredLetters.add(answer);
    }
}

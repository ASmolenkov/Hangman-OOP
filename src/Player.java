import java.util.*;

public class Player {

    private final Scanner scanner;
    private String answer;
    private int tryCount;
    private final List <String> enteredLetters;

    public Player(){
        scanner = new Scanner(System.in);
        tryCount = 0;
        enteredLetters = new ArrayList<>();
    }

    public String getAnswer() {
        return answer;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getEnteredLetters() {
        return enteredLetters;
    }

    public void setTryCount() {
        this.tryCount++;
    }
    public void resetTryCount(){
        this.tryCount = Constants.MIN_TRY;
    }

    public void inputAnswer() {
        answer = scanner.nextLine().toLowerCase();
    }
    public void setEnteredLetters(String answer){
        enteredLetters.add(answer);
    }
}

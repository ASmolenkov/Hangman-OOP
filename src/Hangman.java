public class Hangman {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("dictionary");
        GameLogic gameLogic = new GameLogic(dictionary);
        gameLogic.startGame();
    }
}


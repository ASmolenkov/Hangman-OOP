
import java.util.Random;

public class GameLogic {

    private final Player player;
    private final HangmanPicture hangmanPicture;
    private SecretWord secretWord;
    private Random random;
    private final Dictionary dictionary;



    public GameLogic(){
        random = new Random();
        player = new Player();
        hangmanPicture = new HangmanPicture();
        dictionary = new Dictionary();

    }

    public void startGame(){
        while (startMenu()) {
            System.out.println(Constants.START_GAME);
            beginningGame();
        }
    }

    private boolean startMenu(){
        while (true) {

            System.out.println(Constants.WELCOME);
            System.out.println(Constants.START_PROMPT);
            player.playerAnswer();
            if (player.getAnswer().equalsIgnoreCase(Constants.START)) {
                player.getEnteredLetters().clear();
                player.resetTryCount();
                secretWord = new SecretWord(dictionary.getListWord().get(random.nextInt(dictionary.getListWord().size())));
                secretWord.maskingWord();
                return true;
            } else if (player.getAnswer().equalsIgnoreCase(Constants.STOP)) {
                System.out.println(Constants.THANKS);
                return false;
            }

            System.out.println(Constants.INVALID_INPUT);

        }
    }
    private void beginningGame(){
        player.getEnteredLetters().clear();
        player.resetTryCount();
        while (true) {
            printGameState(secretWord,player);
            player.playerAnswer();
            if(ChecksAnswer.checkingUncorrectedInput(player,secretWord)){
                continue;
            }
            if (player.getAnswer().length() == secretWord.getSecretWord().length()) {
                if(ChecksAnswer.checkFullWord(player,secretWord)) {
                    System.out.println(Constants.YOU_WIN);
                    break;
                }
                else {
                    System.out.println(Constants.YOU_MISTAKE);
                    player.setTryCount();
                    player.setEnteredLetters(player.getAnswer());
                    continue;
                }
            }
                workingWithInput();
                if(ChecksAnswer.checkIsTryCount(player)){
                    isLose();
                    break;
                }
                if(theMaskIsEmpty(secretWord.getWordMask())){
                    System.out.println(Constants.YOU_WIN);
                    break;
                }
            }
        }
        private void printGameState(SecretWord secretWord, Player player){
            System.out.println(Constants.WORD_SECRET + secretWord.getSecretWord());
            System.out.println(Constants.WORD_SECRET + secretWord.getWordMask());
            System.out.println(Constants.NUMBER_OF_TRY + player.getTryCount());
            System.out.println(Constants.ALREADY_USED + player.getEnteredLetters().toString());
            hangmanPicture.printHangman(player.getTryCount());
            System.out.println(Constants.ENTERED_LETTER);
        }

        private boolean theMaskIsEmpty(StringBuilder maskWord){
            return !maskWord.toString().contains(secretWord.getCHAR_MASK());
        }

        private void workingWithInput(){
            if (ChecksAnswer.checkLetterInSecretWord(player, secretWord)) {
                secretWord.letterReplacement(player.getAnswer().charAt(0));
                player.setEnteredLetters(player.getAnswer());
            }
            else {
                System.out.printf(Constants.TEMPLATE_LETTER_NOT, player.getAnswer());
                player.setEnteredLetters(player.getAnswer());
                player.setTryCount();
            }
        }
        private void isLose(){
            hangmanPicture.printHangman(player.getTryCount());
            System.out.println(Constants.YOU_LOOSE);
            System.out.println(Constants.WORD_SECRET + secretWord.getSecretWord() + "\n");
        }


    }
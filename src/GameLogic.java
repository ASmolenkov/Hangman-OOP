
import java.util.Random;

public class GameLogic {

    private final Player player;
    private final HangmanPicture hangmanPicture;
    private SecretWord secretWord;
    private Random random;
    private final Dictionary dictionary;



    public GameLogic(Dictionary dictionary){
        random = new Random();
        player = new Player();
        hangmanPicture = new HangmanPicture();
        this.dictionary = dictionary;

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
            player.inputAnswer();
            if (player.getAnswer().equalsIgnoreCase(Constants.START)) {
                player.getEnteredLetters().clear();
                player.resetTryCount();
                //
                createSecretWord(requestDifficulty());
                return true;
            } else if (player.getAnswer().equalsIgnoreCase(Constants.STOP)) {
                System.out.println(Constants.THANKS);
                return false;
            }
            System.out.println(Constants.INVALID_INPUT);
        }

    }
    private void createSecretWord(int difficultyLevel){
        if(difficultyLevel == 1){
            int wordIndex = random.nextInt(dictionary.getEasyWord().size());
            String text = dictionary.getEasyWord().get(wordIndex);
            secretWord = new SecretWord(text);
        } else if (difficultyLevel == 2) {
            int wordIndex = random.nextInt(dictionary.getMediumWord().size());
            String text = dictionary.getMediumWord().get(wordIndex);
            secretWord = new SecretWord(text);
        } else if (difficultyLevel == 3) {
            int wordIndex = random.nextInt(dictionary.getHardWord().size());
            String text = dictionary.getHardWord().get(wordIndex);
            secretWord = new SecretWord(text);
        }
    }
    private void beginningGame(){
        player.getEnteredLetters().clear();
        player.resetTryCount();
        while (true) {
            printGameState(secretWord,player);
            player.inputAnswer();
            if(ChecksAnswer.checkingUncorrectedInput(player.getAnswer(),secretWord.getText(),player.getEnteredLetters())){
                continue;
            }
            String answer = player.getAnswer();
            if (isLengthEqualsSecretWordLength(answer)) {
                if(ChecksAnswer.checkFullWord(player.getAnswer(),secretWord.getText())) {
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
                if(ChecksAnswer.isMaxError(player.getTryCount())){
                    isLose();
                    break;
                }
                if(isMaskEmpty(secretWord.getWordMask())){
                    System.out.println(Constants.YOU_WIN);
                    break;
                }
            }
        }
        private int requestDifficulty(){
               while (true){
                   System.out.println(Constants.SELECT_DIFFICULTY_TEMPLATE);
                   player.inputAnswer();
                   if(ChecksAnswer.checkIsEmpty(player.getAnswer())){
                       continue;
                   }
                   if(ChecksAnswer.isDifficultyValid(player.getAnswer())){
                       return Integer.parseInt(player.getAnswer());
                   }
                   else {
                       System.out.println(Constants.INVALID_INPUT);
                   }

               }

        }

        protected void printGameState(SecretWord secretWord, Player player){
            System.out.println(Constants.WORD_SECRET + secretWord.getWordMask());
            System.out.println(Constants.NUMBER_OF_TRY + player.getTryCount());
            System.out.println(Constants.ALREADY_USED + player.getEnteredLetters().toString());
            hangmanPicture.printHangman(player.getTryCount());
            System.out.println(Constants.ENTERED_LETTER);
        }

        private boolean isMaskEmpty(StringBuilder maskWord){
            return !maskWord.toString().contains(secretWord.getMaskSymbol());
        }

        private void workingWithInput(){
            if (ChecksAnswer.checkLetterInSecretWord(player.getAnswer(), secretWord.getText())) {
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
            System.out.println(Constants.WORD_SECRET + secretWord.getText() + "\n");
        }
        private boolean isLengthEqualsSecretWordLength(String s){
           return s.length() == secretWord.getText().length();
        }




    }
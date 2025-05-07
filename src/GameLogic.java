public class GameLogic {

    private static Player player;
    private static HangmanPicture hangmanPicture;
    private static SecretWord secretWord;



    public GameLogic(){
        player = new Player();
        hangmanPicture = new HangmanPicture();
        secretWord = new SecretWord();
        Dictionary dictionary = new Dictionary();
    }

    public void startGame(){
        while (GameLogic.startMenu()) {
            secretWord.guessTheWord();
            System.out.println(AppConstants.START_GAME);
            GameLogic.beginningGame();
        }
    }

    public static boolean startMenu(){
        while (true) {
            System.out.println(AppConstants.WELCOME);
            System.out.println(AppConstants.START_PROMPT);
            player.playerAnswer();
            if (player.getAnswer().equalsIgnoreCase(AppConstants.START)) {
                return true;
            } else if (player.getAnswer().equalsIgnoreCase(AppConstants.STOP)) {
                System.out.println(AppConstants.THANKS);
                return false;
            }
            else {
                System.out.println(AppConstants.INVALID_INPUT);
            }
        }
    }
    public static void beginningGame(){
        while (true) {
            GameLogic.printGameState(secretWord,player);

            player.playerAnswer();

            if(ChecksAnswer.checkingUncorrectedInput(player,secretWord)){
                continue;
            }
            if (player.getAnswer().length() == secretWord.getSecretWord().length()) {
                if(ChecksAnswer.checkFullWord(player,secretWord)) {
                    System.out.println(AppConstants.YOU_WIN);
                    player.getEnteredLetters().clear();
                    player.setTryCountNull();
                    break;
                }
                else {
                    System.out.println(AppConstants.YOU_MISTAKE);
                    player.setTryCount();
                    continue;
                }
            }
            if(ChecksAnswer.checkRepeatLetter(player)){
                System.out.println(AppConstants.REPEAT_INPUT);
                continue;
            }

             if (ChecksAnswer.checkLetterInSecretWord(player, secretWord)) {
                secretWord.letterReplacement(player);
                player.setEnteredLetters(player.getAnswer());

            }
             else {
                 System.out.printf(AppConstants.LETTTER_NOT, player.getAnswer());
                    player.setEnteredLetters(player.getAnswer());
                    player.setTryCount();

                }
                if(ChecksAnswer.checkIsTryCount(player)){
                    System.out.println(AppConstants.YOU_LOOSE);
                    System.out.println(AppConstants.WORD_SECRET + secretWord.getSecretWord() + "\n");
                    player.getEnteredLetters().clear();
                    player.setTryCountNull();
                    break;
                }
            }
        }
        public static void printGameState(SecretWord secretWord, Player player){
            System.out.println(AppConstants.WORD_SECRET + secretWord.getSecretWord());
            System.out.println(AppConstants.WORD_SECRET + secretWord.getWordMask());
            System.out.println(AppConstants.NUMBER_OF_TRY + player.getTryCount());
            System.out.println(AppConstants.ALREADY_USED + player.getEnteredLetters().toString());
            hangmanPicture.printHangman(player.getTryCount());
            System.out.println(AppConstants.ENTERED_LETTER);
        }

    }
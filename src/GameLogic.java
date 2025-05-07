public class GameLogic {

    private static Player player;
    private static HangmanPicture hangmanPicture;
    private static SecretWord secretWord;
    private static final String STOP = "Стоп";
    private static final String START = "Старт";
    private static final String NUMBER_OF_TRY = "Колличество ошибок: ";
    private static final String ENTERED_LETTER = "Введите букву или слово целиком";

    public GameLogic(){
        player = new Player();
        hangmanPicture = new HangmanPicture();
        secretWord = new SecretWord();
        Dictionary dictionary = new Dictionary();
    }

    public void startGame(){
        while (true){
            if(!GameLogic.startMenu()){
                break;
            }
            secretWord.guessTheWord();
            System.out.println("Игра начинается");
            GameLogic.beginningGame();



        }
    }

    public static boolean startMenu(){
        while (true) {
            System.out.println("Добро пожаловать в игру \"Виселица\"");
            System.out.println("Если хотите начать новую игру введите \"Старт\"" + "\n" + "Если хотите выйти введите \"Стоп\"");
            player.playerAnswer();
            if (player.getAnswer().equalsIgnoreCase(START)) {
                return true;
            } else if (player.getAnswer().equalsIgnoreCase(STOP)) {
                System.out.println("Спасибо за игру");
                return false;
            }
            else {
                System.out.println("Ввод не соответствует условию");
            }
        }
    }
    public static void beginningGame(){
        while (true) {
            System.out.println("Вам загадано слово: " + secretWord.getSecretWord());
            System.out.println("Вам загадано слово: " + secretWord.getWordMask());
            System.out.println(NUMBER_OF_TRY + player.getTryCount());
            System.out.println("Вы уже использовали: " + player.getEnteredLetters().toString());
            hangmanPicture.printHangman(player.getTryCount());
            System.out.println(ENTERED_LETTER);
            player.playerAnswer();
            if(ChecksAnswer.checkIsEmpty(player)){
                System.out.println("Вы ничего не ввели, повторите попытку.");
                continue;
            } else if (ChecksAnswer.checkIsNumber(player)) {
                System.out.println("Вы ввели цифру, повторите попытку");
                continue;
            }
            else if(ChecksAnswer.checkLength(player,secretWord)){
                System.out.println("Некоректный ввод, повторите попытку");
                continue;
            } else if (ChecksAnswer.checkEnglishLetters(player)) {
                System.out.println("Вы должны использовать только русский алфавит!");
                continue;
            } else if (ChecksAnswer.checkingForForbiddenChar(player)) {
                System.out.println("Вы ввели запрещенный символ!");
                continue;
            }
            else if(ChecksAnswer.checkForNumber(player.getAnswer())){
                System.out.println("Вы ввели цифру, повторите попытку");
            }
            if (player.getAnswer().length() == secretWord.getSecretWord().length()) {
                if(ChecksAnswer.checkFullWord(player,secretWord)) {
                    System.out.println("Вы угадали! Поздравляем");
                    break;
                }
                else {
                    System.out.println("Вы ошиблись!");
                    player.setTryCount();
                    continue;
                }
            }
            if(ChecksAnswer.checkRepeatLetter(player)){
                System.out.println("Вы уже вводили эту букву");
                continue;
            }

             if (ChecksAnswer.checkLetterInSecretWord(player, secretWord)) {
                secretWord.letterReplacement(player);
                player.setEnteredLetters(player.getAnswer());

            }
             else {
                 System.out.printf("Буквы: \"%s\" в слове нет.\n", player.getAnswer());
                    player.setEnteredLetters(player.getAnswer());
                    player.setTryCount();

                }
                if(ChecksAnswer.checkIsTryCount(player)){
                    System.out.println("Попытки закончились, вы проиграли");
                    System.out.println("Загаданное слово: " + secretWord.getSecretWord() + "\n");
                    break;
                }
            }
        }
    }
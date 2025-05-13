public final class ChecksAnswer {


    public static boolean checkFullWord(Player player, SecretWord secretWord){
        return player.getAnswer().equalsIgnoreCase(secretWord.getSecretWord());
    }

    public static boolean checkLetterInSecretWord(Player player, SecretWord secretWord){
        for (int i = 0; i < secretWord.getSecretWord().length(); i++) {
            if(player.getAnswer().charAt(0) == secretWord.getSecretWord().charAt(i)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkRepeatLetter(Player player){
        return player.getEnteredLetters().contains(player.getAnswer());
    }

    public static boolean checkIsEmpty(Player player){
        return player.getAnswer().isEmpty();
    }

    public static boolean checkIsNumber(Player player){
        return player.getAnswer().charAt(0) >= Constants.MIN_NUMBER && player.getAnswer().charAt(0) <= Constants.MAX_NUMBER;
    }

    public static boolean checkLength (Player player, SecretWord secretWord){
        return player.getAnswer().length() > 1 && player.getAnswer().length() != secretWord.getSecretWord().length();
    }
    public static boolean checkEnglishLetters(Player player){
        return player.getAnswer().matches(".*[a-zA-Z].*");
    }

    public static boolean checkingForForbiddenChar(Player player){
        return player.getAnswer().matches(".*[.,!@#$%^&*:;].*");
    }
    public static boolean checkIsTryCount(Player player){
        return player.getTryCount() >= Constants.MAX_TRY;
    }
    public static boolean checkingUncorrectedInput(Player player, SecretWord secretWord){
        if(ChecksAnswer.checkIsEmpty(player)){
            System.out.println("Вы ничего не ввели, повторите попытку.");
            return true;
        } else if (ChecksAnswer.checkIsNumber(player)) {
            System.out.println("Вы ввели цифру, повторите попытку");
            return true;
        }
        else if(ChecksAnswer.checkLength(player,secretWord)){
            System.out.println("Некоректный ввод, повторите попытку");
            return true;
        } else if (ChecksAnswer.checkEnglishLetters(player)) {
            System.out.println("Вы должны использовать только русский алфавит!");
            return true;
        } else if (ChecksAnswer.checkingForForbiddenChar(player)) {
            System.out.println("Вы ввели запрещенный символ!");
            return true;
        } else if (ChecksAnswer.checkRepeatLetter(player)) {
            System.out.println(Constants.REPEAT_INPUT);
            return true;
        }

        return false;
    }

}

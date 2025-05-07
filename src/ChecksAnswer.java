public class ChecksAnswer {


    public static boolean checkForNumber(String answer) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) >= '0' && answer.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFullWord(Player player, SecretWord secretWord){
         if(player.getAnswer().equalsIgnoreCase(secretWord.getSecretWord())){
             return true;
         }
         return false;
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
        if(player.getEnteredLetters().contains(player.getAnswer())){
            return true;
        }
        return false;
    }

    public static boolean checkIsEmpty(Player player){
        return player.getAnswer().isEmpty();
    }

    public static boolean checkIsNumber(Player player){
        if(player.getAnswer().charAt(0) >= '0' && player.getAnswer().charAt(0) <= '9'){
            return true;
        }
        return false;
    }

    public static boolean checkLength (Player player, SecretWord secretWord){
        if(player.getAnswer().length() > 1 && player.getAnswer().length() != secretWord.getSecretWord().length()){
            return true;
        }
        return false;
    }
    public static boolean checkEnglishLetters(Player player){
        return player.getAnswer().matches(".*[a-zA-Z].*");
    }

    public static boolean checkingForForbiddenChar(Player player){
        return player.getAnswer().matches(".*[.,!@#$%^&*].*");
    }
    public static boolean checkIsTryCount(Player player){
        return player.getTryCount() >= 6;
    }


}

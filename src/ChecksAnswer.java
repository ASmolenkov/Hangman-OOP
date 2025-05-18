import java.util.List;

public final class ChecksAnswer {


    public static boolean checkFullWord(String userInput, String hiddenWord){
        return userInput.equalsIgnoreCase(hiddenWord);
    }

    public static boolean checkLetterInSecretWord(String userInput, String hiddenWord){
        for (int i = 0; i < hiddenWord.length(); i++) {
            if(userInput.charAt(0) == hiddenWord.charAt(i)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkRepeatLetter(String userInput, List<String> enteredLetters){
        return enteredLetters.contains(userInput);
    }

    public static boolean checkIsEmpty(String userInput){
        return userInput.isEmpty();
    }

    public static boolean checkIsNumber(String userInput){
        return userInput.charAt(0) >= Constants.MIN_NUMBER && userInput.charAt(0) <= Constants.MAX_NUMBER;
    }

    public static boolean checkLength (String userInput, String hiddenWord){
        return userInput.length() > 1 && userInput.length() != hiddenWord.length();
    }
    public static boolean checkEnglishLetters(String userInput){
        return userInput.matches(".*[a-zA-Z].*");
    }

    public static boolean checkingForForbiddenChar(String userInput){
        return userInput.matches(".*[.,!@#$%^&*:;].*");
    }
    public static boolean isMaxError(int errorCount){
        return errorCount >= Constants.MAX_TRY;
    }
    public static boolean checkingUncorrectedInput(String userInput, String hiddenWord,List<String> enteredLetters){
        if(ChecksAnswer.checkIsEmpty(userInput)){
            System.out.println("Вы ничего не ввели, повторите попытку.");
            return true;
        } else if (ChecksAnswer.checkIsNumber(userInput)) {
            System.out.println("Вы ввели цифру, повторите попытку");
            return true;
        }
        else if(ChecksAnswer.checkLength(userInput,hiddenWord)){
            System.out.println("Некоректный ввод, повторите попытку");
            return true;
        } else if (ChecksAnswer.checkEnglishLetters(userInput)) {
            System.out.println("Вы должны использовать только русский алфавит!");
            return true;
        } else if (ChecksAnswer.checkingForForbiddenChar(userInput)) {
            System.out.println("Вы ввели запрещенный символ!");
            return true;
        } else if (ChecksAnswer.checkRepeatLetter(userInput,enteredLetters)) {
            System.out.println(Constants.REPEAT_INPUT);
            return true;
        }

        return false;
    }

}

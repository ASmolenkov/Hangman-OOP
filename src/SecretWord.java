import java.util.List;
import java.util.Random;

public class SecretWord {

    private final Dictionary DICTIONARY;
    private String secretWord;
    private StringBuilder wordMask;
    private StringBuilder wordMaskTest;

    public SecretWord(){
        DICTIONARY = new Dictionary();
        wordMaskTest = new StringBuilder();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public StringBuilder getWordMask() {
        return wordMask;
    }

    public StringBuilder getWordMaskTest() {
        return wordMaskTest;
    }

    public String guessTheWord(){
        Random random = new Random();
        List<String> dictionaryListWord = DICTIONARY.getListWord();
        this.secretWord = dictionaryListWord.get(random.nextInt(dictionaryListWord.size()));
        maskingWord();
        return secretWord;
    }
    public void maskingWord (){
        String CHAR_MASK = "■";
        wordMask = new StringBuilder(CHAR_MASK.repeat(secretWord.length()));
        wordMaskTest = wordMask;
    }

    public void letterReplacement(Player player){
        for (int i = 0; i < secretWord.length(); i++) {
            if(player.getAnswer().charAt(0) == secretWord.charAt(i)){
                wordMask.setCharAt(i,player.getAnswer().charAt(0));

            }
        }
    }

}

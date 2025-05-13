
public class SecretWord {


    private String text;
    private StringBuilder wordMask;
    private final String CHAR_MASK = "■";


    public SecretWord(String text){
        this.text = text;
    }

    public String getSecretWord() {
        return text;
    }

    public StringBuilder getWordMask() {
        return wordMask;
    }

    public String getCHAR_MASK() {
        return CHAR_MASK;
    }

    public void maskingWord (){
        wordMask = new StringBuilder(CHAR_MASK.repeat(text.length()));

    }

    public void letterReplacement(char letter){
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == letter){
                wordMask.setCharAt(i,letter);

            }
        }
    }

}

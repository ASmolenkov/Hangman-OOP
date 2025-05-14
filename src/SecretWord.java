
public class SecretWord {


    private String text;
    private StringBuilder wordMask;
    private static final String MASK_SYMBOL = "■";


    public SecretWord(String text){
        this.text = text;
        createMask();
    }

    public String getSecretWord() {
        return text;
    }

    public StringBuilder getWordMask() {
        return wordMask;
    }

    public String getMaskSymbol() {
        return MASK_SYMBOL;
    }

    private void createMask(){
        wordMask = new StringBuilder(MASK_SYMBOL.repeat(text.length()));

    }

    public void letterReplacement(char letter){
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == letter){
                wordMask.setCharAt(i,letter);

            }
        }
    }

}

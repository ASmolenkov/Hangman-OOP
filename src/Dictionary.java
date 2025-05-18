import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dictionary {

    private  List<String> easyWord;
    private  List<String> mediumWord;
    private  List<String> hardWord;


    public Dictionary(String path){
        this.easyWord = new ArrayList<>();
        this.mediumWord = new ArrayList<>();
        this.hardWord = new ArrayList<>();
            divideDifficulty(path);
    }

    public List<String> getEasyWord() {
        return easyWord;
    }

    public List<String> getMediumWord() {
        return mediumWord;
    }

    public List<String> getHardWord() {
        return hardWord;
    }

    private void divideDifficulty(String path){
        File dictionaryFile = new File(path);
        try {
            Scanner scanner = new Scanner(dictionaryFile);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (word.length() <= 6) {
                    easyWord.add(word);
                } else if (word.length() <= 10) {
                    mediumWord.add(word);
                } else {
                    hardWord.add(word);
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Файл со словарем не найден!");
        }

    }

}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Dictionary {


    private  List<String> listWord;


    public Dictionary(String path){

        try {
            listWord = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Файл со словарем не найден!");
        }
    }

    public  List<String> getWords() {
        return listWord;
    }

}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Dictionary {

    private List<String> listWord;

    public Dictionary(){
        try {
            listWord = Files.readAllLines(Paths.get("dictionary"));
        } catch (IOException e) {
            System.out.println("Файл со словарем не найден!");
        }
    }

    public List<String> getListWord() {
        return listWord;
    }
}

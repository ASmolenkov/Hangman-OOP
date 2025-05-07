public class HangmanPicture {

    String[] hangmanPicture;

    public HangmanPicture(){
        hangmanPicture = new String[]{
                """
  +---+
  |   |
      |
      |
      |
      |
=========""", """
  +---+
  |   |
  O   |
      |
      |
      |
=========""",
                """
  +---+
  |   |
  O   |
  |   |
      |
      |
=========""",
                """
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========""",

                """
  +---+
  |   |
  O   |
 /|\\  |
      |
      |
=========""",
                """
  +---+
  |   |
  O   |
 /|\\  |
 /    |
      |
=========""",
                """
  +---+
  |   |
  O   |
 /|\\  |
 / \\  |
      |
========="""
        };
    }

    public String[] getHangmanPicture() {
        return hangmanPicture;
    }
    public void printHangman(int tryCount){
        System.out.println(hangmanPicture[tryCount]);
    }

}

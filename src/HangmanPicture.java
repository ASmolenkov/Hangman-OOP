public class HangmanPicture {

    String[] hangmanPicture = new String[]{
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

    public void printHangman(int tryCount){
        System.out.println(hangmanPicture[tryCount]);
    }

}

public class HangmanPicture {

    private static final String[] HANGMAN_PICTURE = new String[]{
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
        System.out.println(HangmanPicture.HANGMAN_PICTURE[tryCount]);
    }

}

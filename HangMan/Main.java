import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Main {

  static int chance = 5;

  static void wordChecker(String playerWord, char usrInput) {
    playerWord = playerWord.toLowerCase();
    int wordLength = playerWord.length();
    boolean correct = false;
    char[] blanks = new char[100];
    // just for checking all the words are converted to lowerCase

    for (int i = 0; i < wordLength; i++) {
      if (playerWord.charAt(i) == usrInput) {
        blanks[i] = usrInput;
        System.out.println("Correct!!!");
        correct = true;
      } else {
        blanks[i] = '_';
      }
    }
    if (!correct) {
      chance--;
    }

    for (int i = 0; i < wordLength; i++) {
      System.out.printf("%c", blanks[i]);
    }
    System.out.println();

  }

  static void tui(String playerWord) {
  }

  static void tuiUpdater(char usrInput) {
    // TODO : make this shit work. usrinput is working flawless. left off is
    // update
    // the tui after
    // the user inputs right char
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random random = new Random(System.currentTimeMillis());

    ArrayList<String> words = new ArrayList<>();
    words.add(0, "HelloWorld");
    words.add(1, "Java");
    words.add(2, "Elephant");
    words.add(3, "Heaven");

    ArrayList<String> hints = new ArrayList<>();
    hints.add(0, "First word of a programmer.");
    hints.add(1, "Programming language that this program in used to write.");
    hints.add(2, "Largest land mammal.");
    hints.add(3, "Final destiny");

    int rand = random.nextInt(3);
    String playerWord = words.get(rand);

    System.out.println("Welcome to hangman game!!!");

    System.out.println("Your word is: " + hints.get(rand));

    while (chance > 0) {
      tui(playerWord);
      System.out.print("Enter your guess word: ");
      char usrInput = scan.next().charAt(0);
      usrInput = Character.toLowerCase(usrInput);
      wordChecker(playerWord, usrInput);
    }
    scan.close();
  }
}

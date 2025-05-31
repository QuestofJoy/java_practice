import java.util.Scanner;
import java.util.Random;

class Main {

  static int chance = 5;

  static boolean inpChecker(String playerWord, char[] blanks, char usrInput) {
    boolean found = false;
    playerWord = playerWord.toLowerCase();

    for (int i = 0; i < playerWord.length(); i++) {
      if (usrInput == playerWord.charAt(i)) {
        blanks[i] = playerWord.charAt(i);
        found = true;
      }
    }

    if (!found) {
      System.out.println("word not found");
      chance--;
    } else {
      System.out.println("word found");
    }
    String usrInputWord = new String(blanks);
    System.out.println(usrInputWord);

    boolean clear = false;
    clear = usrInputWord.equals(playerWord);
    return clear;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random random = new Random(System.currentTimeMillis());

    String[] words = new String[100];
    words[0] = "HelloWorld";
    words[1] = "Java";
    words[2] = "Elephant";
    words[3] = "Heaven";

    String[] hints = new String[100];
    hints[0] = "First word of a programmer.";
    hints[1] = "Programming language that this program in used to write.";
    hints[2] = "Largest land mammal.";
    hints[3] = "Final destiny";

    int rand = random.nextInt(4);
    String playerWord = words[rand];
    boolean wordClear = false;

    char[] blanks = new char[playerWord.length()];
    for (int i = 0; i < playerWord.length(); i++) {
      blanks[i] = '_';
    }

    System.out.println("Welcome to hangman game!!!");
    System.out.println("Your word is: " + hints[rand]);
    System.out.println(blanks);

    while (chance > 0 && !wordClear) {
      System.out.printf("Enter your guess: ");
      char usrInput = scan.next().charAt(0);
      wordClear = inpChecker(playerWord, blanks, usrInput);
    }
    if (chance == 0) {
      System.out.println("nice try. Better LUCK NEXT FUCKING TIMEE 󱁆");
    } else {
      System.out.println("well done. congratulations. yayy󱥋󱥋󱥋");
    }
    scan.close();
  }
}

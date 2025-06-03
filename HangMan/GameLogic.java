import java.util.Scanner;
import java.util.Random;

public class GameLogic {
  private String playerWord;
  private String playerHint;
  private int chance;

  Menu menu = new Menu();

  public void Game() {
    int selectedOption = menu.menuList();
    switch (selectedOption) {
      case 1:
        runGame();
        break;
    }
  }

  public void runGame() {

    Random random = new Random(System.currentTimeMillis());

    int wordNumber = random.nextInt(3);
    this.playerWord = GameData.getWords().get(wordNumber);
    this.playerHint = GameData.getHints().get(wordNumber);

    int wordLength = playerWord.length();

    StringBuilder blanks = new StringBuilder();
    for (int i = 0; i < wordLength; i++) {
      blanks.append("_");
    }

    boolean running = true;

    while (running) {
      menu.head();
      System.out.println("Hint for your word is: " + playerHint);
      System.out.println(blanks);
      System.out.printf("Enter your guess: ");
      char userChar = scan.next().charAt(0);
      blanks = wordChecker(playerWord, userChar, blanks);
      ClearScreen.clearScreen(350);
    }
  }

  static StringBuilder wordChecker(String playerWord, char userChar, StringBuilder blanks) {
    int wordLength = playerWord.length();
    boolean wordFound = false;
    for (int i = 0; i < wordLength; i++) {
      if (userChar == playerWord.charAt(i)) {
        blanks.setCharAt(i, playerWord.charAt(i));
        wordFound = true;
      }
    }

    if (wordFound) {
      System.out.println("word found!");
    } else {
      System.out.println("word not found");
    }

    return blanks;
  }

}

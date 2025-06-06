import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    InitializeData initializeData = new InitializeData();
    ClearScreen.clearScreen();
    GameLogic gl = new GameLogic();
    gl.runGame();
    scan.close();
  }
}
